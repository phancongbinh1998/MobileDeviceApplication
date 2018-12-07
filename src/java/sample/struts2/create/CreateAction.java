/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.create;

import com.opensymphony.xwork2.ActionSupport;
import sample.dao.MobileDAO;

/**
 *
 * @author Mochi
 */
public class CreateAction extends ActionSupport {
    private String mobileId;
    private String description;
    private float price;
    private String mobileName;
    private int yearOfProduction;
    private int quantity;
    private boolean sale;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    public CreateAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        boolean result = dao.insertProduct(mobileId, description, price, mobileName, yearOfProduction, quantity, sale);
        String url = FAIL;
        if(result){
            
            url = SUCCESS;
        }
        
        return url;
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
     * @param description the description to set
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
    public void setPrice(Float price) {
        this.price = price;
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
     * @return the yearOfProduction
     */
    public int getYearOfProduction() {
        return yearOfProduction;
    }

    /**
     * @param yearOfProduction the yearOfProduction to set
     */
    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
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
    public boolean getSale() {
        return sale;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(Boolean sale) {
        this.sale = sale;
    }

   
    
    
}
