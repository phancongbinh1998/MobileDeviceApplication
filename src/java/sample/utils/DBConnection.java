/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Mochi
 */
public class DBConnection implements Serializable{
    public static Connection makeConnection() throws NamingException, SQLException{
        Context context = new InitialContext();
        Context tomcatStr = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatStr.lookup("mobile");
        Connection conn = ds.getConnection();
        return conn;
    }
}
