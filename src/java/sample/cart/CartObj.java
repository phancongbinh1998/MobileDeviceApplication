/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mochi
 */
public class CartObj implements Serializable{
    private String mobileName;
    private Map<String, Integer> items;


    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }
    
    public void addItemToCart(String mobileName){
        if(this.items == null){
            this.items = new HashMap<>();
        }
        int quantity = 1;
        
        if(this.items.containsKey(mobileName)){
            quantity = this.items.get(mobileName) + 1;
        }
        
        this.items.put(mobileName, quantity);
    }
    
    public void removeItemFromCart(String mobileName){
        if(this.items == null){
            return;
        }
        
        if(this.items.containsKey(mobileName)){
            this.items.remove(mobileName);
        }
    }
}
