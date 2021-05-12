package com.de.boederij.service;

import com.de.boederij.controller.MarketController;
import com.de.boederij.model.Sale;
import com.de.boederij.model.SellType;
import com.de.boederij.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketProvider {

    @Autowired
    SaleRepository saleRepository;


    public SellType getTypeFromText(String text) {
        SellType sellType;
        switch (text.toLowerCase()) {
            case "food":
                sellType = SellType.FOOD;
                break;
            case "animal":
                sellType = SellType.ANIMAL;
                break;
            default:
                sellType = SellType.PRODUCT;
        }
        return sellType;
    }

    private List<Sale> getSalesFromListBySellTYpe(List<Sale> sales, SellType sellType) {
        List<Sale> filteredSales = new ArrayList<>();

        sales.forEach(sale -> {
            if (sale.getType().equals(sellType)) {
                filteredSales.add(sale);
            }
        });
        return filteredSales;
    }


    public List<Sale> getFilteredSales(String province, String sellTypeText, String sorting) {
        SellType sellType = getTypeFromText(sellTypeText);
        List<Sale> sales;
        if (!province.equals("all")) {
            if (sorting.equals("asc")) {
                sales = saleRepository.findAllByProvinceOrderByPriceAsc(province);
            } else {
                sales = saleRepository.findAllByProvinceOrderByPriceDesc(province);
            }
        } else {
            if (sorting.equals("asc")) {
                sales = saleRepository.findAllByOrderByPriceAsc();
            } else {
                sales = saleRepository.findAllByOrderByPriceDesc();
            }
        }
        if (!sellTypeText.equals("all")) {
            sales = getSalesFromListBySellTYpe(sales, sellType);
        }

        return sales;
    }
}
