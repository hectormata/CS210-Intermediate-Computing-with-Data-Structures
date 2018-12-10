/*
 *  Problem 4. (3D Point) Implement an immutable data type Point3D
 *  in Point3D.java that represents a point in 3D and supports the
 *  following API:
 *
 *  method/class                            description
 *  Point3D(double x, double y, double z)   construct a point in 3D given its coordinates
 *  double distance(Point3D that)           the Euclidean distance† between this point and that
 *  String toString()                       a string representation of the point, in "(x, y, z)" format
 *
 *  $ java Point3D
 *  3
 *  -3 1 6
 *  0 5 8
 *  -5 -7 -3
 *  ( -3.0 , 1.0 , 6.0) , distance to origin = 6.782329983125268
 *  (0.0 , 5.0 , 8.0) , distance to origin = 9.433981132056603
 *  ( -5.0 , -7.0 , -3.0) , distance to origin = 9.1104335791443
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Point3D {
    private final double x; // x coordinate
    private final double y; // y coordinate
    private final double z; // z coordinate

    // Construct a point in 3D given its coordinates.
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // The Euclidean distance between this point and that.
    public double distance(Point3D that) {
        double x1 = this.x;
        double x2 = that.x;
        double y1 = this.y;
        double y2 = that.y;
        double z1 = this.z;
        double z2 = that.z;

        double D = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
        return D;
    }

    // A string representation of the point, as "(x, y, z)".
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Point3D[] points = new Point3D[n];
        for (int i = 0; i < n; i++) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            double z = StdIn.readDouble();
            points[i] = new Point3D(x, y, z);
        }
        Point3D origin = new Point3D(0, 0, 0);
        for (Point3D point : points) {
            StdOut.println(point + ", distance to origin = "
                           + point.distance(origin));
        }
    }
}
