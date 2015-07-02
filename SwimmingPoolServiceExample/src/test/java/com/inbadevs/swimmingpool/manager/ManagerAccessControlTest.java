package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.AssistanceFreeHoursPlanDao;
import com.inbadevs.swimmingpool.dao.ProductDao;
import com.inbadevs.swimmingpool.dao.UserDao;
import com.inbadevs.swimmingpool.entities.Product;
import com.inbadevs.swimmingpool.entities.ProductPK;
import com.inbadevs.swimmingpool.entities.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
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

    @Before
    public void setUp() throws Exception {

        manager = new ManagerAccessControl(userDao, productDao, assistanceFreeHoursPlanDao);
    }

    @Test
    @Ignore
    public void testIsUserAccessControlWhenTodayIsOutOfRangesDate() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -3);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String startValidDate = df.format(cal.getTime());

        cal.add(Calendar.MONTH, +1);

        String endValidDate = df.format(cal.getTime());

        when(userDao.find(Long.parseLong("1"))).thenReturn(new User());
        when(productDao.find(Long.parseLong("1"))).thenReturn(new Product(Long.parseLong("1"), new ProductPK(), startValidDate, endValidDate));

        assertFalse(manager.isUserAccessControlEntrance(Long.parseLong("1"), Long.parseLong("1")));

    }

    @Test
    @Ignore
    public void testIsUserAccessControlWhenTodayIsInnerRangesDate() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -3);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String startValidDate = df.format(cal.getTime());

        cal.add(Calendar.DAY_OF_MONTH, +4);

        String endValidDate = df.format(cal.getTime());

        when(userDao.find(Long.parseLong("1"))).thenReturn(new User());
        when(productDao.find(Long.parseLong("1"))).thenReturn(new Product(Long.parseLong("1"), new ProductPK(), startValidDate, endValidDate));

        assertTrue(manager.isUserAccessControlEntrance(Long.parseLong("1"), Long.parseLong("1")));


    }

}