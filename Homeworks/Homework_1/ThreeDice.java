/*
*   Problem 6. (Three Dice) Write a program ThreeDice.java that writes the sum of three random integers between 1 and 6,
*   such as you might get when rolling three dice.
*   $ javac ThreeDice . java
*   $ java ThreeDice
*   5
*/
public class ThreeDice {
    public static void main(String[] args) {
        int a = 1 + (int) (Math.random() * 6);
        int b = 1 + (int) (Math.random() * 6);
        int c = 1 + (int) (Math.random() * 6);

        int sum = a + b + c;

        System.out.println(sum);
    }
}
