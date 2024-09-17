package com.ieti.project.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class CategoriesEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id" , nullable = false)
    private Integer categoryId;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name = "img_name",nullable = false, length = 20)
    private String imgName;

    @ManyToOne
    @JoinColumn(name = "business_id", referencedColumnName = "business_id", insertable = false,updatable = false)
    private BusinessEntity business;

    @ManyToMany
    @JoinTable(
            name = "category_product", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "category_id"), // Columna de la clave foránea que hace referencia a Estudiante
            inverseJoinColumns = @JoinColumn(name = "product_id") // Columna de la clave foránea que hace referencia a Curso
    )

    private Set<ProductsEntity> products;



}
