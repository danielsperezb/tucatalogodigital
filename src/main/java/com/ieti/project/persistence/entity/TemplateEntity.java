package com.ieti.project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Template")
@Getter
@Setter
@NoArgsConstructor
public class TemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "template_id" , nullable = false)
    private Integer templateId;

    @Column(nullable = false, length = 250)
    private String logo;

    @Column(name = "subtitle_categories", nullable = false, length = 250)
    private String subtitleCategories;

    @Column(name = "subtitle_pictures", nullable = false, length = 250)
    private String subtitlePictures;

    @Column(name = "seccion_one", nullable = false, length = 250)
    private String seccionOne;

    @Column(name = "seccion_two", nullable = false, length = 250)
    private String seccionTwo;

    @Column(name = "business_id", nullable = false)
    private Integer businessId;

    @OneToOne
    @JoinColumn(name = "business_id", referencedColumnName = "business_id", insertable = false, updatable = false)
    private BusinessEntity businessEntity;

}
