package edu.eec.nearmodel;

import edu.eec.nearutils.Conversion;

/**
 * This class is a part of the package edu.eec.nearmodel and the package
 * is a part of the project NearStation.
 * <p>
 * Integrated ICT Pvt. Ltd. Jwagal, Lalitpur, Nepal.
 * https://www.integratedict.com.np
 * https://www.semantro.com
 * <p>
 * Created by Santa on 2023-07-07.
 * Email: sbasnet81[at]gmail[dot]com
 * Github: https://github.com/santabasnet
 */
public class Vertex {
    
    /**
     * Vertex ID.
     */
    private final int id;
    
    /**
     * Label.
     */
    private String label;
    
    /**
     * Latitude.
     */
    private final double lat;
    
    /**
     * Longitude.
     */
    private final double lon;
    
    /**
     * Default Constructor.
     */
    
    public Vertex(int id, double lat, double lon) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.label = String.valueOf(this.hashCode());
    }
    
    public int getId() {
        return id;
    }
    
    public String code() {
        return this.label;
    }
    
    public double getLat() {
        return lat;
    }
    
    public double getLon() {
        return lon;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    @Override
    public String toString() {
        return Conversion.toJson(this);
    }
    
    public static Vertex from(int id, double lat, double lon) {
        return new Vertex(id, lat, lon);
    }
    
    public static Vertex empty(){
        return new Vertex(0, 0.0, 0.0);
    }
}
