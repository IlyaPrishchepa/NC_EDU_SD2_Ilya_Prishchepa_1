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
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status",columnDefinition =
            "varchar(255) default 'BLOCKED'")
    private Status status;

    @Basic
    @CreatedDate
    @Column(name = "start_date",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "ewallet_id", referencedColumnName = "id")
    private Ewallet ewalletId;

    @ManyToOne
    @JoinColumn(name = "services_id", referencedColumnName = "id")
    private Services servicesId;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

}
