package edu.eec.nearutils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class is a part of the package com.iict.algorithm.program and the package
 * is a part of the project CWRouting.
 * <p>
 * Integrated ICT Pvt. Ltd. Jwagal, Lalitpur, Nepal.
 * https://www.integratedict.com.np
 * <p>
 * Created by Santa on 2022-10-24.
 */
public class Conversion {
    
    /**
     * Unit mile for unit time, in Minutes.
     *
     * @return timeTakenForUnitMile
     */
    public static double unitTimeMile() {
        return ((double) Constants.IN_MINUTES / (double) Constants.MILES_PER_HOUR);
    }
    
    /**
     * Calculation for the time taken between two nodes, the approximated miles per hour is used.
     *
     * @param distance, in miles.
     * @return timeInMinutes
     */
    public static int timeTakenInMinutes(int distance) {
        return (int) (distance * unitTimeMile());
    }
    
    
    /**
     * Json Writer Utility.
     */
    public static String toJson(Object data) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(data);
    }
    
}
