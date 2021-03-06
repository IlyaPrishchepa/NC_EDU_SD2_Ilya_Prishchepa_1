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
@Table(name = "ewallet" )
public class Ewallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "amount")
    private double amount;

    @Basic
    @Column(name = "num_card",nullable = false)
    private String numCard;

    @Basic
    @Column(name = "login_id_3")
    private int loginId3;

}
