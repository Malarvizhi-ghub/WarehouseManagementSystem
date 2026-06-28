package com.wipro.wms.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.wipro.wms.entity.Item;
import com.wipro.wms.entity.Location;
import com.wipro.wms.entity.WarehouseTransaction;
import com.wipro.wms.util.InsufficientStockException;
import com.wipro.wms.util.InvalidItemException;
import com.wipro.wms.util.InvalidLocationException;
import com.wipro.wms.util.TransactionException;

public class WarehouseService {

    private ArrayList<Item> items;
    private ArrayList<Location> locations;
    private ArrayList<WarehouseTransaction> transactions;

    private static int transactionCounter = 1001;

    public WarehouseService(ArrayList<Item> items,
                            ArrayList<Location> locations,
                            ArrayList<WarehouseTransaction> transactions) {

        this.items = items;
        this.locations = locations;
        this.transactions = transactions;
    }

    public boolean validateItem(String itemId)
            throws InvalidItemException {

        for (Item item : items) {
            if (item.getItemId().equalsIgnoreCase(itemId)) {
                return true;
            }
        }

        throw new InvalidItemException();
    }

    public boolean validateLocation(String locationId)
            throws InvalidLocationException {

        for (Location location : locations) {
            if (location.getLocationId().equalsIgnoreCase(locationId)) {
                return true;
            }
        }

        throw new InvalidLocationException();
    }

    public WarehouseTransaction inbound(String itemId,
                                        String locationId,
                                        int qty) throws Exception {

        if (qty <= 0)
            throw new TransactionException();

        validateItem(itemId);
        validateLocation(locationId);

        Item item = null;
        Location location = null;

        for (Item i : items)
            if (i.getItemId().equals(itemId))
                item = i;

        for (Location l : locations)
            if (l.getLocationId().equals(locationId))
                location = l;

        if (location.getCurrentLoad() + qty > location.getCapacity())
            throw new Exception("Location Capacity Exceeded");

        item.setTotalQuantity(item.getTotalQuantity() + qty);
        location.setCurrentLoad(location.getCurrentLoad() + qty);

        WarehouseTransaction wt = new WarehouseTransaction(
                "T" + transactionCounter++,
                itemId,
                locationId,
                "INBOUND",
                qty,
                LocalDate.now().toString());

        transactions.add(wt);

        return wt;
    }

    public WarehouseTransaction outbound(String itemId,
                                         String locationId,
                                         int qty)
            throws Exception {

        if (qty <= 0)
            throw new TransactionException();

        validateItem(itemId);
        validateLocation(locationId);

        Item item = null;
        Location location = null;

        for (Item i : items)
            if (i.getItemId().equals(itemId))
                item = i;

        for (Location l : locations)
            if (l.getLocationId().equals(locationId))
                location = l;

        if (item.getTotalQuantity() < qty ||
                location.getCurrentLoad() < qty)
            throw new InsufficientStockException();

        item.setTotalQuantity(item.getTotalQuantity() - qty);
        location.setCurrentLoad(location.getCurrentLoad() - qty);

        WarehouseTransaction wt = new WarehouseTransaction(
                "T" + transactionCounter++,
                itemId,
                locationId,
                "OUTBOUND",
                qty,
                LocalDate.now().toString());

        transactions.add(wt);

        return wt;
    }

    public void printStockSummary() {

        for (Item item : items) {

            System.out.println("--------------------------------");

            System.out.println("Item ID : " + item.getItemId());
            System.out.println("Item Name : " + item.getItemName());
            System.out.println("Category : " + item.getCategory());
            System.out.println("Total Quantity : " + item.getTotalQuantity());

        }

    }

    public void printLocationSummary() {

        for (Location location : locations) {

            System.out.println("--------------------------------");

            System.out.println("Location ID : " + location.getLocationId());
            System.out.println("Description : " + location.getDescription());
            System.out.println("Capacity : " + location.getCapacity());
            System.out.println("Current Load : " + location.getCurrentLoad());

            double percentage =
                    ((double) location.getCurrentLoad() /
                            location.getCapacity()) * 100;

            System.out.printf("Occupancy : %.2f%%\n", percentage);

        }

    }

    public void printItemHistory(String itemId) {

        System.out.println("\nTransaction History");

        for (WarehouseTransaction wt : transactions) {

            if (wt.getItemId().equals(itemId)) {

                System.out.println("--------------------------------");

                System.out.println("Transaction ID : "
                        + wt.getTransactionId());

                System.out.println("Type : "
                        + wt.getTransactionType());

                System.out.println("Quantity : "
                        + wt.getQuantity());

                System.out.println("Location : "
                        + wt.getLocationId());

                System.out.println("Date : "
                        + wt.getDate());

            }

        }

    }

}