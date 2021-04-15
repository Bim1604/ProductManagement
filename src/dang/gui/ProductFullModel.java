/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dang.gui;

import dang.dao.TblProductsDAO;
import dang.dto.TblProductsDTO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class ProductFullModel extends AbstractTableModel {

    TblProductsDAO products = null;

    public ProductFullModel() {
    }

    public ProductFullModel(TblProductsDAO products) {
        this.products = products;
    }

    public TblProductsDAO getProducts() {
        return products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        String columnName = "";
        switch (column) {
            case 0:
                columnName = "product ID";
                break;
            case 1:
                columnName = "Product Name";
                break;
            case 2:
                columnName = "Unit";
                break;
            case 3:
                columnName = "Quantity";
                break;
            case 4:
                columnName = "Price";
                break;
            case 5:
                columnName = "CategoryID";
                break;
        }
        return columnName;
    }

    @Override
    public Object getValueAt(int row, int column) {
        TblProductsDTO product = products.get(row);
        Object obj = null;
        switch (column) {
            case 0:
                obj = product.getProductID();
                break;
            case 1:
                obj = product.getProductName();
                break;
            case 2:
                obj = product.getUnit();
                break;
            case 3:
                obj = product.getQuantity();
                break;
            case 4:
                obj = product.getPrice();
                break;
            case 5:
                obj = product.getCategory().getCategoryID();
                break;
        }
        return obj;
    }

}
