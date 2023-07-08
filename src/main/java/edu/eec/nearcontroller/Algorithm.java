package edu.eec.nearcontroller;

import edu.eec.nearmodel.NearGraph;

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
public interface Algorithm {
    
    /**
     * Perform the execution algorithmic operation on the given near graph.
     *
     * @param nearGraph, a graph represented from the near station locations.
     * @return solutionOutput
     */
    public Solution execute(NearGraph nearGraph);
    
}
