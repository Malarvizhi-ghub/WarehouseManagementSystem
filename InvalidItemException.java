package com.wipro.wms.util;

public class InvalidItemException extends Exception {

    @Override
    public String toString() {
        return "InvalidItemException: Item ID does not exist.";
    }

}