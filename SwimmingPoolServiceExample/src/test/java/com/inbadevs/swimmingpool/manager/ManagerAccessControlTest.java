package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.AssistanceFreeHoursPlanDao;
import com.inbadevs.swimmingpool.dao.CountLeftHoursFreeHoursPlanDao;
import com.inbadevs.swimmingpool.dao.ProductDao;
import com.inbadevs.swimmingpool.dao.UserDao;
import com.inbadevs.swimmingpool.entities.*;
import com.inbadevs.swimmingpool.exceptions.ControlEntranceException;
import com.inbadevs.swimmingpool.exceptions.ControlExitException;
import com.inbadevs.swimmingpool.service.entityresponse.ControlAccessResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ManagerAccessControlTest {

    private ManagerAccessControl manager;

    @Mock
    UserDao userDao;

    @Mock
    ProductDao productDao;

    @Mock
    AssistanceFreeHoursPlanDao assistanceFreeHoursPlanDao;

    @Mock
    private CountLeftHoursFreeHoursPlanDao countLeftHoursFreeHoursPlanDao;

    private User user;
    private Plan planTypeFreeHours;
    private Plan planTypeBlockHours;

    @Before
    public void setUp() throws Exception {

        manager = new ManagerAccessControl(userDao, productDao, assistanceFreeHoursPlanDao, countLeftHoursFreeHoursPlanDao);
        user = new User(null, null, null, "userNames", null, null, null, null, null, null, null, null, 0);
        planTypeFreeHours = new Plan(Long.parseLong("1"), "name", "description", Long.parseLong("5000"),
                "typeHoursPerWeek", 5, null);
        planTypeBlockHours = new Plan(Long.parseLong("1"), "name", "description", Long.parseLong("5000"),
                "typeBlocksPerWeek", 5, null);
    }

    private String operatesAndParseDate(Date date, int calendar, int amount){

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(calendar, amount);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(cal.getTime());
    }

    @Test(expected = ControlEntranceException.class)
    public void testIsUserAccessControlWhenTodayIsOutOfRangesDate() throws Exception, ControlEntranceException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.MONTH, +3);
        String endValidDate = operatesAndParseDate(today, Calendar.MONTH, +4);

        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate, endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);

        manager.isUserAccessControlEntrance(user.getId(), product.getId());

    }

    @Test
    public void testIsUserAccessControlEntranceWhenTodayIsInnerRangesDateAndNonExistsCountLeftHours() throws Exception, ControlEntranceException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);

        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(countLeftHoursFreeHoursPlanDao.find(user,planTypeFreeHours)).thenReturn(null);

        ControlAccessResponse controlAccessResponse = manager.isUserAccessControlEntrance(user.getId(), product.getId());

        /*final ControlAccessResponse controlAccessResponse1 = new ControlAccessResponse(user.getNames(),
                planTypeFreeHours.getName(),
                Double.valueOf((planTypeFreeHours.getHoursPerWeek() * 4)),
                Double.valueOf(planTypeFreeHours.getHoursPerWeek() * 4));*/

        //TODO verify assertions object to object
        assertThat(controlAccessResponse.getUserName(), is(equalTo("userNames")));
        assertThat(controlAccessResponse.getLeftHours(), is(equalTo(Double.parseDouble("20"))));


    }

    @Test
    public void testIsUserAccessControlEntranceWhenTodayIsInnerRangesDateAndExistCountLeftHours() throws Exception, ControlEntranceException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);

        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);

        Integer hoursLeft = planTypeFreeHours.getHoursPerWeek() - 3;

        when(countLeftHoursFreeHoursPlanDao.find(user,planTypeFreeHours)).thenReturn(new CountLeftHoursFreeHoursPlan(user,
                planTypeFreeHours, Double.parseDouble(hoursLeft.toString())));

        ControlAccessResponse controlAccessResponse = manager.isUserAccessControlEntrance(user.getId(), product.getId());

        assertThat(controlAccessResponse.getUserName(), is(equalTo("userNames")));
        assertThat(controlAccessResponse.getLeftHours(), is(equalTo(Double.parseDouble("2"))));


    }


    @Test(expected = ControlExitException.class)
    public void testIsUserAccessControlExitWhenUserNeverEntrance() throws Exception, ControlExitException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(assistanceFreeHoursPlanDao.findLastEntrance(user, planTypeFreeHours)).thenReturn(null);

        manager.isUserAccessControlExit(user.getId(), product.getId());
    }

    @Test
    public void testIsUserAccessControlExitWhenCountLeftHoursFreeHoursPlanIsNull() throws Exception, ControlExitException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        final Date entranceDate = new Date();

        final AssistanceFreeHoursPlan assistanceFreeHoursPlan = new AssistanceFreeHoursPlan(Long.parseLong("1"), user, planTypeFreeHours, true, entranceDate, null);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(assistanceFreeHoursPlanDao.findLastEntrance(user, planTypeFreeHours)).thenReturn(
                assistanceFreeHoursPlan);
        when(countLeftHoursFreeHoursPlanDao.find(user, planTypeFreeHours)).thenReturn(null);

        ControlAccessResponse response = manager.isUserAccessControlExit(user.getId(), product.getId());

        assertThat(response.getLeftHours(), is(lessThanOrEqualTo(Double.parseDouble(String.valueOf(planTypeFreeHours.getHoursPerWeek() * 4)))));

    }

    @Test
    public void testIsUserAccessControlExitWhenCountLeftHoursFreeHoursPlanIsNotNull() throws Exception, ControlExitException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        final Date entranceDate = new Date();

        final AssistanceFreeHoursPlan assistanceFreeHoursPlan = new AssistanceFreeHoursPlan(Long.parseLong("1"), user, planTypeFreeHours, true, entranceDate, null);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(assistanceFreeHoursPlanDao.findLastEntrance(user, planTypeFreeHours)).thenReturn(
                assistanceFreeHoursPlan);
        when(countLeftHoursFreeHoursPlanDao.find(user, planTypeFreeHours)).thenReturn(
                new CountLeftHoursFreeHoursPlan(user, planTypeFreeHours,
                        Double.parseDouble(String.valueOf((planTypeFreeHours.getHoursPerWeek() * 4)  - 5))));

        ControlAccessResponse response = manager.isUserAccessControlExit(user.getId(), product.getId());

        assertThat(response.getLeftHours(), is(lessThanOrEqualTo(Double.parseDouble(String.valueOf(planTypeFreeHours.getHoursPerWeek() * 3)))));

    }

    @Test
    public void testIsUserAccessControlEntranceWhenSchedulePlanAndDaySectionIsValidWithTodayTime() throws Exception, ControlEntranceException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        List<DaySection> daySectionList = new ArrayList<>();

        Section section = new Section(1, new Time(0,0,0), new Time(1,0,0));
        Day day = new Day(1, "Monday");
        DaySectionPK daySectionPk = new DaySectionPK(section, day);
        DaySection daySection = new DaySection(1, daySectionPk);
        daySectionList.add(daySection);

        Schedule schedule = new Schedule(Long.parseLong("1"), "horario", "description", planTypeBlockHours, daySectionList);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeBlockHours, schedule), startValidDate,
                endValidDate);

        Calendar todayCal = Calendar.getInstance();
        todayCal.set(2015, 6, 20, 0, 20);

        manager.setToday(todayCal.getTime());

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);

        ControlAccessResponse response = manager.isUserAccessControlEntrance(user.getId(), product.getId());

        assertNotNull(response);

    }

    @Test(expected = ControlEntranceException.class)
    public void testIsUserAccessControlEntranceWhenSchedulePlanAndDaySectionIsInValidWithTodayTime() throws Exception, ControlEntranceException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        List<DaySection> daySectionList = new ArrayList<>();

        Section section = new Section(1, new Time(0,0,0), new Time(1,0,0));
        Day day = new Day(1, "Monday");
        DaySectionPK daySectionPk = new DaySectionPK(section, day);
        DaySection daySection = new DaySection(1, daySectionPk);
        daySectionList.add(daySection);

        Schedule schedule = new Schedule(Long.parseLong("1"), "horario", "description", planTypeBlockHours, daySectionList);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeBlockHours, schedule), startValidDate,
                endValidDate);

        Calendar todayCal = Calendar.getInstance();
        todayCal.set(2015,6,20,1,20);

        manager.setToday(todayCal.getTime());

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);

        manager.isUserAccessControlEntrance(user.getId(), product.getId());

    }


}