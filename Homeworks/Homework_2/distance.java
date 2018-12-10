/*
 *  Problem 3. (Euclidean Distance) Implement the static method distance() 
 *  in Distance.java that takes position vectors x and y — each represented
 *  as a 1D array of doubles — as arguments and returns the Euclidean 
 *  distance between them, calculated as the square root of the sums of the
 *  squares of the differences between the corresponding entries.
 *  $ javac Distance . java
 *  $ java Distance
 *  5
 *  -9 1 10 -1 1
 *  5
 *  -5 9 6 7 4
 *  13.0
 */
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;

public class Distance {
    // Returns the Euclidean distance between the position vectors x and y.
    private static double distance(double[] x, double[] y) {
        double s = 0;
        for (int i = 0; i < x.length; i++){
            s = s + (x[i] - y[i]) * (x[i] - y[i]);
        }
        return Math.pow(s, 0.5);  
    }

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        double[] x = StdArrayIO.readDouble1D();
        double[] y = StdArrayIO.readDouble1D();
        StdOut.println(distance(x, y));
    }
}
