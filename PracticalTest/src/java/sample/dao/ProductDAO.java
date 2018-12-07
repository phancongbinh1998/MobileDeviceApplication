/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
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
public class ProductDAO implements Serializable{
    
    public boolean checkLogin(String username, String password) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.makeConnection();
            if(conn != null){
                String sql = "Select * From tbl_User Where username = ? And password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    return true;
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
        return false;
    }
    
    private List<ProductDTO> productList;
    public List<ProductDTO> getProductList(){
        return productList;
    }
    
    public boolean searchProduct(float min, float max) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.makeConnection();
            if(conn != null){
                String sql = "Select * From tbl_Product Where price Between ? and ?";
                stm = conn.prepareStatement(sql);
                stm.setFloat(1, min);
                stm.setFloat(2, max);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    Date release = rs.getDate("releasedDate");
                    Date expired = rs.getDate("expiredDate");
                    
                    ProductDTO dto = new ProductDTO(name, description, price, release, expired);
                    if(this.productList == null){
                        productList = new ArrayList<ProductDTO>();
                    }
                    productList.add(dto);
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
        return false;
    }
}
