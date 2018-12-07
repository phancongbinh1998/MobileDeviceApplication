/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.search;

import java.util.List;
import sample.dao.ProductDAO;
import sample.dao.ProductDTO;

/**
 *
 * @author Mochi
 */
public class SearchAction {
    private String min;
    private String max;
    private List<ProductDTO> product;
    
    private final String SUCCESS = "success";
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        ProductDAO dao = new ProductDAO();
        float numMin = Float.parseFloat(min);
        float numMax = Float.parseFloat(max);
        dao.searchProduct(numMin, numMax);
        
        setProduct(dao.getProductList());
        
        return SUCCESS;
    }

    /**
     * @return the min
     */
    public String getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(String min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public String getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(String max) {
        this.max = max;
    }

    /**
     * @return the product
     */
    public List<ProductDTO> getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(List<ProductDTO> product) {
        this.product = product;
    }
    
}
