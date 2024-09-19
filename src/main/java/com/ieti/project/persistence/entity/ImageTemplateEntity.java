package com.ieti.project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Images_Template")
@Getter
@Setter
@NoArgsConstructor
public class ImageTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "images_template_id" , nullable = false)
    private Integer imagesTemplateId;

    @Column(name= "name_img", nullable = false, length = 250)
    private String nameImg;

    @Column(name = "url", nullable = false, length = 255)
    private String url;

    @ManyToOne
    @JoinColumn(name = "template_id", referencedColumnName = "template_id", insertable = false, updatable = false)
    private TemplateEntity templateEntity;

}
