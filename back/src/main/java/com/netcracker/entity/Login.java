package com.netcracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

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
    @Column(name = "role",columnDefinition = "varchar(255) default 'USER'")
    private String role;

    @OneToOne(mappedBy = "loginId2", cascade = CascadeType.ALL)
    @JsonIgnore
    private Company companies_id;

/*    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "login_id_3")
    @JsonIgnore
    private Collection<Ewallet> ewallets_id;*/

    @OneToOne(mappedBy = "loginId", cascade = CascadeType.ALL)
    @JsonIgnore
    private User users;

}
