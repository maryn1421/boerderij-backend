package com.de.boederij.controller;

import com.de.boederij.model.Sale;
import com.de.boederij.model.User;
import com.de.boederij.payload.SaleRequest;
import com.de.boederij.repository.SaleRepository;
import com.de.boederij.repository.UserRepository;
import com.de.boederij.service.MarketProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

@RestController
@RequestMapping("/market")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class MarketController {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MarketProvider marketProvider;

    @GetMapping("/all-active")
    public List<Sale> getActiveSales() {
        return saleRepository.findAllByIsActive(true);
    }

    @GetMapping("/image/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable String name) throws IOException {
        File img = new File("src/main/resources/images/" + name);
        if (!img.exists()) {
            img = new File("src/main/resources/images/notfound.jpg");
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
    }


    @PostMapping("/add")
    public Map<String, Integer> addANewSale(@RequestBody SaleRequest saleRequest) {
        User user = userRepository.findById(saleRequest.getUserId()).get();
        Sale sale = Sale.builder()
                .description(saleRequest.getDescription())
                .endDate(saleRequest.getEndDate())
                .isActive(true)
                .photoName("none")
                .price(saleRequest.getPrice())
                .startDate(saleRequest.getStartDate())
                .title(saleRequest.getTitle())
                .type(saleRequest.getType())
                .viewNumber(0)
                .city(saleRequest.getCity())
                .province(saleRequest.getProvince())
                .user(user)
                .build();

        saleRepository.save(sale);

        Map<String, Integer> response = new HashMap<>();

        response.put("status", 201);
        response.put("id",Integer.parseInt(sale.getId().toString()));
        return response;
    }

    @PostMapping("/add/image/{id}")
    public String uploadWallpaper(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {

        String absolutePathDirectory = "src/main/resources/images/";

        File absolutePathFile = new File(absolutePathDirectory);
        String absolutePath = absolutePathFile.getAbsolutePath();

        if (!file.isEmpty()) {
            try {
                String filePath = absolutePath + "/" + Objects.requireNonNull(file.getOriginalFilename()).replace(" ", "_");

                File dest = new File(filePath);
                file.transferTo(dest.toPath());

                Optional<Sale> sale = saleRepository.findById(id);
                if (sale.isPresent()) {
                    Sale oldSale = sale.get();
                    oldSale.setPhotoName(file.getOriginalFilename());
                    saleRepository.save(oldSale);
                }
                return "success";
            } catch (Exception ex) {
                return "Exception error";
            }
        } else {
            return "Error";
        }

    }

    @GetMapping("/sale/{id}")
    public Sale getSingleSaleById(@PathVariable Long id) {
      if   (saleRepository.findById(id).isPresent()) {
          return saleRepository.findById(id).get();
      }
      else {
          return Sale.builder().build();
      }
    }

    @GetMapping("/filter/{province}/{type}/{sortOrder}")
    public List<Sale> filterSalesByProvinceAndOrType(@PathVariable("province") String province, @PathVariable String type, @PathVariable String sortOrder) {
        return marketProvider.getFilteredSales(province, type, sortOrder);
    }


}

