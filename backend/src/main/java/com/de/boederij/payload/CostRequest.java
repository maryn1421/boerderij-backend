package com.de.boederij.payload;

import com.de.boederij.model.customType;
import lombok.Data;

import java.util.Date;


@Data
public class CostRequest {

    private String name;

    private Double value;

    private Long optionId;

    private Long userId;

    private Date date;

}
