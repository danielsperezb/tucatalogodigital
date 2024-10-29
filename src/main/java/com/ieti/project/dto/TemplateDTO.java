package com.ieti.project.dto;

public class TemplateDTO {

    private Integer templateId;
    private String logo;
    private String subtitleCategories;
    private String subtitlePictures;
    private String seccionOne;
    private String seccionTwo;
    private Integer businessId;

    public TemplateDTO() {
    }

    public TemplateDTO(Integer templateId, String logo, String subtitleCategories,
                       String subtitlePictures, String seccionOne, String seccionTwo,
                       Integer businessId) {
        this.templateId = templateId;
        this.logo = logo;
        this.subtitleCategories = subtitleCategories;
        this.subtitlePictures = subtitlePictures;
        this.seccionOne = seccionOne;
        this.seccionTwo = seccionTwo;
        this.businessId = businessId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSubtitleCategories() {
        return subtitleCategories;
    }

    public void setSubtitleCategories(String subtitleCategories) {
        this.subtitleCategories = subtitleCategories;
    }

    public String getSubtitlePictures() {
        return subtitlePictures;
    }

    public void setSubtitlePictures(String subtitlePictures) {
        this.subtitlePictures = subtitlePictures;
    }

    public String getSeccionOne() {
        return seccionOne;
    }

    public void setSeccionOne(String seccionOne) {
        this.seccionOne = seccionOne;
    }

    public String getSeccionTwo() {
        return seccionTwo;
    }

    public void setSeccionTwo(String seccionTwo) {
        this.seccionTwo = seccionTwo;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

}
