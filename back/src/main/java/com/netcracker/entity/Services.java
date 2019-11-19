package com.netcracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
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
    @Column(name = "description",columnDefinition =
            "varchar(255) default 'The description is absent'")
    private String description;

    @Basic
    @Column(name = "category_id")
    private int categoryId;

    @Basic
    @Column(name = "company_id")
    private int companyId;


/*    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company companyId;*/

    @OneToMany(mappedBy = "servicesId",  cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Subscription> subscription;

}
