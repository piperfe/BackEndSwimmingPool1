package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.AssistanceFreeHoursPlanDao;
import com.inbadevs.swimmingpool.dao.CountLeftHoursFreeHoursPlanDao;
import com.inbadevs.swimmingpool.entities.*;
import com.inbadevs.swimmingpool.exceptions.ControlEntranceException;
import com.inbadevs.swimmingpool.exceptions.ControlExitException;
import com.inbadevs.swimmingpool.manager.controlAccess.FreeHoursAccess;
import com.inbadevs.swimmingpool.service.entityresponse.ControlAccessResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by macbook on 8/8/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class FreeHoursAccessTest extends ControlAccessAbstract {

    private FreeHoursAccess manager;

    @Mock
    private AssistanceFreeHoursPlanDao assistanceFreeHoursPlanDao;

    @Mock
    private CountLeftHoursFreeHoursPlanDao countLeftHoursFreeHoursPlanDao;

    private Plan planTypeFreeHours;

    @Before
    public void setUp() throws Exception {

        user = new User(null, null, null, "userNames", null, null, null, null, null, null, null, null, 0);
        manager = new FreeHoursAccess(assistanceFreeHoursPlanDao, countLeftHoursFreeHoursPlanDao);
        planTypeFreeHours = new Plan(Long.parseLong("1"), "name", "description", Long.parseLong("5000"),
                "typeBlocksPerWeek", 5, null);

    }


    @Test
    public void testEntranceWhenTodayIsInnerRangesDateAndNonExistsCountLeftHours() throws Exception, ControlEntranceException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);

        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(countLeftHoursFreeHoursPlanDao.find(user,planTypeFreeHours)).thenReturn(null);

        ControlAccessResponse controlAccessResponse = manager.controlEntrance(user, product, today);


        assertThat(controlAccessResponse.getUserName(), is(equalTo("userNames")));
        assertThat(controlAccessResponse.getLeftHours(), is(equalTo(20)));

    }

    @Test
    public void testEntranceWhenTodayIsInnerRangesDateAndExistCountLeftHours() throws Exception, ControlEntranceException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);

        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);

        Integer hoursLeft = planTypeFreeHours.getHoursPerWeek() - 3;

        when(countLeftHoursFreeHoursPlanDao.find(user,planTypeFreeHours)).thenReturn(new CountLeftHoursFreeHoursPlan(user,
                planTypeFreeHours, hoursLeft));

        ControlAccessResponse controlAccessResponse = manager.controlEntrance(user, product, today);

        assertThat(controlAccessResponse.getUserName(), is(equalTo("userNames")));
        assertThat(controlAccessResponse.getLeftHours(), is(equalTo(2)));


    }


    @Test(expected = ControlExitException.class)
    public void testExitWhenUserNeverEntrance() throws Exception, ControlExitException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(assistanceFreeHoursPlanDao.findLastEntrance(user, planTypeFreeHours)).thenReturn(null);

        ControlAccessResponse controlAccessResponse = manager.controlExit(user, product, today);
    }

    @Test(expected = ControlExitException.class)
    public void testExitWhenUserExitBeforeEntrance() throws Exception, ControlExitException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        final AssistanceFreeHoursPlan assistanceFreeHoursPlan = new AssistanceFreeHoursPlan(Long.parseLong("1"),
                user, planTypeFreeHours, false, null, null);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(assistanceFreeHoursPlanDao.findLastEntrance(user, planTypeFreeHours)).thenReturn(assistanceFreeHoursPlan);

        manager.controlExit(user, product, today);
    }


    @Test
    public void testExitWhenCountLeftHoursFreeHoursPlanAndExitBefore20Minutes() throws Exception, ControlExitException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        final Date entranceDate = new Date();

        Calendar calendarExitDate = Calendar.getInstance();
        calendarExitDate.setTime(entranceDate);
        calendarExitDate.add(Calendar.MINUTE, 20);

        //manager.setExitDate(calendarExitDate.getTime());

        final AssistanceFreeHoursPlan assistanceFreeHoursPlan = new AssistanceFreeHoursPlan(Long.parseLong("1"), user,
                planTypeFreeHours, true, entranceDate, null);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(assistanceFreeHoursPlanDao.findLastEntrance(user, planTypeFreeHours)).thenReturn(
                assistanceFreeHoursPlan);
        when(countLeftHoursFreeHoursPlanDao.find(user, planTypeFreeHours)).thenReturn(
                new CountLeftHoursFreeHoursPlan(user, planTypeFreeHours,
                        (planTypeFreeHours.getHoursPerWeek() * 4)  - 5));

        ControlAccessResponse response = manager.controlExit(user, product, calendarExitDate.getTime());

        assertThat(response.getLeftHours(), is(equalTo(15)));

    }

    @Test
    public void testExitWhenCountLeftHoursFreeHoursPlanAndExitAfter20Minutes() throws Exception, ControlExitException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        final Date entranceDate = new Date();

        Calendar calendarExitDate = Calendar.getInstance();
        calendarExitDate.setTime(entranceDate);
        calendarExitDate.add(Calendar.MINUTE, 30);

        //manager.setExitDate(calendarExitDate.getTime());

        final AssistanceFreeHoursPlan assistanceFreeHoursPlan = new AssistanceFreeHoursPlan(Long.parseLong("1"), user,
                planTypeFreeHours, true, entranceDate, null);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(assistanceFreeHoursPlanDao.findLastEntrance(user, planTypeFreeHours)).thenReturn(
                assistanceFreeHoursPlan);
        when(countLeftHoursFreeHoursPlanDao.find(user, planTypeFreeHours)).thenReturn(
                new CountLeftHoursFreeHoursPlan(user, planTypeFreeHours,
                        (planTypeFreeHours.getHoursPerWeek() * 4)  - 5));

        ControlAccessResponse response = manager.controlExit(user, product, calendarExitDate.getTime());

        assertThat(response.getLeftHours(), is(equalTo(14)));

    }

    @Test
    public void testExitWhenCountLeftHoursFreeHoursPlanAndExitAfter100Minutes() throws Exception, ControlExitException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        final Date entranceDate = new Date();

        Calendar calendarExitDate = Calendar.getInstance();
        calendarExitDate.setTime(entranceDate);
        calendarExitDate.add(Calendar.MINUTE, 101);

        final AssistanceFreeHoursPlan assistanceFreeHoursPlan = new AssistanceFreeHoursPlan(Long.parseLong("1"), user,
                planTypeFreeHours, true, entranceDate, null);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(assistanceFreeHoursPlanDao.findLastEntrance(user, planTypeFreeHours)).thenReturn(
                assistanceFreeHoursPlan);
        when(countLeftHoursFreeHoursPlanDao.find(user, planTypeFreeHours)).thenReturn(
                new CountLeftHoursFreeHoursPlan(user, planTypeFreeHours,
                        (planTypeFreeHours.getHoursPerWeek() * 4)  - 5));

        ControlAccessResponse response = manager.controlExit(user, product, calendarExitDate.getTime());

        assertThat(response.getLeftHours(), is(equalTo(13)));

    }

    @Test
    public void testExitWhenCountLeftHoursFreeHoursPlanAndExitAfter160Minutes() throws Exception, ControlExitException {

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, -3);
        String endValidDate = operatesAndParseDate(today, Calendar.DAY_OF_MONTH, +3);
        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate,
                endValidDate);

        final Date entranceDate = new Date();

        Calendar calendarExitDate = Calendar.getInstance();
        calendarExitDate.setTime(entranceDate);
        calendarExitDate.add(Calendar.MINUTE, 161);

        final AssistanceFreeHoursPlan assistanceFreeHoursPlan = new AssistanceFreeHoursPlan(Long.parseLong("1"), user,
                planTypeFreeHours, true, entranceDate, null);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);
        when(assistanceFreeHoursPlanDao.findLastEntrance(user, planTypeFreeHours)).thenReturn(
                assistanceFreeHoursPlan);
        when(countLeftHoursFreeHoursPlanDao.find(user, planTypeFreeHours)).thenReturn(
                new CountLeftHoursFreeHoursPlan(user, planTypeFreeHours,
                        (planTypeFreeHours.getHoursPerWeek() * 4)  - 5));

        ControlAccessResponse response = manager.controlExit(user, product, calendarExitDate.getTime());

        assertThat(response.getLeftHours(), is(equalTo(12)));

    }



}
