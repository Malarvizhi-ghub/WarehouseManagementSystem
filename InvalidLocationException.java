package com.wipro.wms.util;

public class InvalidLocationException extends Exception {

    @Override
    public String toString() {
        return "InvalidLocationException: Invalid warehouse location.";
    }

}