/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.login;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import sample.dao.MobileDAO;

/**
 *
 * @author Mochi
 */
public class LoginAction {
    private String username;
    private String password;
    
    private final String SUCCESSWITHSTAFF = "successWithStaff";
    private final String SUCCESSWITHUSER = "successWithUser";
    private final String SUCCESSWITHADMIN = "successWithAdmin";
    private final String FAIL = "fail";
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        int result = dao.checkLogin(getUsername(), getPassword());
        String url = FAIL;
        
        if(result > -1){
            if(result == 2){
                url = SUCCESSWITHADMIN;
            }
            if(result == 1){
                url = SUCCESSWITHSTAFF;
            }
            if(result == 0){
                url = SUCCESSWITHUSER;
            }
            Map session = ActionContext.getContext().getSession();
            session.put("USERNAME", getUsername());
        }
        return url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
