package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.AssistanceSchedulePlanDao;
import com.inbadevs.swimmingpool.dao.CountLeftHoursSchedulePlanDao;
import com.inbadevs.swimmingpool.entities.*;
import com.inbadevs.swimmingpool.exceptions.ControlEntranceException;
import com.inbadevs.swimmingpool.manager.controlAccess.ScheduleAccess;
import com.inbadevs.swimmingpool.service.entityresponse.ControlAccessResponse;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by macbook on 8/8/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class ScheduleAccessTest extends ControlAccessAbstract {

    private ScheduleAccess manager;

    @Mock
    private AssistanceSchedulePlanDao assistanceSchedulePlanDao;

    @Mock
    private CountLeftHoursSchedulePlanDao countLeftHoursSchedulePlanDao;

    private Plan planTypeBlockHours;

    @Before
    public void setUp() throws Exception {

        user = new User(null, null, null, "userNames", null, null, null, null, null, null, null, null, 0);
        manager = new ScheduleAccess(assistanceSchedulePlanDao, countLeftHoursSchedulePlanDao);
        planTypeBlockHours = new Plan(Long.parseLong("1"), "name", "description", Long.parseLong("5000"),
                "typeBlocksPerWeek", 5, null);

    }

    @Test
    public void testIsUserAccessControlEntranceWhenSchedulePlanAndDaySectionIsValidWithTodayTimeAndFirstEntrance() throws Exception, ControlEntranceException {

        Calendar todayCal = Calendar.getInstance();
        todayCal.set(2015, 6, 10, 6, 40,1); //

        String startValidDate = operatesAndParseDate(todayCal.getTime(), Calendar.DAY_OF_MONTH, -7);
        String endValidDate = operatesAndParseDate(todayCal.getTime(), Calendar.DAY_OF_MONTH, +7);
        List<DaySection> daySectionList = new ArrayList<>();

        Section section = new Section(1, new Time(0,0,0), new Time(1,0,0));
        Day day = new Day(1, "Monday");
        DaySectionPK daySectionPk = new DaySectionPK(section, day);
        DaySection daySection = new DaySection(1, daySectionPk);

        Section section2 = new Section(2, new Time(7,0,0), new Time(8,0,0));
        Day day2 = new Day(2, "Friday");
        DaySectionPK daySectionPk2 = new DaySectionPK(section2, day2);
        DaySection daySection2 = new DaySection(2, daySectionPk2);

        daySectionList.add(daySection);
        daySectionList.add(daySection2);

        Schedule schedule = new Schedule(Long.parseLong("1"), "horario", "description", planTypeBlockHours, daySectionList);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeBlockHours, schedule), startValidDate,
                endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(countLeftHoursSchedulePlanDao.find(user, product)).thenReturn(null);

        ControlAccessResponse response = manager.controlEntrance(user, product, todayCal.getTime());

        assertThat(response.getBlocksOfPlan(), is(equalTo(3)));
        assertThat(response.getPenaltyHours(), is(equalTo(0)));

    }

    @Test
    @Ignore
    public void testIsUserAccessControlEntranceWhenSchedulePlanAndDaySectionIsValidWithTodayTimeAndFirstEntranceAndLastBlock() throws Exception, ControlEntranceException {

        Calendar todayCal = Calendar.getInstance();
        todayCal.set(2015, 6, 10, 6, 40,1); //

        String startValidDate = operatesAndParseDate(todayCal.getTime(), Calendar.DAY_OF_MONTH, -7);
        String endValidDate = operatesAndParseDate(todayCal.getTime(), Calendar.DAY_OF_MONTH, +7);
        List<DaySection> daySectionList = new ArrayList<>();

        Section section = new Section(1, new Time(0,0,0), new Time(1,0,0));
        Day day = new Day(1, "Monday");
        DaySectionPK daySectionPk = new DaySectionPK(section, day);
        DaySection daySection = new DaySection(1, daySectionPk);

        Section section2 = new Section(2, new Time(7,0,0), new Time(8,0,0));
        Day day2 = new Day(2, "Friday");
        DaySectionPK daySectionPk2 = new DaySectionPK(section2, day2);
        DaySection daySection2 = new DaySection(2, daySectionPk2);

        daySectionList.add(daySection);
        daySectionList.add(daySection2);

        Schedule schedule = new Schedule(Long.parseLong("1"), "horario", "description", planTypeBlockHours, daySectionList);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeBlockHours, schedule), startValidDate,
                endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(countLeftHoursSchedulePlanDao.find(user, product)).thenReturn(null);

        todayCal.set(2015, 6, 17, 6, 40, 1); //

        ControlAccessResponse response = manager.controlEntrance(user, product, todayCal.getTime());

        assertThat(response.getBlocksOfPlan(), is(equalTo(1)));
        assertThat(response.getPenaltyHours(), is(equalTo(0)));

    }

    @Test(expected = ControlEntranceException.class)
    public void testIsUserAccessControlEntranceWhenSchedulePlanAndDaySectionIsInValidWithTodayTime() throws Exception, ControlEntranceException {

        Calendar todayCal = Calendar.getInstance();
        todayCal.set(2015,6,20,1,20);

        String startValidDate = operatesAndParseDate(todayCal.getTime(), Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(todayCal.getTime(), Calendar.DAY_OF_MONTH, +3);
        List<DaySection> daySectionList = new ArrayList<>();

        Section section = new Section(1, new Time(0,0,0), new Time(1,0,0));
        Day day = new Day(1, "Monday");
        DaySectionPK daySectionPk = new DaySectionPK(section, day);
        DaySection daySection = new DaySection(1, daySectionPk);
        daySectionList.add(daySection);

        Schedule schedule = new Schedule(Long.parseLong("1"), "horario", "description", planTypeBlockHours, daySectionList);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeBlockHours, schedule), startValidDate,
                endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);

        ControlAccessResponse response = manager.controlEntrance(user, product, todayCal.getTime());

    }

}
