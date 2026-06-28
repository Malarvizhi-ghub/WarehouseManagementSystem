package com.wipro.wms.entity;

public class Location {
	 private String locationId;
	    private String description;
	    private int capacity;
	    private int currentLoad;

	    public Location() {
	    }

	    public Location(String locationId, String description, int capacity, int currentLoad) {
	        this.locationId = locationId;
	        this.description = description;
	        this.capacity = capacity;
	        this.currentLoad = currentLoad;
	    }


	    public String getLocationId() {
	        return locationId;
	    }

	    public void setLocationId(String locationId) {
	        this.locationId = locationId;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public int getCapacity() {
	        return capacity;
	    }

	    public void setCapacity(int capacity) {
	        this.capacity = capacity;
	    }

	    public int getCurrentLoad() {
	        return currentLoad;
	    }

	    public void setCurrentLoad(int currentLoad) {
	        this.currentLoad = currentLoad;
	    }
	
}
