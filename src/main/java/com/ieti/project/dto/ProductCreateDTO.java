package com.ieti.project.dto;

import java.util.Set;

public class ProductCreateDTO {

    private String title;
    private Integer price;
    private String description;
    private Integer state;
    private Integer quantity;
    private Set<Integer> categoryIds;

    public ProductCreateDTO() {
    }

    public ProductCreateDTO(String title, Integer price, String description, Integer state, Integer quantity, Set<Integer> categoryIds) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.state = state;
        this.quantity = quantity;
        this.categoryIds = categoryIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

}
