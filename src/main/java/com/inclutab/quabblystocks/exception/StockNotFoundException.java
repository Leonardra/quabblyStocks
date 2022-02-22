package com.inclutab.quabblystocks.exception;

public class StockNotFoundException extends RuntimeException{
    public StockNotFoundException(String message) {
        super(message);
    }
}
