package edu.eec.nearcontroller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.eec.nearmodel.Edge;
import edu.eec.nearmodel.Vertex;
import edu.eec.nearutils.Conversion;

/**
 * This class is a part of the package edu.eec.nearcontroller and the package
 * is a part of the project NearStation.
 * <p>
 * Integrated ICT Pvt. Ltd. Jwagal, Lalitpur, Nepal.
 * https://www.integratedict.com.np
 * https://www.semantro.com
 * <p>
 * Created by Santa on 2023-07-08.
 * Email: sbasnet81[at]gmail[dot]com
 * Github: https://github.com/santabasnet
 */
public class Result {
    
    /**
     * Source vertex.
     */
    private final Vertex source;
    
    private final Edge edge;
    
    private final Vertex destination;
    
    /**
     * Default constructor.
     */
    public Result(Vertex source, Edge edge, Vertex destination) {
        this.source = source;
        this.edge = edge;
        this.destination = destination;
    }
    
    /**
     * To Json representation.
     */
    @Override
    public String toString() {
        return Conversion.toJson(this);
    }
    
    /**
     * Empty Result.
     */
    public static Result empty() {
        return new Result(Vertex.empty(), Edge.empty(), Vertex.empty());
    }
}
