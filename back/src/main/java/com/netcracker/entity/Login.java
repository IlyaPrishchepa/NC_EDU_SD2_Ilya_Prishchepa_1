package com.netcracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.entity.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "login" )
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "email",nullable = false)
    private String email;

    @Basic
    @Column(name = "password",nullable = false)
    private String password;

    @Basic
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role",columnDefinition = "varchar(255) default 'USER'")
    private Role role;

    @OneToOne(mappedBy = "loginId2", cascade = CascadeType.ALL)
    @JsonIgnore
    private Company companies_id;

    @OneToOne(mappedBy = "loginId", cascade = CascadeType.ALL)
    @JsonIgnore
    private User users;

}
