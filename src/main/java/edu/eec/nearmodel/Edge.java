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
public class Edge {
    
    /**
     * Label of the edge.
     */
    private final String label;
    
    /**
     * Weight value for the edge.
     */
    private final double weight;
    
    /**
     * Destination Vertex.
     */
    private final String destination;
    
    /**
     * Source Vertex.
     */
    private final String source;
    
    /**
     * Default constructor.
     */
    public Edge(String source, String label, double weight, String destination) {
        this.label = label;
        this.weight = weight;
        this.destination = destination;
        this.source = source;
    }
    
    public String getLabel() {
        return label;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public String getSource() {
        return source;
    }
    
    @Override
    public String toString() {
        return Conversion.toJson(this);
    }
    
    /**
     * A factory for the Edge object.
     */
    public static Edge from(String source, String label, double weight, String destination) {
        return new Edge(source, label, weight, destination);
    }
    
    public static Edge empty() {
        return new Edge("", "", 0.0, "");
    }
}
