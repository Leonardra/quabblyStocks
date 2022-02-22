package com.inclutab.quabblystocks.service;

import com.inclutab.quabblystocks.data.dtos.StockRequestDto;
import com.inclutab.quabblystocks.data.model.Stock;
import com.inclutab.quabblystocks.data.repository.StockRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{
    @Autowired
    StockRepository stockRepository;

    @Override
    public Stock createStock(StockRequestDto requestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Stock stock = modelMapper.map(requestDto, Stock.class);
        return stockRepository.save(stock);
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
