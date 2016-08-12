package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.UserDao;
import com.inbadevs.swimmingpool.entities.User;
import com.inbadevs.swimmingpool.exceptions.BuisnessLayerException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ManagerUsers {

    @Autowired
    UserDao userDao;
    

    public Boolean isUserExist(String rut) throws NotFoundException {
        User user = this.userDao.findBy("rut", rut);
        if(user != null){
            return true;
        }
        return false;
    }

    public void deleteUser(Long idUser) throws BuisnessLayerException {
        this.userDao.delete(idUser);
    }
    
    public User loginUser(String rut, String password) {
        User user = this.userDao.login(rut, password);
        if(user != null){
            return user;
        }
        return null;
    }
    
    public void changePassUser(User user) throws NotFoundException {
        User userNewPass = this.userDao.find(user.getId());
        userNewPass.setPassword(user.getPassword());
        
    }
}
