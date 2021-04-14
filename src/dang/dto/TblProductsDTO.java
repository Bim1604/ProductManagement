/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dang.dto;

/**
 *
 * @author Admin
 */
public class TblProductsDTO {
    private String productID;
    private String productName;
    private String unit;
    private float price;
    private int quantity;
    private TblCategoriesDTO category;

    public TblProductsDTO() {
    }

    public TblProductsDTO(String productID, String productName, String unit, float price, int quantity, TblCategoriesDTO category) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    /**
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the category
     */
    public TblCategoriesDTO getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(TblCategoriesDTO category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return productID + " " + productName + " " + unit + " " + price + " " + quantity + " " + category;
    }
    
    
}
