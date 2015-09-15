/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inbadevs.swimmingpool.manager;

import com.inbadevs.swimmingpool.dao.ItemDao;
import com.inbadevs.swimmingpool.entities.Category;
import com.inbadevs.swimmingpool.entities.Item;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gabriellopezsalinas
 */

@Component
public class ManagerItem {
    @Autowired
    ItemDao item;
    
    public List<Item> getAll (){
        return this.item.all();
    }
    
    public void addItem (Item item){
        this.item.save(item);
    }
    
    public void updateItem(Item item){
        this.item.update(item);
    }
    
    public void deleteItem(String id){
        this.item.delete(id);
    }
    
    public Item getOne(String id) throws NotFoundException{
        return this.item.find(id);
    }
    

}
