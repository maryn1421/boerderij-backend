package com.de.boederij.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    private String city;

    private String province;

    private Boolean isActive;


    @ManyToOne
    private User user;


}
