/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.search;

import java.util.List;
import sample.dao.MobileDAO;
import sample.dao.MobileDTO;

/**
 *
 * @author Mochi
 */
public class SearchAction {
    private String searchValue;
    private final String SUCCESS = "success";
    private List<MobileDTO> products;
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        dao.searchIdOrName(searchValue);
        
        products = dao.getListProduct();
        
        return SUCCESS;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    public List<MobileDTO> getProducts(){
        return products;
    }
}
