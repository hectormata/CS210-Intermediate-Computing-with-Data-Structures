/*
 *  Problem 4. (Matrix Transpose) Implement the static method tranpose()
 *  in Transpose.java that takes a square matrix x — represented as a 
 *  2D array of doubles — as argument and transposes it in place.
 *
 *  $ javac Transpose . java
 *  $ java Transpose
 *  3 3
 *  1 2 3
 *  4 5 6
 *  7 8 9
 *  3 3
 *  1.00000 4.00000 7.00000
 *  2.00000 5.00000 8.00000
 *  3.00000 6.00000 9.00000
*/
import edu.princeton.cs.algs4.StdArrayIO;

public class Transpose {
    // Transposes the square matrix x in place.
    private static void transpose(double[][] x) {

        int n = x.length;
        
        // 2D array all initialized to false to check whats been switched
        boolean [][] checker = new boolean [n][n];
        double temp;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (! checker[i][j] && ! checker[j][i]){

                    // switch values
                    temp = x[i][j];
                    x[i][j] = x[j][i];
                    x[j][i] = temp;
                    checker[i][j] = true;
                    checker[j][i] = true;
                }
            }
        }
    }

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        double[][] x = StdArrayIO.readDouble2D();
        transpose(x);
        StdArrayIO.print(x);
    }
}
