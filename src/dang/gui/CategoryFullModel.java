/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dang.gui;

import dang.dao.TblCategoriesDAO;
import dang.dto.TblCategoriesDTO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class CategoryFullModel extends AbstractTableModel{
    TblCategoriesDAO categories;

    public CategoryFullModel() {
        super();
    }

    public CategoryFullModel(TblCategoriesDAO categories) {
        this.categories = categories;
    }

    public TblCategoriesDAO getCategories() {
        return categories;
    }

    @Override
    public int getRowCount() {
        return categories.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        String columnName = "";
        switch (column) {
            case 0:
                columnName = "Category ID";
                break;
            case 1:
                columnName = "Category Name";
                break;
            case 2:
                columnName = "Description";
                break;
        }
        return columnName;
    }

    @Override
    public Object getValueAt(int row, int column) {
        TblCategoriesDTO category = categories.get(row);
        Object obj = null;
        switch (column) {
            case 0:
                obj = category.getCategoryID();
                break;
            case 1:
                obj = category.getCategoryName();
                break;
            case 2:
                obj = category.getDescription();
                break;
        }
        return obj;
    }
}
