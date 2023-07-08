package edu.eec.nearutils

import edu.eec.nearmodel.Coordinate
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.{CloseableHttpClient, HttpClients}
import org.apache.http.util.EntityUtils
import org.apache.lucene.util.SloppyMath
import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods

import scala.util.Try

/**
 * This class is a part of the package edu.eec.utils and the package
 * is a part of the project GraphhopperCall.
 *
 * Integrated ICT Pvt. Ltd. Jwagal, Lalitpur, Nepal.
 * https://www.integratedict.com.np
 * https://www.semantro.com
 *
 * Created by Santa on 2023-06-09.
 */


object RoutingUtils {

    /** Threshold control number of clusters. */
    /** 1.0 assigns single cluster for all the delivery locations */
    val theta: Double = 0.3d

    /** Parameter for distance between two delivery locations */
    val lambda: Double = 1.3d

    /**
     * Mile factor.
     */
    val mileFactor: Double = 0.000621371d

    /**
     * Minute factor.
     */
    val minuteFactor: Int = 60 * 1000

    /**
     * Kilometer factor.
     */
    val kilometerFactor: Double = 0.001d

    private def roundAt(p: Int)(n: Double): Double = BigDecimal(n).setScale(p, BigDecimal.RoundingMode.HALF_UP).toDouble

    def roundAt3(d: Double): Double = roundAt(3)(d)

    def roundAt2(n: Double): Double = roundAt(2)(n)

