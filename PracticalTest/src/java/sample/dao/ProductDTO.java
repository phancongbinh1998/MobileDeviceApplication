/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Date;

/**
 *
 * @author Mochi
 */
public class ProductDTO {
    private String name;
    private String description;
    private float price;
    private Date release;
    private Date expired;

    public ProductDTO() {
    }

    public ProductDTO(String name, String description, float price, Date release, Date expired) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.release = release;
        this.expired = expired;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the release
     */
    public Date getRelease() {
        return release;
    }

    /**
     * @param release the release to set
     */
    public void setRelease(Date release) {
        this.release = release;
    }

    /**
     * @return the expired
     */
    public Date getExpired() {
        return expired;
    }

    /**
     * @param expired the expired to set
     */
    public void setExpired(Date expired) {
        this.expired = expired;
    }
    
    
    
    
}
