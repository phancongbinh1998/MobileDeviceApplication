/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

/**
 *
 * @author Mochi
 */
public class MobileDTO {
    private String mobileId;
    private String description;
    private float price;
    private String mobileName;
    private int yearOfProduction;
    private int quantity;
    private boolean isSale;

    public MobileDTO() {
    }

    public MobileDTO(String mobileId, String description, float price, String mobileName, int yearOfProduction, int quantity, boolean isSale) {
        this.mobileId = mobileId;
        this.description = description;
        this.price = price;
        this.mobileName = mobileName;
        this.yearOfProduction = yearOfProduction;
        this.quantity = quantity;
        this.isSale = isSale;
    }
    
    
    
    public String getMobileId() {
        return mobileId;
    }

   
    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

   
    public String getDescription() {
        return description;
    }

  
    public void setDescription(String description) {
        this.description = description;
    }

   
    public float getPrice() {
        return price;
    }


    public void setPrice(float price) {
        this.price = price;
    }


    public String getMobileName() {
        return mobileName;
    }


    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    
    public int getYearOfProduction() {
        return yearOfProduction;
    }


    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public boolean isIsSale() {
        return isSale;
    }

 
    public void setIsSale(boolean isSale) {
        this.isSale = isSale;
    }
    
    
}
