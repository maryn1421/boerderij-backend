package com.de.boederij.payload;

import com.de.boederij.model.SellType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class SaleRequest {

    private String description;

    private String title;

    private int price;

    private SellType type;

    private Date startDate;

    private Date endDate;

    private MultipartFile image;

    private String province;

    private String city;

    private Long userId;

}
