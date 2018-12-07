/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.searchInRange;

import java.util.List;
import sample.dao.MobileDAO;
import sample.dao.MobileDTO;

/**
 *
 * @author Mochi
 */
public class SearchInRangeAction {

    private String min;
    private String max;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    private List<MobileDTO> products;

    public SearchInRangeAction() {
    }

    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        String url = FAIL;
        float min = 0;
        float max = 0;   
        if (!this.min.isEmpty()) {
          min = Float.parseFloat(this.min);
        }
        if (!this.max.isEmpty()) {
          max = Float.parseFloat(this.max);
        }
        
        if (dao.searchInRange(min, max)) {
            products = dao.getListProductInRange();
            url = SUCCESS;
        }
           
        return url;
    }

    public List<MobileDTO> getProducts() {
        return products;
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
}
