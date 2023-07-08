package edu.eec.nearutils;

/**
 * This class is a part of the package com.iict.algorithm.program and the package
 * is a part of the project CWRouting.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-10-18.
 */
public class Constants {

    /**
     * Empty String
     */
    public static final String EMPTY = "";

    /**
     * Path literal.
     */
    public static final String PATHS = "paths";

    /**
     * Distance literal.
     */
    public static final String DISTANCE = "distance";

    /**
     * Time literal.
     */
    public static final String TIME = "time";

    /**
     * Delivery literal.
     */
    public static String DELIVERY = "Delivery";

    /**
     * Lambda parameter: inter customer distance
     */
    public static final Double lambda = 1.3d;

    /**
     * Max capacity.
     */
    public static final int MAX_CAPACITY = 3499;

    /**
     * Max allowed time in Minutes.
     */
    public static final int MAX_TIME = 450;

    /**
     * Route Parameter.
     */
    public static final double MEU = 0.3d;

    /**
     * Demand Parameter.
     */
    public static final double NEU = 4.0d;

    /**
     * Constant for miles per hours.
     */
    public static final int MILES_PER_HOUR = 50;

    /**
     * Constant for Minutes time.
     */
    public static final int IN_MINUTES = 60;

    /**
     * Tabu Search Parameter
     */
    public static int TABU_HORIZON = 10;

    /**
     * Tabu Period.
     */
    public static int TABU_PERIOD = 5;

    /**
     * Maximum iteration for intra-route search.
     */
    public static int MAX_ITERATIONS_INTRA_SEARCH = 2;

    /**
     * Maximum iteration for tabu-search.
     */
    public static int MAX_ITERATIONS_TABU_SEARCH = 2;

}
