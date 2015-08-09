package com.inbadevs.swimmingpool.manager.controlAccess;

import com.inbadevs.swimmingpool.entities.Product;
import com.inbadevs.swimmingpool.entities.User;
import com.inbadevs.swimmingpool.exceptions.ControlEntranceException;
import com.inbadevs.swimmingpool.exceptions.ControlExitException;
import com.inbadevs.swimmingpool.service.entityresponse.ControlAccessResponse;

import java.util.Date;

/**
 * Created by macbook on 8/8/15.
 */
public interface Access {

    public ControlAccessResponse controlEntrance(User user, Product product, Date entranceDate) throws ControlEntranceException;
    public ControlAccessResponse controlExit(User user, Product product, Date exitDate) throws ControlExitException;
}
