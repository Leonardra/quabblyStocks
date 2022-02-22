package com.inclutab.quabblystocks.service;

import com.inclutab.quabblystocks.data.dtos.StockRequestDto;
import com.inclutab.quabblystocks.data.model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {
    Stock createStock(StockRequestDto requestDto);
    Stock findStock(Long id);
    List<Stock> getAllStock();
    Stock updateStock(Long id, StockRequestDto requestDto);
    void deleteStock(Long id);
}
