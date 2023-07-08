package edu.eec.nearutils;

import edu.eec.nearmodel.Coordinate;
import edu.eec.nearmodel.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * This class is a part of the package com.iict.algorithm.model and the package
 * is a part of the project CWRouting.
 * <p>
 * Integrated ICT Pvt. Ltd. Jwagal, Lalitpur, Nepal.
 * https://www.integratedict.com.np
 * <p>
 * Created by Santa on 2022-10-30.
 */
public class RequestCache {
    
    private static final ConcurrentHashMap<String, Double> distanceCache = new ConcurrentHashMap<>();
    
    /**
     * Update the distance value.
     */
    public static void update(String key, Double value) {
        distanceCache.put(key, value);
    }
    
    /**
     * Check if the entry with given key is present or not.
     */
    public static boolean isKeyPresent(String key) {
        return distanceCache.containsKey(key);
    }
    
    /**
     * Returns the distance value.
     */
    public static Double valueOf(String key) {
        return distanceCache.get(key);
    }
    
    /**
     * Generates the DP key for the given coordinates.
     *
     * @param c1, source coordinate.
     * @param c2, destination coordinate.
     * @return generatedKey
     */
    public static String generateKey(Coordinate c1, Coordinate c2) {
        List<Double> values = new ArrayList<>();
        values.add(c1.getX());
        values.add(c1.getY());
        values.add(c2.getX());
        values.add(c2.getY());
        Collections.sort(values);
        return values.stream().map(Object::toString).collect(Collectors.joining("_"));
    }
    
    /**
     * Returns the generated key for the cache entry.
     *
     * @param base,     a source location.
     * @param delivery, a destination location.
     * @return generatedKey
     */
    public static String generateKey(Location base, Location delivery) {
        return generateKey(base.getCoordinate(), delivery.getCoordinate());
    }
    
    /**
     * Returns the key from the list of locations, the first is source, the second is destination.
     */
    public static String generateKey(List<Location> locations) {
        return generateKey(locations.get(0), locations.get(1));
    }
    
}
