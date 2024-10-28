package com.ieti.project.dto;

import java.util.Set;

public class CategoriesDTO {

    private Integer categoryId;
    private String name;
    private String imgName;
    private Integer businessId;
    private Set<Integer> productIds;

    public CategoriesDTO() {
    }

    public CategoriesDTO(Integer categoryId, String name, String imgName, Integer businessId, Set<Integer> productIds) {
        this.categoryId = categoryId;
        this.name = name;
        this.imgName = imgName;
        this.businessId = businessId;
        this.productIds = productIds;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Set<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(Set<Integer> productIds) {
        this.productIds = productIds;
    }

}
