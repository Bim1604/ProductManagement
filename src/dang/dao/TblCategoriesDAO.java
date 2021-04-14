/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dang.dao;

import dang.dto.TblCategoriesDTO;
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
public class TblCategoriesDAO extends Vector<TblCategoriesDTO> {

    public int findCate(String cateID) {
        for (int i = 0; i < this.size(); i++) {
            if (cateID.equals(this.get(i).getCategoryID())) {
                return i;
            }
        }
        return -1;
    }

    public TblCategoriesDTO getCategories(String cateID) {
        int pos = findCate(cateID);
        return pos < 0 ? null : this.get(pos);
    }

    public void loadFromDB() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBHelper.openConnection();
            String sql = "Select categoryID, categoryName, description "
                    + "From TblCategories";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String categoryID = rs.getString(1);
                String categoryName = rs.getString(2);
                String description = rs.getString(3);
                TblCategoriesDTO dto = new TblCategoriesDTO(categoryID, categoryName, description);
                this.add(dto);
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

    public boolean insertCategory(TblCategoriesDTO dto) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBHelper.openConnection();
            String sql = "Insert into tblCategories (categoryID, categoryName, description) "
                    + "Values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getCategoryID());
            ps.setString(2, dto.getCategoryName());
            ps.setString(3, dto.getDescription());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean findCategory(String categoryID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBHelper.openConnection();
            String sql = "Select categoryName "
                    + "From tblCategories "
                    + "Where categoryID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, categoryID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
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
        return false;
    }

    public boolean updateCategory(String categoryID, String categoryName, String description) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBHelper.openConnection();
            String sql = "Update tblCategories "
                    + "Set categoryName = ?, description = ? "
                    + "Where categoryID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, categoryName);
            ps.setString(2, description);
            ps.setString(3, categoryID);
            int row = ps.executeUpdate();
            if (row > 0) {
                return true;
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean deleteCategory(String categoryID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBHelper.openConnection();
            String sql = "Delete "
                    + "From tblCategories "
                    + "Where categoryID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, categoryID);
            int row = ps.executeUpdate();
            if (row > 0) {
                return true;
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
