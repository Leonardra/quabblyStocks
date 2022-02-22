package com.inclutab.quabblystocks.web.controller;

import com.inclutab.quabblystocks.data.dtos.StockRequestDto;
import com.inclutab.quabblystocks.data.model.Stock;
import com.inclutab.quabblystocks.exception.StockException;
import com.inclutab.quabblystocks.exception.StockNotFoundException;
import com.inclutab.quabblystocks.exception.StockNotNullException;
import com.inclutab.quabblystocks.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {
    @Autowired
    StockService stockServiceImpl;

    @PostMapping("/")
    public ResponseEntity<?> createStock(@RequestBody StockRequestDto requestDto){
        try{
        return new ResponseEntity<>(stockServiceImpl.createStock(requestDto),
                HttpStatus.OK);
        }catch(StockNotNullException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStock(@PathVariable Long id){
        try {
            return new ResponseEntity<>(stockServiceImpl.findStock(id), HttpStatus.FOUND);
        }catch(StockException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllStock(){
        return new ResponseEntity<>(stockServiceImpl.getAllStock(), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStock(@PathVariable Long id, @RequestBody StockRequestDto requestDto){
        try {
            return new ResponseEntity<>(stockServiceImpl.updateStock(id, requestDto), HttpStatus.OK);
        }catch(StockNotFoundException | StockNotNullException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable Long id){
        stockServiceImpl.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
