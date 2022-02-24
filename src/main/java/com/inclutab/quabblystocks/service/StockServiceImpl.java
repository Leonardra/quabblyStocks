package com.inclutab.quabblystocks.service;

import com.inclutab.quabblystocks.data.dtos.StockRequestDto;
import com.inclutab.quabblystocks.data.model.Stock;
import com.inclutab.quabblystocks.data.repository.StockRepository;
import com.inclutab.quabblystocks.exception.StockException;
import com.inclutab.quabblystocks.exception.StockNotFoundException;
import com.inclutab.quabblystocks.exception.StockNotNullException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if(requestDto.getCurrentPrice() == 0 || requestDto.getCurrentPrice() < 0){
            throw new StockException("Stock price cannot be zero or have negative value");
        }
    }
    @Override
    public Stock findStock(Long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        if(stock.isPresent()){
            return stock.get();
        }
        throw new StockNotFoundException("Stock with this id does not exist");
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock updateStock(Long id, StockRequestDto requestDto){
        if(requestDto == null){
            throw new StockNotNullException("Stock cannot be null");
        }
        validateStockFields(requestDto);
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if(optionalStock.isPresent()){
            Stock foundStock = optionalStock.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(requestDto, foundStock);
            return stockRepository.save(foundStock);
        }
        throw new StockNotFoundException("Stock with this id does not exist");
    }

    @Override
    public void deleteStock(Long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        stock.ifPresent(value -> stockRepository.delete(value));
    }
}
