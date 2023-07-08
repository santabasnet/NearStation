package edu.eec.nearapp;

import edu.eec.nearcontroller.BellmanFordAlgorithm;
import edu.eec.nearcontroller.Result;
import edu.eec.nearcontroller.Solution;
import edu.eec.nearmodel.Edge;
import edu.eec.nearmodel.NearGraph;
import edu.eec.nearmodel.Vertex;

/**
 * This class is a part of the package edu.eec.nearapp and the package
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
public class NearApp {
    
    public static void main(String[] args) {
        
        bellmanFordTest();
    }
    
    /**
     * Demo Graph.
     */
    private static void demoGraph() {
        /**
         * Build a demo graph.
         */
        
        Vertex lubhu = Vertex.from(1, 27.646882514723053f, 85.37105790960555f);
        Vertex radisson = Vertex.from(2, 27.717740754210862f, 85.31636173627547f);
        Edge toRadisson = Edge.from(lubhu.code(), "To_Radisson", 100f, radisson.code());
        
        
        NearGraph nearGraph = NearGraph.create()
                .addVertex(lubhu)
                .addVertex(radisson)
                .addEdge(toRadisson)
                .setRoot(lubhu);
        
        System.out.println("Graph : \n" + nearGraph.toString());
    }
    
    /**
     * Demo Algorithm Run.
     */
    private static void bellmanFordTest() {
        Vertex v1 = Vertex.from(1, 0.0f, 0.0f);
        Vertex v2 = Vertex.from(2, 0.0f, 0.0f);
        Vertex v3 = Vertex.from(3, 0.0f, 0.0f);
        Vertex v4 = Vertex.from(4, 0.0f, 0.0f);
        Vertex v5 = Vertex.from(5, 0.0f, 0.0f);
        Vertex v6 = Vertex.from(6, 0.0f, 0.0f);
        Edge v1ToV2 = Edge.from(v1.code(), "v1 to v2", 4.0f, v2.code());
        Edge v1ToV4 = Edge.from(v1.code(), "v1 to v4", 9.0f, v4.code());
        Edge v2ToV3 = Edge.from(v2.code(), "v2 to v3", -1.0f, v3.code());
        Edge v3ToV6 = Edge.from(v3.code(), "v3 to v6", 3.0f, v5.code());
        Edge v4ToV3 = Edge.from(v4.code(), "v4 to v3", 2.0f, v3.code());
        Edge v4ToV5 = Edge.from(v4.code(), "v4 to v5", -5.0f, v5.code());
        Edge v5ToV6 = Edge.from(v5.code(), "v5 to v6", 0.0f, v6.code());
        
        NearGraph nearGraph = NearGraph.create()
                .addVertex(v1).addVertex(v2).addVertex(v3).addVertex(v4)
                .addVertex(v5).addVertex(v6).setRoot(v1)
                .addEdge(v1ToV2).addEdge(v1ToV4).addEdge(v2ToV3)
                .addEdge(v3ToV6).addEdge(v4ToV3).addEdge(v4ToV5)
                .addEdge(v5ToV6);
        
        System.out.println("Graph: " + nearGraph.toString());
        
        Solution solution = new BellmanFordAlgorithm().execute(nearGraph);
        Result result = solution.minimumDistance();
        System.out.println("Result: \n" + result.toString());
    }
    
}
