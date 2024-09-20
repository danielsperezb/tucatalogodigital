package com.ieti.project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shoppingCart")
@Getter
@Setter
@NoArgsConstructor

public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id" , nullable = false)
    private Integer shoppingCartId;

    @Column(name = "key_customer",nullable = false, length = 20)
    private String keyCustomer;

}
