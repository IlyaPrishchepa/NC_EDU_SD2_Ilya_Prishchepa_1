package com.netcracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

    private int id;
    private String status;
    private Date startDate;
    private Date endDate;
    private Services servicesId;
    private User userId;

}
