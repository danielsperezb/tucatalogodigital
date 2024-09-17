package com.ieti.project.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id",nullable = false)
    private Integer productId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 20)
    private Integer price;

    @Column(nullable = false, length = 400)
    private String description;

    @Column(nullable = false, length = 1)
    private Integer state;

    @Column(nullable = false, length = 20)
    private Integer quantity;

    @ManyToMany(mappedBy = "products")
    private Set<CategoriesEntity> categories;

}
