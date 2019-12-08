package com.netcracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Services {
    private int id;
    private String name;
    private String price;
    private String description;
    private Category categoryId;
    private int companyId;


}
