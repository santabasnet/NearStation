package edu.eec.nearapp;


import edu.eec.nearmodel.Coordinate;
import edu.eec.nearutils.RoutingUtils;

/**
 * This class is a part of the package edu.eec.app and the package
 * is a part of the project GraphhopperCall.
 * <p>
 * Integrated ICT Pvt. Ltd. Jwagal, Lalitpur, Nepal.
 * https://www.integratedict.com.np
 * https://www.semantro.com
 * <p>
 * Created by Santa on 2023-06-09.
 */
public class MainApp {
    
    public static void main(String[] args) {
        
        /**
         * Location of Lubhu Party Palace.
         */
        double lat1 = 27.646882514723053f;
        double lon1 = 85.37105790960555f;
        Coordinate from = new Coordinate(lat1, lon1);
        
        /**
         * Location of Radisson Hotel Kathmandu.
         */
        double lat2 = 27.717740754210862f;
        double lon2 = 85.31636173627547f;
        Coordinate to = new Coordinate(lat2, lon2);
        
        double distanceMiles = RoutingUtils.distanceInMiles(from, to);
        System.out.println("Calculated Distance(Miles) : " + distanceMiles);
        
        double distanceKm = RoutingUtils.distanceInKilometers(from, to);
        System.out.println("Calculated Distance(Kms) : " + distanceKm);
    
    }
    
}
