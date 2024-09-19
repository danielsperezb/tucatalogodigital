package com.ieti.project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Images_Products")
@Getter
@Setter
@NoArgsConstructor
public class ImageProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "images_products_id" , nullable = false)
    private Integer imagesProductId;

    @Column(name= "name_img", nullable = false, length = 250)
    private String nameImg;

    @ManyToOne
    @JoinColumn(name = "products_id", referencedColumnName = "products_id", insertable = false, updatable = false)
    private ProductsEntity productsEntity;

}
