package com.wipro.wms.main;

import java.util.ArrayList;

import com.wipro.wms.entity.Item;
import com.wipro.wms.entity.Location;
import com.wipro.wms.entity.WarehouseTransaction;
import com.wipro.wms.service.WarehouseService;
import com.wipro.wms.util.InsufficientStockException;
import com.wipro.wms.util.InvalidItemException;
import com.wipro.wms.util.InvalidLocationException;

public class Main {

    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("I001", "LED TV", "Electronics", 50));
        items.add(new Item("I002", "Refrigerator", "Appliances", 20));

        ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location("L001", "Rack A - Shelf 1", 100, 30));
        locations.add(new Location("L002", "Rack B - Shelf 2", 80, 10));

        ArrayList<WarehouseTransaction> transactions = new ArrayList<>();

        WarehouseService service =
                new WarehouseService(items, locations, transactions);

        try {

            WarehouseTransaction t1 =
                    service.inbound("I001", "L001", 10);

            System.out.println("Inbound Success. Transaction ID : "
                    + t1.getTransactionId());

            WarehouseTransaction t2 =
                    service.outbound("I002", "L002", 5);

            System.out.println("Outbound Success. Transaction ID : "
                    + t2.getTransactionId());

            System.out.println("\n----- Stock Summary -----");
            service.printStockSummary();

            System.out.println("\n----- Location Summary -----");
            service.printLocationSummary();

            System.out.println("\n----- Item History -----");
            service.printItemHistory("I001");

        }

        catch (InvalidItemException e) {

            System.out.println(e);

        }

        catch (InvalidLocationException e) {

            System.out.println(e);

        }

        catch (InsufficientStockException e) {

            System.out.println(e);

        }

        catch (Exception e) {

            System.out.println("Unexpected Error : " + e.getMessage());

        }

    }

}