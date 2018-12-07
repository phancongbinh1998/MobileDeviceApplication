/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.logout;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;



/**
 *
 * @author Mochi
 */
public class LogoutAction {
    private  final String SUCCESS = "success";
    public LogoutAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.remove("USERNAME");
        return SUCCESS;
    }
    
}
