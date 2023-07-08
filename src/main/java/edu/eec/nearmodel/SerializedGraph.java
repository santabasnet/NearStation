package edu.eec.nearmodel;

import edu.eec.nearutils.Conversion;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class is a part of the package edu.eec.nearmodel and the package
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
public class SerializedGraph {
    
    private final Vertex root;
    private final Set<Vertex> vertexSet;
    private final Set<Edge> edgeSet;
    
    public SerializedGraph(Vertex root, Set<Vertex> vertexSet, Set<Edge> edgeSet) {
        this.root = root;
        this.vertexSet = vertexSet;
        this.edgeSet = edgeSet;
    }
    
    public Set<Vertex> getVertexSet() {
        return vertexSet;
    }
    
    public Set<Edge> getEdgeSet() {
        return edgeSet;
    }
    
    /**
     * Json Conversion Utility.
     */
    @Override
    public String toString() {
        return Conversion.toJson(this);
    }
    
    /**
     * Factory for the Graph generated from map data.
     */
    public static SerializedGraph from(Vertex root, Map<Vertex, Set<Edge>> nearGraph) {
        return new SerializedGraph(
                root,
                nearGraph.keySet(),
                nearGraph.values().stream().flatMap(Set::stream).collect(Collectors.toSet())
        );
    }
}
