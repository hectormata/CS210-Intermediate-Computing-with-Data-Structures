/*
 *  Problem 3. (Geo Location) Implement an immutable data type Location
 *  in Location.java that represents a location on Earth and supports
 *  the following API:
 *
 *  method                                          description
 *  Location(String loc, double lat, double lon)    construct a new location given its name, latitude, and longitude values
 *  double distanceTo(Location that)                the great-circle distance† between this location and that
 *  boolean equals(Location that)                   is this location the same as that?
 *  String toString()                               a string representation of the location, in "loc (lat, lon)" format
 *
 *  $ java Location 5 40.6769 117.2319
 *  The Great Wall of China ( China ) (40.6769 , 117.2319)
 *  Petra ( Jordan ) (30.3286 , 35.4419)
 *  The Colosseum ( Italy ) (41.8902 , 12.4923)
 *  Chichen Itza ( Mexico ) (20.6829 , -88.5686)
 *  Machu Picchu ( Peru ) ( -13.1633 , -72.5456)
 *  Taj Mahal ( India ) (27.175 , 78.0419)
 *  Christ the Redeemer ( Brazil ) (22.9519 , -43.2106)
 *  3868.964067791193
 *  false
 */
 public class Location {
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
        for (Location wonder : wonders) {
            StdOut.println(wonder);
        }
        System.out.println(wonders[rank].distanceTo(new Location("", lat, lon)));
        System.out.println(wonders[rank].equals(new Location("", lat, lon)));
    }
}
