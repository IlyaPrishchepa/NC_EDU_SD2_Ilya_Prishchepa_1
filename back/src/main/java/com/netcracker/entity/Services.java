package com.netcracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "services" )
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name",nullable = false)
    private String name;

    @Basic
    @Column(name = "price")
    private double price;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "selected_ewallet")
    private int selectedEwallet;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category categoryId;

    @Basic
    @Column(name = "company_id")
    private int companyId;

    @OneToMany(mappedBy = "servicesId",  cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Subscription> subscription;

}
