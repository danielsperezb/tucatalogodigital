package com.ieti.project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "shopping_cart")
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

    @ManyToMany
    @JoinTable(
            name = "products_cart", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "shopping_cart_id"), // Columna de la clave foránea que hace referencia a Estudiante
            inverseJoinColumns = @JoinColumn(name = "product_id") // Columna de la clave foránea que hace referencia a Curso
    )

    private Set<ProductsEntity> products;

}
