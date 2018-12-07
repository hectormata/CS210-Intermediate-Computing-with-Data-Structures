/*
*   Problem 5. (Three Sort) Write a program ThreeSort.java that takes three integers as command-line arguments and writes
*   them in ascending order, separated by spaces. Use Math.min() and Math.max().
*
*   $ javac ThreeSort . java
*   $ java ThreeSort 1 2 3
*   1 2 3
*   $ java ThreeSort 1 3 2
*   1 2 3
*   $ java ThreeSort 2 1 3
*   1 2 3
*   $ java ThreeSort 2 3 1
*   1 2 3
*   $ java ThreeSort 3 1 2
*   1 2 3
*   $ java ThreeSort 3 2 1
*1 2 3
*/
public class ThreeSort { 
    public static void main(String[] args) { 
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        // compute stats
        int min    = Math.min(a, Math.min(b, c));
        int max    = Math.max(a, Math.max(b, c));
        int median = a + b + c - min - max;

        // print stats
        System.out.println(min);
        System.out.println(median);
        System.out.println(max);
    }
}
