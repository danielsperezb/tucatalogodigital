package com.ieti.project.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Getter
@Setter
@NoArgsConstructor
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id" , nullable = false)
    private Integer contactId;

    @Column(name = "contact_value", nullable = false, length = 20)
    private String contactValue;

    @Column(name = "contact_type", nullable = false, length = 20)
    private String contactType;

    @ManyToOne
    @JoinColumn(name = "business_id", referencedColumnName = "business_id", insertable = false, updatable = false)
    private TemplateEntity templateEntity;

}