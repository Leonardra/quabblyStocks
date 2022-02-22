package com.inclutab.quabblystocks.service;

import com.inclutab.quabblystocks.data.dtos.StockRequestDto;
import com.inclutab.quabblystocks.data.model.Stock;
import com.inclutab.quabblystocks.data.repository.StockRepository;
import com.inclutab.quabblystocks.exception.StockException;
import com.inclutab.quabblystocks.exception.StockNotNullException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceImplTest {

    @Autowired
    StockService stockServiceImpl;
    @Autowired
    StockRepository stockRepository;

    @Test
    void testThatStockCanBeAdded(){
        StockRequestDto stock = new StockRequestDto();
        stock.setName("Television");
        stock.setPrice(34000.00);
        stockServiceImpl.createStock(stock);
        assertThat(stockRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void testThatNullStockCantBeSaved(){
        StockRequestDto stock = null;
        assertThrows(StockNotNullException.class, () -> stockServiceImpl.createStock(stock));
    }

    @Test
    void testThatStockNameCannotBeEmpty(){
        StockRequestDto stock = new StockRequestDto();
        stock.setName("");
        stock.setPrice(40000.00);
        assertThrows(StockException.class, () -> stockServiceImpl.createStock(stock));
    }

    @Test
    void testThatStockPriceCannotBeZero(){
        StockRequestDto stock = new StockRequestDto();
        stock.setName("Television");
        stock.setPrice(0.00);
        assertThrows(StockException.class, () -> stockServiceImpl.createStock(stock));
    }

    @Test
    void testThatStockCanBeFound(){
        StockRequestDto stock = new StockRequestDto();
        stock.setName("Television");
        stock.setPrice(34000.00);
        stockServiceImpl.createStock(stock);
        Stock found = stockServiceImpl.findStock(1L);
        assertThat(found).isNotNull();
    }
}