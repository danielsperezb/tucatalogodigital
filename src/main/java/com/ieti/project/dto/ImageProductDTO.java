package com.ieti.project.dto;

public class ImageProductDTO {

    private Integer imagesProductId;
    private String nameImg;
    private Integer productId;

    public ImageProductDTO() {
    }

    public ImageProductDTO(Integer imagesProductId, String nameImg, Integer productId) {
        this.imagesProductId = imagesProductId;
        this.nameImg = nameImg;
        this.productId = productId;
    }

    public Integer getImagesProductId() {
        return imagesProductId;
    }

    public void setImagesProductId(Integer imagesProductId) {
        this.imagesProductId = imagesProductId;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

}
