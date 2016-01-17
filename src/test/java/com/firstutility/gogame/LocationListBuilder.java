package com.firstutility.gogame;

import java.util.ArrayList;
import java.util.List;

public class LocationListBuilder {
	
	private List<Location> locations = new ArrayList<Location>();
	
    public static LocationListBuilder aLocationList() {
        return new LocationListBuilder();
    }
    
    public LocationListBuilder location(int x, int y) {
    	locations.add(new Location(x, y));
        return this;
    }
    
    public List<Location> build() {
        return locations;
    }

}
