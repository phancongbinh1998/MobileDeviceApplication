/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.delete;

import sample.dao.MobileDAO;

/**
 *
 * @author Mochi
 */
public class DeleteAction {
    private String mobileId;
    private String searchLastValue;
    
    private  final String SUCCESS = "success";
    private  final String FAIL = "fail";
    public DeleteAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        boolean result = dao.deleteProduct(mobileId);
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
     * @return the searchValue
     */
    public String getSearchLastValue() {
        return searchLastValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchLastValue(String searchValue) {
        this.searchLastValue = searchValue;
    }
    
}
