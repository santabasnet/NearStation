package edu.eec.nearmodel;

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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents Lat/Lon Coordinate
 */
public class Coordinate {

    private double x, y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(Coordinate c) {
        this.x = c.x;
        this.y = c.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isZero() {
        return this.x == 0.0 || this.y == 0.0;
    }

    public boolean isNotZero() {
        return !isZero();
    }

    public String parenthesized() {
        return new StringBuffer()
                .append("(")
                .append(this.getX())
                .append(",")
                .append(this.getY())
                .append(")")
                .toString();
    }

    public String getKey() {
        List<Double> items = Arrays.asList(x, y);
        Collections.sort(items);
        return items.stream().map(Object::toString).collect(Collectors.joining("_"));
    }

    public static Coordinate of(double x, double y) {
        return new Coordinate(x, y);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
