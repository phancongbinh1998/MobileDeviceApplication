/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.addToCart;

import sample.cart.CartObj;


/**
 *
 * @author Mochi
 */
public class AddToCartAction {

    private String mobileName;
    private String searchValueMin;
    private String searchValueMax;
    private int quantity;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public AddToCartAction() {
    }

    public String execute() throws Exception {
        CartObj cart = new CartObj();
        if (cart == null) {
            cart = new CartObj();
        }
        
        cart.addItemToCart(mobileName);
        return SUCCESS;
    }

    /**
     * @return the mobileName
     */
    public String getMobileName() {
        return mobileName;
    }

    /**
     * @param mobileName the mobileName to set
     */
    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    /**
     * @return the searchValueMin
     */
    public String getSearchValueMin() {
        return searchValueMin;
    }

    /**
     * @param searchValueMin the searchValueMin to set
     */
    public void setSearchValueMin(String searchValueMin) {
        this.searchValueMin = searchValueMin;
    }

    /**
     * @return the searchValueMax
     */
    public String getSearchValueMax() {
        return searchValueMax;
    }

    /**
     * @param searchValueMax the searchValueMax to set
     */
    public void setSearchValueMax(String searchValueMax) {
        this.searchValueMax = searchValueMax;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
