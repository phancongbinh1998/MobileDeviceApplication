/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.update;

import sample.dao.MobileDAO;

/**
 *
 * @author Mochi
 */
public class UpdateAction {
    private String mobileId;
    private String description;
    private float price;
    private int quantity;
    private boolean sale;
    private String searchLastValue;
    
    private  final String SUCCESS = "success";
    private  final String FAIL = "fail";
    
    public UpdateAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        boolean result = dao.updateProduct(mobileId, description, price, quantity, sale);
        String url = FAIL;
        if(result){
            url = SUCCESS;
        }
        return url;
    }

    public String getSearchLastValue() {
        return searchLastValue;
    }

    public void setSearchLastValue(String searchLastValue) {
        this.searchLastValue = searchLastValue;
    }

    
    /**
     * @return the mobileId
     */
    public String getMobileId() {
        return mobileId;
    }

    /**
     * @param mobileId the mobileId to set
     */
    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param des the des to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
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

    /**
     * @return the sale
     */
    public boolean isSale() {
        return sale;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(boolean sale) {
        this.sale = sale;
    }
    
}
