/*
*   Problem 4. (Great Circle) Write a program GreatCircle.java that takes four 
*   doubles x1, y1, x2, and y2 representing the latitude and longitude in 
*   degrees of two points on earth as command-line arguments and writes the 
*   great-circle distance (in km) between them, given by the equation:
*
*   d = 111 arccos(sin(x1) sin(x2) + cos(x1) cos(x2) cos(y1 − y2)).
*
*   Note that this equation uses degrees, whereas Java’s trigonometric 
*   functions use radians. Use Math.toRadians() and Math.toDegrees() to convert 
*   between the two. Use your program to compute the great-circle distance between
*   Paris (48.87◦ N and 2.33◦ W) and San Francisco (37.8◦ N and 122.4◦ W).
*
*   $ javac GreatCircle . java
*   $ java GreatCircle 
*
*/
public class GreatCircle { 
    public static void main(String[] args) { 
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

       /*************************************************************************
        * Compute using law of cosines
        *************************************************************************/
        // great circle distance in radians
        double angle1 = Math.acos(Math.sin(x1) * Math.sin(x2)
                      + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        // convert back to degrees
        angle1 = Math.toDegrees(angle1);

        // each degree on a great circle of Earth is 60 nautical miles
        double distance1 = 60 * angle1;

        System.out.println(distance1 + " nautical miles");


       /*************************************************************************
        * Compute using Haverside formula
        *************************************************************************/
        double a = Math.pow(Math.sin((x2-x1)/2), 2)
                 + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2-y1)/2), 2);

        // great circle distance in radians
        double angle2 = 2 * Math.asin(Math.min(1, Math.sqrt(a)));

        // convert back to degrees
        angle2 = Math.toDegrees(angle2);

        // each degree on a great circle of Earth is 60 nautical miles
        double distance2 = 60 * angle2;

        System.out.println(distance2 + " nautical miles");
    }

}
