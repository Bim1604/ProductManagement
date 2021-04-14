/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dang.dao;

import dang.dto.TblCategoriesDTO;
import dang.dto.TblProductsDTO;
import dangtd.utl.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class TblProductsDAO extends Vector<TblProductsDTO> {
    public boolean findProduct(String categoryID){
        for (int i = 0; i < this.size(); i++) {
            if (categoryID.equals(this.get(i).getCategory().getCategoryID())){
                return true;
            }
        }
        return false;
    }

    public void loadFromDB(TblCategoriesDAO categories) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBHelper.openConnection();
            String sql = "Select productID, productName, unit, price, quantity, categoryID "
                    + "From tblProducts";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String productID = rs.getString(1);
                String productName = rs.getString(2);
                String unit = rs.getString(3);
                float price = rs.getFloat(4);
                int quantity = rs.getInt(5);
                TblCategoriesDTO category = categories.getCategories(rs.getString(6));
                TblProductsDTO productDTO = new TblProductsDTO(productID, productName, unit, price, quantity, category);
                this.add(productDTO);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public boolean insertProduct(TblProductsDTO dto) throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = DBHelper.openConnection();
            String sql = "Insert into tblProducts (productID, productName, unit, quantity, price, categoryid) "
                    + "Values (?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,dto.getProductID());
            ps.setString(2,dto.getProductName());
            ps.setString(3,dto.getUnit());
            ps.setFloat(4,dto.getPrice());
            ps.setInt(5,dto.getQuantity());
            ps.setString(6,dto.getCategory().getCategoryID());
            int row = ps.executeUpdate();
            if (row > 0){
                return true;
            }
        } finally{
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return false;
    }
    
    public boolean updateProduct(TblProductsDTO dto) throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = DBHelper.openConnection();
            String sql = "Update tblProducts "
                    + "Set productName = ?, unit = ?, price = ?, quantity = ?, categoryid = ? "
                    + "Where productID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,dto.getProductName());
            ps.setString(2,dto.getUnit());
            ps.setFloat(3,dto.getPrice());
            ps.setInt(4,dto.getQuantity());
            ps.setString(5,dto.getCategory().getCategoryID());
            ps.setString(6,dto.getProductID());
            int row = ps.executeUpdate();
            if (row > 0){
                return true;
            }
        } finally {
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return false;
    }
    
    public boolean deleteProducts(String productID) throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = DBHelper.openConnection();
            String sql = "Delete tblProducts "
                    + "Where productID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, productID);
            int row = ps.executeUpdate();
            if (row > 0){
                return true;
            }
        } finally {
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return false;
    }
}
