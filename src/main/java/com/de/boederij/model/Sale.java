package com.de.boederij.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class Sale {


    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private String title;

    private String photoName;

    private int price;

    private SellType type;

    private int viewNumber;

    private Date startDate;

    private Date endDate;

    private Boolean isActive;

    @ManyToOne
    private User user;




}
