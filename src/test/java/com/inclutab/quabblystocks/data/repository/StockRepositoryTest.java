package com.inclutab.quabblystocks.data.repository;

import com.inclutab.quabblystocks.data.model.Stock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StockRepositoryTest {

    @Autowired
    StockRepository stockRepository;

    private Stock stock;


    @BeforeEach
    void setUp() {
        stock = new Stock();
        stock.setName("Television");
        stock.setPrice(38000.00);
    }

    @Test
    void testAddStock(){
        assertThat(stock.getId())
                .isNull();
        log.info("incoming stock before saving -> {}", stock);
        stockRepository.save(stock);
        log.info("incoming stock after saving -> {}", stock);
        assertThat(stock.getId()).isNotNull();
    }


    @Test
    void testFindStock(){
        stockRepository.save(stock);
        Stock foundStock = stockRepository.findById(1L).orElse(null);
        assertThat(foundStock).isNotNull();
    }
}