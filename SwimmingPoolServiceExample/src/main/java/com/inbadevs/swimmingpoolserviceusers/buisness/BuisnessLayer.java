/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpoolserviceusers.buisness;

import com.inbadevs.swimmingpoolserviceusers.exceptions.BuisnessLayerException;
import com.inbadevs.swimmingpoolserviceusers.exceptions.ExceptionQueryNotFound;
import com.inbadevs.swimmingpoolserviceusers.dao.UserDao;
import com.inbadevs.swimmingpoolserviceusers.dao.ScheduleDao;
import com.inbadevs.swimmingpoolserviceusers.entities.User;
import com.inbadevs.swimmingpoolserviceusers.entities.Schedule;
import com.inbadevs.swimmingpoolserviceusers.entities.SwimingPoolUser;
import com.inbadevs.swimmingpoolserviceusers.service.entityresponse.GenericResponse;

import java.util.List;
import static javassist.CtMethod.ConstParameter.string;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuisnessLayer {

    
    @Autowired
    UserDao userDao;
    

    //
    //********* USER ***********
    //
    public List<User> getAllUsers() throws BuisnessLayerException {

        try {
            return this.userDao.getAllUsers();
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=getAllUsers message=user not found");
            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //funcion que inserta usuarios piscina
    public void addUserPiscina(User user) throws BuisnessLayerException{
        
        try {
            this.userDao.addUser(user);
            this.userDao.addUserPiscina(user);
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=addUser message=user didn't add");
            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //funcion que inserta usuarios administradores
    public void addUserAdmin(User user) throws BuisnessLayerException{
        
        try {
            this.userDao.addUser(user);
            this.userDao.addUserAdmin(user);
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=addUser message=user didn't add");
            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    
    public void deleteUser(String idUser) throws BuisnessLayerException{
        
        try {
            this.userDao.deleteUserPiscina(idUser);
            this.userDao.deleteUser(idUser);
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=deleteUser message=user didn't delete");
            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifyUser(User user) throws BuisnessLayerException{
        
        try {
            this.userDao.modifyUser(user);
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=modifyUser message=user didn't modify");
            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public GenericResponse getUser(User user) throws BuisnessLayerException {

        try {
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
        }
    }
    
    
    public String userExist(User user) throws BuisnessLayerException {

        try {
            List<User> userReturn = userDao.userExist(user);
            if(userReturn.size()>0)
                return "EXIST";
            else
                return "NOT EXIST";
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=getUser message=user not found");
        }
    }
    
    
    public User searchById(User user) throws BuisnessLayerException {

        try {
            return userDao.userExist(user).get(0);
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=getUser message=user not found");
        }
    }
    
    public List<User> searchUsers(String varSearch) throws BuisnessLayerException {

        try {
            return this.userDao.searchUsers(varSearch);
        } catch (ExceptionQueryNotFound ex) {
            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=getAllUsers message=user not found");
            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //
    //********* FIN USER ***********
    //
    
    
    //
    // ********* Usuario_Piscina
    //
    
    
    
    //
    //********* HORARIO ***********
    //
//    public List<User> getAllSchedule() throws BuisnessLayerException {
//
//        try {
//            return this.scheduleDao.getAllSchedule();
//        } catch (ExceptionQueryNotFound ex) {
//            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=getAllUsers message=user not found");
//            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
//    public void addSchedule(Schedule schedule) throws BuisnessLayerException{
//        
//        try {
//            this.scheduleDao.addSchedule(schedule);
//        } catch (ExceptionQueryNotFound ex) {
//            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=addUser message=user didn't add");
//            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void deleteSchedule(int idScheduler) throws BuisnessLayerException{
//        
//        try {
//            this.scheduleDao.deleteSchedule(idScheduler);
//        } catch (ExceptionQueryNotFound ex) {
//            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=deleteUser message=user didn't delete");
//            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void modifySchedule(Schedule schedule) throws BuisnessLayerException{
//        
//        try {
//            this.scheduleDao.modifySchedule(schedule);
//        } catch (ExceptionQueryNotFound ex) {
//            throw new BuisnessLayerException("class=com.inba.devs.swimmingpoolserviceusers.buisness.BuisnessLayer method=modifyUser message=user didn't modify");
//            //Logger.getLogger(Buisness.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
    //
    //********* FIN HORARIO ***********
    //
}
