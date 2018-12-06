/*
 *    Problem 2. (Wind Chill) Given the temperature t (in Fahrenheit) and the wind speed v (in miles per hour), the National
 *   Weather Service defines the effective temperature (the wind chill) to be
 *   w = 35.74 + 0.6215t + (0.4275t − 35.75)v^0.16.
 *   
 *   Write a program WindChill.java that takes two doubles t and v as command-line arguments and writes the wind chill.
 *   $ javac WindChill . java
 *   $ java WindChill 32 15
 *   21.588988890532022
 */
 public class WindChill {
 
    public static void main(String[] args) {
        
        double t = Double.parseDouble(args[0]);
        double v = Double.parseDouble(args[1]);
        double w = 35.74 + 0.6215*t + (0.4275*t - 35.75) * Math.pow(v, 0.16);
        
        System.out.println("Temperature = " + t);
        System.out.println("Wind speed  = " + v);
        System.out.println("Wind chill  = " + w);
    }

}
 
