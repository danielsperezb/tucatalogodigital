package com.ieti.project.dto;

public class TransactionDTO {

    private Integer transactionId;
    private String referenceTransaction;
    private String pCustIdCliente;
    private String pKey;
    private String constumerName;
    private String constumerPhone;
    private String shippingDirection;
    private String shippingDepartament;
    private String shippingMunicipality;
    private String amountBusinees;
    private String amountShip;
    private String amountComission;
    private String amountTotal;

    public TransactionDTO() {
    }


    public TransactionDTO(
            Integer transactionId, String referenceTransaction, String pCustIdCliente, String pKey,
            String constumerName, String constumerPhone, String shippingDirection,
            String shippingDepartament, String shippingMunicipality, String amountBusinees,
            String amountShip, String amountComission, String amountTotal) {

        this.transactionId = transactionId;
        this.referenceTransaction = referenceTransaction;
        this.pCustIdCliente = pCustIdCliente;
        this.pKey = pKey;
        this.constumerName = constumerName;
        this.constumerPhone = constumerPhone;
        this.shippingDirection = shippingDirection;
        this.shippingDepartament = shippingDepartament;
        this.shippingMunicipality = shippingMunicipality;
        this.amountBusinees = amountBusinees;
        this.amountShip = amountShip;
        this.amountComission = amountComission;
        this.amountTotal = amountTotal;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getReferenceTransaction() {
        return referenceTransaction;
    }

    public void setReferenceTransaction(String referenceTransaction) {
        this.referenceTransaction = referenceTransaction;
    }

    public String getPCustIdCliente() {
        return pCustIdCliente;
    }

    public void setPCustIdCliente(String pCustIdCliente) {
        this.pCustIdCliente = pCustIdCliente;
    }

    public String getPKey() {
        return pKey;
    }

    public void setPKey(String pKey) {
        this.pKey = pKey;
    }

    public String getConstumerName() {
        return constumerName;
    }

    public void setConstumerName(String constumerName) {
        this.constumerName = constumerName;
    }

    public String getConstumerPhone() {
        return constumerPhone;
    }

    public void setConstumerPhone(String constumerPhone) {
        this.constumerPhone = constumerPhone;
    }

    public String getShippingDirection() {
        return shippingDirection;
    }

    public void setShippingDirection(String shippingDirection) {
        this.shippingDirection = shippingDirection;
    }

    public String getShippingDepartament() {
        return shippingDepartament;
    }

    public void setShippingDepartament(String shippingDepartament) {
        this.shippingDepartament = shippingDepartament;
    }

    public String getShippingMunicipality() {
        return shippingMunicipality;
    }

    public void setShippingMunicipality(String shippingMunicipality) {
        this.shippingMunicipality = shippingMunicipality;
    }

    public String getAmountBusinees() {
        return amountBusinees;
    }

    public void setAmountBusinees(String amountBusinees) {
        this.amountBusinees = amountBusinees;
    }

    public String getAmountShip() {
        return amountShip;
    }

    public void setAmountShip(String amountShip) {
        this.amountShip = amountShip;
    }

    public String getAmountComission() {
        return amountComission;
    }

    public void setAmountComission(String amountComission) {
        this.amountComission = amountComission;
    }

    public String getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(String amountTotal) {
        this.amountTotal = amountTotal;
    }

}
