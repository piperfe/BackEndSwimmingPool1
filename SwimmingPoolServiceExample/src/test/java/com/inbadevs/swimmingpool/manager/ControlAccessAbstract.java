package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.ProductDao;
import com.inbadevs.swimmingpool.dao.UserDao;
import com.inbadevs.swimmingpool.entities.User;
import com.inbadevs.swimmingpool.manager.controlAccess.ControlAccessFactory;
import org.junit.Before;
import org.mockito.Mock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by macbook on 8/8/15.
 */
public class ControlAccessAbstract {


    @Mock
    UserDao userDao;

    @Mock
    ProductDao productDao;

    @Mock
    ControlAccessFactory controlAccessFactory;

    public User user;

    @Before
    public void setUp() throws Exception {
        user = new User(null, null, null, "userNames", null, null, null, null, null, null, null, null, null, 0);
    }

    public String operatesAndParseDate(Date date, int calendar, int amount){

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(calendar, amount);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(cal.getTime());
    }
}
