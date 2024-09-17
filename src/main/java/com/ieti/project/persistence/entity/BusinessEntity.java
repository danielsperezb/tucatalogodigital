package com.ieti.project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "business")
@Getter
@Setter
@NoArgsConstructor
public class BusinessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_id" , nullable = false)
    private Integer businessId;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String password;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "death_date", nullable = false)
    private Date deathDate;

    @Column(nullable = false)
    private Integer key_code;

    @OneToMany(mappedBy = "business")
    private List<ProductsEntity> products;

}

