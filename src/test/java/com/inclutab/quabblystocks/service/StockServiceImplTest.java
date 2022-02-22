package com.inclutab.quabblystocks.service;

import com.inclutab.quabblystocks.data.dtos.StockRequestDto;
import com.inclutab.quabblystocks.data.model.Stock;
import com.inclutab.quabblystocks.data.repository.StockRepository;
import com.inclutab.quabblystocks.exception.StockException;
import com.inclutab.quabblystocks.exception.StockNotFoundException;
import com.inclutab.quabblystocks.exception.StockNotNullException;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void setUp() {
        stockRepository.deleteAll();
    }

    @Test
    void testThatStockCanBeAdded(){
        StockRequestDto stock = new StockRequestDto();
        stock.setName("Television");
        stock.setCurrentPrice(34000.00);
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
        stock.setCurrentPrice(40000.00);
        assertThrows(StockException.class, () -> stockServiceImpl.createStock(stock));
    }

    @Test
    void testThatStockPriceCannotBeZero(){
        StockRequestDto stock = new StockRequestDto();
        stock.setName("Television");
        stock.setCurrentPrice(0.00);
        assertThrows(StockException.class, () -> stockServiceImpl.createStock(stock));
    }

    @Test
    void testThatStockCanBeFound(){
        StockRequestDto stock = new StockRequestDto();
        stock.setName("Television");
        stock.setCurrentPrice(34000.00);
        Stock savedStock = stockServiceImpl.createStock(stock);
        Stock found = stockServiceImpl.findStock(savedStock.getId());
        assertThat(found).isNotNull();
    }

    @Test
    void testThatExceptionIsThrownIfStockDoesNotExist(){
        StockRequestDto stock = new StockRequestDto();
        stock.setName("Television");
        stock.setCurrentPrice(34000.00);
        stockServiceImpl.createStock(stock);
        assertThrows(StockNotFoundException.class, ()-> stockServiceImpl.findStock(2L));
    }

    @Test
    void testThatStockCanBeUpdated(){
        StockRequestDto stock = new StockRequestDto();
        stock.setName("Television");
        stock.setCurrentPrice(34000.00);
        Stock savedStock = stockServiceImpl.createStock(stock);
        StockRequestDto updateStock = new StockRequestDto();
        updateStock.setName("Furniture");
        updateStock.setCurrentPrice(30000.00);
        Stock updatedStock = stockServiceImpl.updateStock(savedStock.getId(), updateStock);
        assertThat(updatedStock.getName()).isEqualTo("Furniture");
        assertThat(updatedStock.getCurrentPrice()).isEqualTo(30000.0);
    }

    @Test
    void testThatStockCanBeDeleted(){
        StockRequestDto stock = new StockRequestDto();
        stock.setName("Television");
        stock.setCurrentPrice(34000.00);
        stockServiceImpl.createStock(stock);
        stockServiceImpl.deleteStock(1L);
        assertThrows(StockNotFoundException.class, ()-> stockServiceImpl.findStock(1L));
    }


}