package com.inclutab.quabblystocks.service;

import com.inclutab.quabblystocks.data.dtos.StockRequestDto;
import com.inclutab.quabblystocks.data.model.Stock;
import com.inclutab.quabblystocks.data.repository.StockRepository;
import com.inclutab.quabblystocks.exception.StockException;
import com.inclutab.quabblystocks.exception.StockNotNullException;
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
        if(requestDto == null){
            throw new StockNotNullException("Stock cannot be null");
        }
        validateStockFields(requestDto);
        ModelMapper modelMapper = new ModelMapper();
        Stock stock = modelMapper.map(requestDto, Stock.class);
        return stockRepository.save(stock);
    }

    private void validateStockFields(StockRequestDto requestDto){
        if(requestDto.getName() == null || requestDto.getName().isBlank()
                || requestDto.getName().isEmpty()){
            throw new StockException("Stock must not have empty name");
        }


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
