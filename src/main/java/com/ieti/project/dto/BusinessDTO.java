package com.ieti.project.dto;

import java.util.Date;
import java.util.List;

public class BusinessDTO {

    private Integer businessId;
    private String name;
    private Date creationDate;
    private Date deathDate;
    private Integer key_code;
    private List<CategoriesDTO> categories;

    public BusinessDTO() {
    }

    public BusinessDTO(Integer businessId, String name, Date creationDate, Date deathDate, Integer key_code, List<CategoriesDTO> categories) {
        this.businessId = businessId;
        this.name = name;
        this.creationDate = creationDate;
        this.deathDate = deathDate;
        this.key_code = key_code;
        this.categories = categories;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Integer getKeyCode() {
        return key_code;
    }

    public void setKeyCode(Integer key_code) {
        this.key_code = key_code;
    }

    public List<CategoriesDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesDTO> categories) {
        this.categories = categories;
    }

}
