package com.de.boederij.repository;

import com.de.boederij.model.Sale;
import com.de.boederij.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAllByIsActive(Boolean isActive);

    List<Sale> findAllByProvinceOrderByPriceDesc(String province);

    List<Sale> findAllByProvinceOrderByPriceAsc(String province);

    List<Sale> findAllByOrderByPriceDesc();

    List<Sale> findAllByOrderByPriceAsc();

    List<Sale> findAllByUser(User user);

}


