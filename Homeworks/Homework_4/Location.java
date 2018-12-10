/*
 *  Problem 2. (Comparable Geo Location) Implement an immutable data type
 *  Location in Location.java that represents a location on Earth and supports 
 *  the following API:
 *
 *  method                                          description
 *  Location(String loc, double lat, double lon)    construct a new location given its name, latitude, and longitude values
 *  double distanceTo(Location that)                the great-circle distance† between this location and that
 *  boolean equals(Location that)                   is this location the same as that?
 *  int compareTo(Location that)                    -1, 0, or 1 depending on whether the distance of
 *                                                  this location to the origin is less than, equal to, or greater than
 *                                                  the distance of that location to the origin, where the origin is the
 *                                                  center of the universe, ie, UMass Boston (42.3134, -71.0384)
 *  String toString()                               a string representation of the location, in "loc (lat, lon)" format
 *  † See Problem 4 of Homework 1 for formula
 *  $ java Location 5 40.6769 117.2319
 *  Chichen Itza ( Mexico ) (20.6829 , -88.5686)
 *  Christ the Redeemer ( Brazil ) (22.9519 , -43.2106)
 *  Machu Picchu ( Peru ) ( -13.1633 , -72.5456)
 *  The Colosseum ( Italy ) (41.8902 , 12.4923)
 *  Petra ( Jordan ) (30.3286 , 35.4419)
 *  The Great Wall of China ( China ) (40.6769 , 117.2319)
 *  Taj Mahal ( India ) (27.175 , 78.0419)
 *  true
*/
import java.util.Arrays;

// An immutable type representing a location on Earth.
public class Location implements Comparable<Location> {
    private final String loc; // location name
    private final double lat; // latitude
    private final double lon; // longitude

    // Construct a new location given its name, latitude, and longitude values.
    public Location(String loc, double lat, double lon) {
        this.loc = loc;
        this.lat = lat;
        this.lon = lon;
    }

    // The great-circle distance between this location and that.
    public double distanceTo(Location that) {
        double x1 = Math.toRadians(this.lat);
        double y1 = Math.toRadians(this.lon);
        double x2 = Math.toRadians(that.lat);
        double y2 = Math.toRadians(that.lon);

        double d = Math.acos(Math.sin(x1) * Math.sin(x2)
               + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        double D = Math.toDegrees(d);
        double DD = 111 * D;
        return DD;
    }

    // Is this location the same as that?
    public boolean equals(Location that) {
        return (this.lat == that.lat && this.lon == that.lon);
    }

    // -1, 0, or 1 depending on whether the distance of this 
    // location to the origin is less than, equal to, or greater than the 
    // distance of that location to the origin, where the origin is 
    // the center of the Universe, ie, UMass Boston (42.3134, -71.0384).
    public int compareTo(Location that) {
        // x  get the distance bethween origin and this (calling ) object
        // y get the distance bethween origin and that (calling ) object  
        Location origin = new Location("Umass Boston", 42.3134, -71.0384);
        double x = this.distanceTo(origin);
        double y = that.distanceTo(origin);
        if (x > y) { return 1; }
        if (x == y) { return 0; }   
        else { return -1; }
    }

    // A string representation of the location, in "loc (lat, lon)" format.
    public String toString() {
        return loc + " (" + lat + ", " + lon + ")";
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int rank = Integer.parseInt(args[0]);
        double lat = Double.parseDouble(args[1]);
        double lon = Double.parseDouble(args[2]);        
        Location[] wonders = new Location[7];
        wonders[0] = new Location("The Great Wall of China (China)", 
                                  40.6769, 117.2319);
        wonders[1] = new Location("Petra (Jordan)", 30.3286, 35.4419);
        wonders[2] = new Location("The Colosseum (Italy)", 41.8902, 12.4923);
        wonders[3] = new Location("Chichen Itza (Mexico)", 20.6829, -88.5686);
        wonders[4] = new Location("Machu Picchu (Peru)", -13.1633, -72.5456);
        wonders[5] = new Location("Taj Mahal (India)", 27.1750, 78.0419);
        wonders[6] = new Location("Christ the Redeemer (Brazil)", 
                                  22.9519, -43.2106);
        Arrays.sort(wonders);
        for (Location wonder : wonders) {
            System.out.println(wonder);
        }
        System.out.println(wonders[rank].equals(new Location("", lat, lon)));
    }
}