    /**
     * Calculate the distance between two locations.
     *
     * @param lat1 , a double latitude parameter
     * @param lon1 , a double longitude parameter
     * @param lat2 , a double latitude parameter
     * @param lon2 , a double longitude parameter
     * @return calculatedDistance in Double
     */
    def distanceOf(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double = RouteDistanceClient
        .of(lat1, lon1, lat2, lon2).calculate match {
        case Some(value) => roundAt2(value)
        case None => roundAt2(SloppyMath.haversinMeters(lat1, lon1, lat2, lon2))
    }

    /**
     * Calculate the distance between two locations in miles.
     *
     * @param lat1 , a double latitude parameter
     * @param lon1 , a double longitude parameter
     * @param lat2 , a double latitude parameter
     * @param lon2 , a double longitude parameter
     * @return calculatedDistance in Double.
     */
    def distanceInMiles(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double =
        roundAt2(distanceOf(lat1 = lat1, lon1 = lon1, lat2 = lat2, lon2 = lon2) * mileFactor)

    /**
     * Calculate the distance between two locations in miles.
     *
     * @param c1 , first source coordinate in tuple.
     * @param c2 , second destination coordinate in tuple.
     * @return calculatedDistance in Double.
     */
    def distanceInMiles(c1: (Double, Double), c2: (Double, Double)): Double = distanceInMiles(c1._1, c1._2, c2._1, c2._2)

    /**
     * Calculate the distance between two locations in miles.
     *
     * @param c1 , first source coordinate.
     * @param c2 , second destination coordinate.
     * @return calculatedDistance in Double.
     */
    def distanceInMiles(c1: Coordinate, c2: Coordinate): Double = distanceInMiles(c1.getX, c1.getY, c2.getX, c2.getY)

    /**
     * Calculate the distance between two locations in Kilometers.
     *
     * @param lat1 , a double latitude parameter
     * @param lon1 , a double longitude parameter
     * @param lat2 , a double latitude parameter
     * @param lon2 , a double longitude parameter
     * @return calculatedDistance in Double.
     */
    def distanceInKilometers(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double =
        roundAt2(distanceOf(lat1 = lat1, lon1 = lon1, lat2 = lat2, lon2 = lon2) * kilometerFactor)

    /**
     * Calculate the distance between two locations in Kilometers.
     *
     * @param c1 , first source coordinate in tuple.
     * @param c2 , second destination coordinate in tuple.
     * @return calculatedDistance in Double.
     */
    def distanceInKilometers(c1: (Double, Double), c2: (Double, Double)): Double =
        distanceInKilometers(c1._1, c1._2, c2._1, c2._2)

    /**
     * Calculate the distance between two locations in Kilometers.
     *
     * @param c1 , first source coordinate.
     * @param c2 , second destination coordinate.
     * @return calculatedDistance in Double.
     */
    def distanceInKilometers(c1: Coordinate, c2: Coordinate): Double =
        distanceInKilometers(c1.getX, c1.getY, c2.getX, c2.getY)

    /**
     * Distance in miles from the list with two coordinates.
     *
     * @param items , a list of two coordinates.
     * @return calculatedDistance in Double.
     */
    def distanceInMiles(items: List[Coordinate]): Double = {
        val key: String = RequestCache.generateKey(items(0), items(1))
        if (RequestCache.isKeyPresent(key)) {
            RequestCache.valueOf(key)
        } else {
            val distance: Double = distanceInMiles(items(0), items(1))
            RequestCache.update(key, distance)
            distance
        }

    }

    /**
     * Travel time between two geo-locations in the list format.
     */
    def travelTimeInMinutes(items: List[Coordinate]): Int = travelTimeInMinutes(items(0), items(1))

    /**
     * Travel time between two geo-locations.
     */
    def travelTimeInMinutes(c1: Coordinate, c2: Coordinate): Int = travelTimeInMinutes(c1.getX, c1.getY, c2.getX, c2.getY)

    /**
     * Calculate the time travel between two locations in minutes.
     *
     * @param lat1 , a double latitude parameter
     * @param lon1 , a double longitude parameter
     * @param lat2 , a double latitude parameter
     * @param lon2 , a double longitude parameter
     * @return calculatedTime.
     */
    def travelTimeInMinutes(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Int = travelTimeInMilliSeconds(lat1, lon1, lat2, lon2) / minuteFactor

    /**
     * Travel time in milli-seconds.
     */
    def travelTimeInMilliSeconds(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Int = RouteDistanceClient
        .of(lat1, lon1, lat2, lon2).calculateTime match {
        case Some(value) => value
        case None => Conversion.timeTakenInMinutes(RoutingUtils.distanceInMiles(lat1, lon1, lat2, lon2).toInt)
    }

}

/**
 * Distance Calculation Using Graphhopper request in the local.
 */

case class RouteDistanceClient(lat1: Double, lon1: Double, lat2: Double, lon2: Double) {

    implicit val formats: DefaultFormats = org.json4s.DefaultFormats

    private def parseJson(json: String): Map[String, Any] = JsonMethods
        .parse(json)
        .extract[Map[String, Any]]

    /**
     * Extract distance from the Json response of Graphhopper.
     */
    private def extractDistance(json: String): Double = parseJson(json)(Constants.PATHS)
        .asInstanceOf[List[Map[String, Any]]]
        .headOption.map(_(Constants.DISTANCE)).map(_.toString).map(_.toDouble)
        .getOrElse(0.0f)

    /**
     * Extract time taken from the Json response of Graphhopper.
     */
    private def extractTime(json: String): Int = parseJson(json)(Constants.PATHS)
        .asInstanceOf[List[Map[String, Any]]]
        .headOption.map(_(Constants.TIME)).map(_.toString).map(_.toInt)
        .getOrElse(0)


    /**
     * Calculate distance here.
     */
    def calculate: Option[Double] = LocalClient.of(this).makeRequest.map(extractDistance)

    /**
     * Calculate time taken here.
     */
    def calculateTime: Option[Int] = LocalClient.of(this).makeRequest.map(extractTime)
}

/**
 * The companion object for route distance client.
 */
object RouteDistanceClient {
    /**
     * Factory for object generation.
     *
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return distanceClient.
     */
    def of(lat1: Double, lon1: Double, lat2: Double, lon2: Double): RouteDistanceClient =
        RouteDistanceClient(lat1, lon1, lat2, lon2)
}

case class LocalClient(data: RouteDistanceClient) {

    private def parameters: String =
        s"""
           |point=${data.lat1},${data.lon1}&point=${data.lat2},${data.lon2}&type=json&locale=en-US&key=&elevation=false&profile=car
        """.stripMargin.trim

    private def url: String = List(LocalClient.URL, parameters).mkString

    private def request: HttpGet = new HttpGet(url)

    def makeRequest: Option[String] = {
        val client: CloseableHttpClient = HttpClients.createDefault()
        val result = Try(EntityUtils.toString(client.execute(request).getEntity)).toOption
        client.close()
        result
    }
}

object LocalClient {

    /**
     * Local URL for distance calculation.
     */
    private val URL: String = "http://localhost:8989/route?"

    /**
     * Object Factory.
     *
     * @param data , contains url with request data for the local connection.
     * @return localClient
     */
    def of(data: RouteDistanceClient): LocalClient = LocalClient(data)
}

