package com.de.boederij.repository;

import com.de.boederij.model.Animal;
import com.de.boederij.model.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long> {

    List<Cost> getAllByUserId(Long userId);

    List<Cost> getAllByUserIdAndDate(Long userId, Date date);

    List<Cost> getAllByDateBetween(Date from, Date to);

    List<Cost> getAllByUserIdAndName(Long userId, String name);

    List<Cost> getAllByUserIdAndId(Long userId, Long costId);
}
