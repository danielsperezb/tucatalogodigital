package com.ieti.project.dto;

public class ShoppingCartDTO {

    private Integer shoppingCartId;
    private String keyCustomer;

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(Integer shoppingCartId, String keyCustomer) {
        this.shoppingCartId = shoppingCartId;
        this.keyCustomer = keyCustomer;
    }

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public String getKeyCustomer() {
        return keyCustomer;
    }

    public void setKeyCustomer(String keyCustomer) {
        this.keyCustomer = keyCustomer;
    }

}
