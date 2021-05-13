package com.de.boederij.service;

import com.de.boederij.model.SellType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@Component
class MarketProviderTest {
    @Autowired
    MarketProvider marketProvider;


    @Test
    void getTypeFromTextShouldReturnAnimal() {
        Assertions.assertEquals(SellType.ANIMAL, marketProvider.getTypeFromText("animal"));
    }
}