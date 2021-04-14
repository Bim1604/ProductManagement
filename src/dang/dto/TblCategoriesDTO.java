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
public class TblCategoriesDTO {

    String categoryID;
    String categoryName;
    String Description;

    public TblCategoriesDTO() {
    }

    
    public TblCategoriesDTO(String categoryID, String categoryName, String Description) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.Description = Description;
    }

    /**
     * @return the categoryID
     */
    public String getCategoryID() {
        return categoryID;
    }

    /**
     * @param categoryID the categoryID to set
     */
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
