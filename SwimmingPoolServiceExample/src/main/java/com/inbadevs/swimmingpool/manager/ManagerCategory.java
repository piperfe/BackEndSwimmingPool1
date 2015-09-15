/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.CategoryDao;
import com.inbadevs.swimmingpool.entities.Category;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */
@Component
public class ManagerCategory {
    
    @Autowired
    CategoryDao categoryDao;
    
    public void addCategory (Category category){
        this.categoryDao.save(category);
    }
    
    public void updateCategory(Category category){
        this.categoryDao.update(category);
    }
    
    public void deleteCategory(String id){
        this.categoryDao.delete(id);
    }
    
    public List<Category> getAllCategory(){
        return this.categoryDao.all();
    }
    
    public Category getOne(String id) throws NotFoundException{
        return this.categoryDao.find(id);
    }
    
}
