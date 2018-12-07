/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBConnection;

/**
 *
 * @author Mochi
 */
public class MobileDAO implements Serializable{
    
    
    public int checkLogin(String userId, String password) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.makeConnection();
            if(conn != null){
                String sql = "Select * From tbl_User Where userId = ? And password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userId);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    return rs.getInt("role");
                }
            }
        } finally {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return -1;
    }
    
    private List<MobileDTO> listProduct;
    
    public List<MobileDTO> getListProduct(){
        return listProduct;
    }
    
    public boolean searchIdOrName(String searchValue) throws NamingException, SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.makeConnection();
            if(conn != null){
                String sql = "Select * From tbl_Mobile Where mobileId Like ? Or mobileName Like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                stm.setString(2, "%" + searchValue + "%");
                rs= stm.executeQuery();
                while(rs.next()){
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean isSale = rs.getBoolean("notSale");
                    
                    MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, isSale);
                    if(this.listProduct == null){
                        listProduct = new ArrayList<MobileDTO>();
                    }
                    this.listProduct.add(dto);
                }
                
                
            }
        } finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return false;
    }
    
    public boolean deleteProduct(String mobileId) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBConnection.makeConnection();
            if(conn != null){
                String sql = "Delete From tbl_Mobile Where mobileId = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, mobileId);
                
                int row = stm.executeUpdate();
                if(row > 0){
                    return true;
                }
                
            }
        } finally{
            if (stm != null) {
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return false;
    }
    
    public boolean updateProduct(String mobileId, String description, float price, int quantity, boolean isSale) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBConnection.makeConnection();
            if(conn != null){
                String sql = "Update tbl_Mobile set description = ?, price = ?, quantity = ?, notSale = ? Where mobileId = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, description);
                stm.setFloat(2, price);
                stm.setInt(3, quantity);
                stm.setBoolean(4, isSale);
                stm.setString(5, mobileId);
                
                int row = stm.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally {
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return false;
    }
    
    public boolean insertProduct(String mobileId, String description, float price, String mobileName, int yearOfProduction, int quantity, boolean isSale) throws NamingException, SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBConnection.makeConnection();
            if(conn != null){
                String sql = "Insert Into tbl_Mobile(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale)"
                        + " Values(?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, mobileId);
                stm.setString(2, description);
                stm.setFloat(3, price);
                stm.setString(4, mobileName);
                stm.setInt(5, yearOfProduction);
                stm.setInt(6, quantity);
                stm.setBoolean(7, isSale);
                
                int row = stm.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally {
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return false;
    }
    
    private List<MobileDTO> listProductInRange;
    
    public List<MobileDTO> getListProductInRange(){
        return listProductInRange;
    }
    
    public boolean searchInRange(float min, float max) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.makeConnection();
            if(conn != null){
                String sql = "Select * From tbl_Mobile Where price Between ? And ? ";
                stm = conn.prepareStatement(sql);
                stm.setFloat(1, min);
                stm.setFloat(2, max);
                rs = stm.executeQuery();
                while(rs.next()){
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                     boolean isSale = rs.getBoolean("notSale");
                    
                    MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, isSale);
                    if(this.listProductInRange == null){
                        listProductInRange = new ArrayList<MobileDTO>();
                    }
                    this.listProductInRange.add(dto);
                }
                return true;
            }
        } finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return false;
    }
    
    public boolean insertOrder(String mobileName, int quantity) throws NamingException, SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBConnection.makeConnection();
            if(conn != null){
                String sql = "Insert Into tbl_Order(mobileName, quantity)"
                        + " Values(?,?)";
                stm = conn.prepareStatement(sql);
                
                stm.setString(1, mobileName);
                
                stm.setInt(2, quantity);
                
                
                int row = stm.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally {
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return false;
    }
}
