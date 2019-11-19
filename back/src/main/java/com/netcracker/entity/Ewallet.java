package com.netcracker.entity;

import lombok.Data;

import javax.persistence.*;

@Data
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
    @Column(name = "date",nullable = false)
    private String date;

    @Basic
    @Column(name = "cvv",nullable = false)
    private String cvv;

    @Basic
    @Column(name = "login_id_3")
    private int loginId3;

}
