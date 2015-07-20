        package com.inbadevs.swimmingpool.manager;

        import com.inbadevs.swimmingpool.dao.AssistanceFreeHoursPlanDao;
        import com.inbadevs.swimmingpool.dao.CountLeftHoursFreeHoursPlanDao;
        import com.inbadevs.swimmingpool.dao.ProductDao;
        import com.inbadevs.swimmingpool.dao.UserDao;
        import com.inbadevs.swimmingpool.entities.*;
        import com.inbadevs.swimmingpool.exceptions.ControlEntranceException;
        import com.inbadevs.swimmingpool.exceptions.ControlExitException;
        import com.inbadevs.swimmingpool.service.entityresponse.ControlAccessResponse;
        import javassist.NotFoundException;
        import lombok.Setter;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

        import java.sql.Time;
        import java.text.DateFormatSymbols;
        import java.text.ParsePosition;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;

        @Component
        public class ManagerAccessControl {

            private UserDao userDao;
            private ProductDao productDao;
            private AssistanceFreeHoursPlanDao assistanceFreeHoursPlanDao;
            private CountLeftHoursFreeHoursPlanDao countLeftHoursFreeHoursPlanDao;
            @Setter
            private Date today;

            @Autowired
            public ManagerAccessControl(UserDao userDao, ProductDao productDao,
                                        AssistanceFreeHoursPlanDao assistanceFreeHoursPlanDao,
                                        CountLeftHoursFreeHoursPlanDao countLeftHoursFreeHoursPlanDao){
                this.userDao = userDao;
                this.productDao = productDao;
                this.assistanceFreeHoursPlanDao = assistanceFreeHoursPlanDao;
                this.countLeftHoursFreeHoursPlanDao = countLeftHoursFreeHoursPlanDao;
            }

            public ManagerAccessControl() {}


            public ControlAccessResponse isUserAccessControlEntrance(Long userId, Long productId) throws NotFoundException, ControlEntranceException {

                User user = this.userDao.find(userId);
                Product product = this.productDao.find(productId);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date startValidDate = dateFormat.parse(product.getStartValidDate(), new ParsePosition(0));
                Date endValidDate = dateFormat.parse(product.getEndValidDate(), new ParsePosition(0));

                today =  (today != null) ? today: new Date();

                if(today.after(startValidDate) && today.before(endValidDate)){

                    Plan plan = product.getProductPK().getPlan();

                    final String typeHoursPerWeek = "typeHoursPerWeek";
                    final String typeBlocksPerWeek = "typeBlocksPerWeek";


                    if(product.getProductPK().getPlan().getTypeOfPlan().equals(typeHoursPerWeek)) {

                        return controlEntranceFreeHours(user, product, plan);

                    }
                    else if(product.getProductPK().getPlan().getTypeOfPlan().equals(typeBlocksPerWeek)){

                        return controlEntranceSchedule(user, product, today);
                    }


                }
                else {
                    throw new ControlEntranceException("range");
                }

                return null;

            }

            private ControlAccessResponse controlEntranceSchedule(User user, Product product, Date today) throws ControlEntranceException {

                Schedule schedule = product.getProductPK().getSchedule();

                for(DaySection daySection: schedule.getDaySection()){

                    String day = daySection.getDaySection().getDay().getName();

                    Calendar todayCal = Calendar.getInstance();
                    todayCal.setTime(today);
                    int val = todayCal.get(Calendar.DAY_OF_WEEK);
                    String dayOfWeek = new DateFormatSymbols().getWeekdays()[val];

                    if(day.equals(dayOfWeek)){

                        Time start = daySection.getDaySection().getSection().getStart();
                        Calendar startCal = Calendar.getInstance();
                        startCal.setTime(start);
                        startCal.set(Calendar.DAY_OF_YEAR, todayCal.get(Calendar.DAY_OF_YEAR));
                        startCal.set(Calendar.YEAR, todayCal.get(Calendar.YEAR));

                        Time end = daySection.getDaySection().getSection().getEnd();
                        Calendar endCal = Calendar.getInstance();
                        endCal.setTime(end);
                        endCal.set(Calendar.DAY_OF_YEAR, todayCal.get(Calendar.DAY_OF_YEAR));
                        endCal.set(Calendar.YEAR, todayCal.get(Calendar.YEAR));

                        if(todayCal.after(startCal) && todayCal.before(endCal)){
                            assistanceFreeHoursPlanDao.save(new AssistanceFreeHoursPlan(user, product.getProductPK().getPlan()));
                            return new ControlAccessResponse(user.getNames(), schedule.getName(), null, null, true);
                        }

                    }
                    else{
                        throw new ControlEntranceException("invalid entrance, review schedule");
                    }

                }

                throw new ControlEntranceException("invalid entrance, schedule without daySection");
            }

            private ControlAccessResponse controlEntranceFreeHours(User user, Product product, Plan plan) {

                assistanceFreeHoursPlanDao.save(new AssistanceFreeHoursPlan(user, product.getProductPK().getPlan()));
                final Double hours = Double.valueOf(plan.getHoursPerWeek() * 4);
                Double hoursLeft = hours;

                CountLeftHoursFreeHoursPlan countHoursLeft = countLeftHoursFreeHoursPlanDao.find(user, plan);

                if(countHoursLeft != null){
                    hoursLeft = countHoursLeft.getHoursLeft();
                }

                return new ControlAccessResponse(user.getNames(), plan.getName(), hours, hoursLeft, false);
            }

            public ControlAccessResponse isUserAccessControlExit(Long userId, Long productId) throws NotFoundException, ControlExitException {

                User user = this.userDao.find(userId);
                Product product = this.productDao.find(productId);
                Date today = new Date();
                Plan plan = product.getProductPK().getPlan();

                if(plan.getTypeOfPlan().equals("typeHoursPerWeek")) {

                    AssistanceFreeHoursPlan assistanceFreeHoursPlan = assistanceFreeHoursPlanDao.findLastEntrance(user, plan);

                    if(assistanceFreeHoursPlan == null){
                        throw new ControlExitException("never entrance");
                    }

                    Long difference = today.getTime() - assistanceFreeHoursPlan.getEntranceDate().getTime();
                    Double differenceHours = Double.valueOf(difference) / 3600000;

                    CountLeftHoursFreeHoursPlan countHoursLeft = countLeftHoursFreeHoursPlanDao.find(user, plan);

                    Double hoursLeft;

                    if(countHoursLeft != null){
                        hoursLeft = countHoursLeft.getHoursLeft() - differenceHours;
                        countHoursLeft.setHoursLeft(hoursLeft);
                    }
                    else{
                        hoursLeft = Double.valueOf(plan.getHoursPerWeek() * 4) - differenceHours;
                        countLeftHoursFreeHoursPlanDao.save(new CountLeftHoursFreeHoursPlan(user, plan, hoursLeft));
                    }

                    assistanceFreeHoursPlan.setEntrance(false);
                    assistanceFreeHoursPlan.setExitDate(today);

                    return new ControlAccessResponse(user.getNames(), plan.getName(), Double.valueOf(plan.getHoursPerWeek() * 4) ,
                            hoursLeft, false);

                }

                return null;
            }



            private void isUserAccessControlFreeHoursPlanEntrance(User user, Product product, Date today) throws ControlEntranceException {

                final String typeHoursPerWeek = "typeHoursPerWeek";
                final String typeBlocksPerWeek = "typeBlocksPerWeek";


                if(product.getProductPK().getPlan().getTypeOfPlan().equals(typeHoursPerWeek)) {

                    assistanceFreeHoursPlanDao.save(new AssistanceFreeHoursPlan(user, product.getProductPK().getPlan()));

                }
                else if(product.getProductPK().getPlan().getTypeOfPlan().equals(typeBlocksPerWeek)){

                    Schedule schedule = product.getProductPK().getSchedule();


                    for(DaySection daySection: schedule.getDaySection()){

                        Day day = daySection.getDaySection().getDay();

                        Time start = daySection.getDaySection().getSection().getStart();
                        Calendar startCal = Calendar.getInstance();
                        startCal.setTime(start);


                        Time end = daySection.getDaySection().getSection().getStart();
                        Calendar endCal = Calendar.getInstance();
                        endCal.setTime(end);

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(today);
                        int val = cal.get(Calendar.DAY_OF_WEEK);
                        String dayOfWeek = new DateFormatSymbols().getWeekdays()[val];


                        Calendar todayCal = Calendar.getInstance();
                        todayCal.setTime(today);

                        if(day.equals(dayOfWeek) && (todayCal.after(startCal) && todayCal.before(endCal))){
                            assistanceFreeHoursPlanDao.save(new AssistanceFreeHoursPlan(user, product.getProductPK().getPlan()));
                        }
                        else{

                            throw new ControlEntranceException("invalid entrance, review schedule");
                        }

                    }

                }
            }
        }
