package com.netcracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ewallet {

    private int id;
    private Integer amount;
    private String numCard;
    private int loginId3;

}
