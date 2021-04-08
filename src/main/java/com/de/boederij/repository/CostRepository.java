package com.de.boederij.repository;


import com.de.boederij.model.Cost;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;

public interface CostRepository extends JpaRepository<Cost, Long> {


    List<Cost> getAllByUserId(Long userId);

    List<Cost> getAllByUserIdAndDate(Long userId, Date date);

    List<Cost> getAllByUserIdAndDateBetween(Long userId,Date from, Date to);

    List<Cost> getAllByUserIdAndName(Long userId, String name);

    List<Cost> getAllByUserIdAndOptionId(Long userId, Long optionId);
}
