package com.netcracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

    private int id;
    private boolean status;
    private Date startDate;
    private int ewalletId;
    private Services servicesId;
    private int userId;

}
