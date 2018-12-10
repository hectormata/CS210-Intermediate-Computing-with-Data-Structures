/*
 *  Problem 5. (Exponentiation) Implement the static method power() in Power.java
 *  that takes two integer arguments a and b and returns the value of a^b, 
 *  computed recursively using the recurrence relation
 *
 *  $ javac Power . java
 *  $ java Power 3 5
 *  243
*/
public class Power {
    // Returns a to the power b, computed recursively.
    private static int power(int a, int b) {
        if (b == 0){
            return 1;
        }
        if (b % 2 != 0){
            return a * power(a, b - 1);
        }
        if (b % 2 == 0){
            return power((a * a), (b / 2));
        }
        return b;
    }

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(power(a, b));
    }
}
