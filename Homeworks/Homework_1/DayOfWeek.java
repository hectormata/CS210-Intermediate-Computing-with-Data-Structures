/* Problem 3. (Day of the Week) Write a program DayOfWeek.java that takes three integers m (for month), d (for day), and y
 * (for year) as command-line arguments and writes the day of the week (0 for Sunday, 1 for Monday, and so on) D, calculated
 * as follows:
 *
 * y0 = y − (14 − m)/12
 * x0 = y0 + y0/4 − y0/100 + y0/400
 * m0 = m + 12 × ((14 − m)/12) − 2
 * D = (d + x0 + 31 × m0/12) mod 7
 *
 * $ javac DayOfWeek . java
 * $ java DayOfWeek 3 14 1879
 * 5
/*
public class DayOfWeek {

    public static void main(String[] args) {
    
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31*m0)/12) % 7;

        System.out.println(d0);
    }
}  
