package edu.eec.nearmodel;

import java.util.*;
import java.util.stream.Collectors;

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
public class NearGraph {
    
    private Vertex root;
    
    /**
     * Adjacency list representation of Graph.
     */
    private final Map<Vertex, Set<Edge>> adjacentList;
    
    /**
     * Default Constructor.
     */
    public NearGraph() {
        this.adjacentList = new HashMap<>();
    }
    
    /**
     * Set a root vertex.
     */
    public NearGraph setRoot(Vertex vertex){
        this.root = vertex;
        return this;
    }
    
    public Vertex getRoot(){
        return this.root;
    }
    
    public Set<Vertex> vertices(){
        return this.adjacentList.keySet();
    }
    
    public Set<Edge> edges(){
        return this.adjacentList.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }
    
    /**
     * Get root id.
     */
    public int rootId(){
        return this.root.getId();
    }
    
    public int countVertices(){
        return this.adjacentList.keySet().size();
    }
    
    public int countEdges(){
        return this.adjacentList.values().stream().map(Set::size).reduce(0, Integer::sum);
    }
    
    /**
     * Check if the vertex is present in the graph or not.
     */
    private boolean isVertexPresent(Vertex vertex) {
        return this.adjacentList.containsKey(vertex);
    }
    
    private boolean isVertexPresent(String code) {
        return this.adjacentList.keySet().stream()
                .anyMatch(v -> Objects.equals(v.code(), code));
    }
    
    public Optional<Vertex> vertexByLabel(String label){
        return this.adjacentList.keySet().stream().filter(v -> Objects.equals(v.code(), label)).findAny();
    }
    
    /**
     * Add new edge to the associated vertex of the near graph.
     */
    public NearGraph addEdge(Edge newEdge) {
        /**
         * Perform add operation of the given edge.
         */
        Optional<Vertex> source = vertexByLabel(newEdge.getSource());
        if(source.isPresent()) {
            Set<Edge> edges = this.adjacentList.getOrDefault(source.get(), emptyEdges());
            edges.add(newEdge);
        }
        return this;
    }
    
    /**
     * Add new vertex to near graph.
     */
    public NearGraph addVertex(Vertex vertex) {
        /**
         * Check if the vertex is already exists.
         */
        if (!this.adjacentList.containsKey(vertex)) this.adjacentList.put(vertex, emptyEdges());
        return this;
    }
    
    /**
     * Checks if the graph is empty.
     */
    public boolean isEmpty() {
        return this.adjacentList.isEmpty();
    }
    
    /**
     * Factory Utility for the Graph Representation.
     */
    public static NearGraph create() {
        return new NearGraph();
    }
    
    /**
     * The empty edges.
     */
    private Set<Edge> emptyEdges() {
        return new HashSet<>();
    }
    
    /**
     * Stringify the instance with Json formatting.
     **/
    @Override
    public String toString() {
        return SerializedGraph.from(root, this.adjacentList).toString();
    }
}
