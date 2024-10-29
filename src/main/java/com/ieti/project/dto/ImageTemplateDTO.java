package com.ieti.project.dto;

public class ImageTemplateDTO {

    private Integer imagesTemplateId;
    private String nameImg;
    private String url;
    private Integer templateId;

    public ImageTemplateDTO() {
    }

    public ImageTemplateDTO(Integer imagesTemplateId, String nameImg, String url, Integer templateId) {
        this.imagesTemplateId = imagesTemplateId;
        this.nameImg = nameImg;
        this.url = url;
        this.templateId = templateId;
    }

    public Integer getImagesTemplateId() {
        return imagesTemplateId;
    }

    public void setImagesTemplateId(Integer imagesTemplateId) {
        this.imagesTemplateId = imagesTemplateId;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

}
