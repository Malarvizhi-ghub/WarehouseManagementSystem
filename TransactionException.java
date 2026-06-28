package com.wipro.wms.util;

public class TransactionException extends Exception {

    @Override
    public String toString() {
        return "TransactionException: Invalid warehouse transaction.";
    }

}