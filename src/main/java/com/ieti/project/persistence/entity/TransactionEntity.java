package com.ieti.project.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id" , nullable = false)
    private Integer transactionId;

    @Column(name = "reference_transaction",nullable = false, length = 20)
    private String referenceTransaction;

    @Column(name = "p_cust_id_cliente",nullable = false, length = 20)
    private String pCustIdCliente;

    @Column(name = "p_key",nullable = false, length = 20)
    private String pKey;

    @Column(name = "constumer_name",nullable = false, length = 20)
    private String constumerName;

    @Column(name = "constumer_phone",nullable = false, length = 20)
    private String constumerPhone;

    @Column(name = "shipping_direction",nullable = false, length = 20)
    private String shippingDirection;

    @Column(name = "shipping_departament",nullable = false, length = 20)
    private String shippingDepartament;

    @Column(name = "shipping_municipality",nullable = false, length = 20)
    private String shippingMunicipality;

    @Column(name = "amount_business",nullable = false, length = 20)
    private String amountBusinees;

    @Column(name = "amount_ship",nullable = false, length = 20)
    private String amountShip;

    @Column(name = "amount_comission",nullable = false, length = 20)
    private String amountComission;

    @Column(name = "amountTotal",nullable = false, length = 20)
    private String amountTotal;


}