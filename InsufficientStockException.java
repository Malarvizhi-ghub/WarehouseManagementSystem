package com.wipro.wms.util;

public class InsufficientStockException extends Exception {

    @Override
    public String toString() {
        return "InsufficientStockException: Not enough stock available.";
    }

}