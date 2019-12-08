package com.netcracker.entity;

import com.netcracker.entity.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "subscription" )
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "status")
    private String status;

    @Basic
    @CreatedDate
    @Column(name = "start_date",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Basic
    @Column(name = "ewallet_id")
    private int ewalletId;

    @Basic
    @Column(name = "services_id")
    private int servicesId;

/*    @ManyToOne
    @JoinColumn(name = "services_id", referencedColumnName = "id")
    private Services servicesId;*/

    @Basic
    @Column(name = "user_id")
    private int userId;

}
