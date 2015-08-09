package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.entities.Plan;
import com.inbadevs.swimmingpool.entities.Product;
import com.inbadevs.swimmingpool.entities.ProductPK;
import com.inbadevs.swimmingpool.exceptions.ControlEntranceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ManagerAccessControlTest extends ControlAccessAbstract {

    private ManagerAccessControl manager;
    private Plan planTypeFreeHours;

    @Test(expected = ControlEntranceException.class)
    public void testIsUserAccessControlWhenTodayIsOutOfRangesDate() throws Exception, ControlEntranceException {

        planTypeFreeHours = new Plan(Long.parseLong("1"), "name", "description", Long.parseLong("5000"),
                "typeHoursPerWeek", 5, null);
        manager = new ManagerAccessControl(userDao, productDao, controlAccessFactory);

        Date today = new Date();
        String startValidDate = operatesAndParseDate(today, Calendar.MONTH, +3);
        String endValidDate = operatesAndParseDate(today, Calendar.MONTH, +4);

        Product product = new Product(Long.parseLong("1"), new ProductPK(planTypeFreeHours, null), startValidDate, endValidDate);

        when(userDao.find(user.getId())).thenReturn(user);
        when(productDao.find(product.getId())).thenReturn(product);

        manager.isUserAccessControlEntrance(user.getId(), product.getId(), today);

    }




}