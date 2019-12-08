package com.netcracker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "user" )
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name",nullable = false)
    private String name;

    @Basic
    @Column(name = "surname",nullable = false)
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login loginId;
}
