/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.dao.UserDao;
import com.inbadevs.swimmingpoolserviceusers.entities.AdminUser;
import com.inbadevs.swimmingpoolserviceusers.entities.SwimmingPoolUser;
import com.inbadevs.swimmingpoolserviceusers.entities.User;
import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpoolserviceusers.service.entityresponse.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuisnessLayer {

    
    @Autowired
    UserDao userDao;

    public List<SwimmingPoolUser> getAllSwimmingPoolUsers() {
        return this.userDao.all();
    }


    public void addUserPiscina(SwimmingPoolUser user) {
            this.userDao.save(user);
    }

    public void addUserAdmin(AdminUser user) {
            this.userDao.save(user);
    }

    public void deleteUser(String idUser) throws BuisnessLayerException{
        
        this.userDao.delete(idUser);
    }

    public void modifyUser(User user) throws BuisnessLayerException{
        
       // try {
           // this.userDao.modifyUser(user);
        //} catch (ExceptionQueryNotFound ex) {
        //    throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=modifyUser message=user didn't modify");
            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
       // }
    }
    
    public GenericResponse getUser(User user) throws BuisnessLayerException {

      /*  try {
            GenericResponse genericResponse = new GenericResponse();
            User userReturn;
             
            if(userDao.getUser(user).size() >0)
            {
                userReturn = userDao.getUser(user).get(0);
                genericResponse.setStatus("SUCCESSFUL");
                genericResponse.setIdUser(userReturn.getUserNames());
                return genericResponse;
            }
            else
            {
                genericResponse.setStatus("FAIL");
                genericResponse.setIdUser(null);
                return genericResponse;
            }
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=getUser message=user not found");
        }*/
        return null;
    }
    
    
    public String userExist(User user) throws BuisnessLayerException {

        /*try {
            List<User> userReturn = userDao.userExist(user);
            if(userReturn.size()>0)
                return "EXIST";
            else
                return "NOT EXIST";
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=getUser message=user not found");
        }*/
        return null;
    }
    
    
    public User searchById(User user) throws BuisnessLayerException {

        return null;
       /* try {
            return userDao.userExist(user).get(0);
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=getUser message=user not found");
        }*/
    }
    
    public List<User> searchUsers(String varSearch) throws BuisnessLayerException {

        return null;
    /*    try {
            return this.userDao.searchUsers(varSearch);
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=getAllUsers message=user not found");
            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

}
