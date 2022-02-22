package com.inclutab.quabblystocks.service;

import com.inclutab.quabblystocks.data.dtos.StockRequestDto;
import com.inclutab.quabblystocks.data.model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{
    @Override
    public Stock createStock(StockRequestDto requestDto) {
        return null;
    }

    @Override
    public Stock findStock(Long id) {
        return null;
    }

    @Override
    public List<Stock> getAllStock() {
        return null;
    }

    @Override
    public Stock updateStock(StockRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteStock(Long id) {

    }
}
