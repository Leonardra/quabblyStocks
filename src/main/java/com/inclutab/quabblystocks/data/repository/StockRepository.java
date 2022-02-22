package com.inclutab.quabblystocks.data.repository;

import com.inclutab.quabblystocks.data.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
