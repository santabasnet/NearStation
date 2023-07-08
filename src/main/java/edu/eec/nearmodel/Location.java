package edu.eec.nearmodel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class is a part of the package com.iict.algorithm.model and the package
 * is a part of the project CWRouting.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-10-19.
 */
public class Location {
    private final int id;
    private final String name;
    private final String description;
    private final double latitude;
    private final double longitude;
    /**
     * Default Constructor
     **/
    public Location() {
        this.id = 0;
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.description = "";
        this.name = "";
    }

    /**
     * With  some parameters.
     **/
    public Location(int id, String name, String description, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getLatitude() {
        return latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }
    
    /**
     * Returns the coordinate representation.
     */
    public Coordinate getCoordinate() {
        return new Coordinate(this.getLatitude(), this.getLongitude());
    }

    /**
     * For the factory purpose.
     */
    public static Location init() {
        return new Location();
    }

    /**
     * Stringify the instance
     **/
    @Override
    public String toString() {
        return toJson();
    }

    /**
     * To JSON utility
     **/
    public String toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
