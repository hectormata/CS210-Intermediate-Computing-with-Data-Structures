/*
 *  Problem 5. (Rational Number ) Implement a data type Rational in Rational.java
 *  that represents a rational number, ie, a number of the form a/b where a and b 
 *  are not equal to 0 are integers. The data type must support the following API:
 * 
 *  method                              description
 *  Rational(long x)                    construct a rational number whose numerator is the given number and denominator is 1
 *  Rational(long x, long y)            construct a rational number given its numerator and denominator†
 *  Rational add(Rational that)         the sum of this and that rational number
 *  Rational multiply(Rational that)    the product of this and that rational number
 *  String toString()                   a string representation of the rational number
 *
 *  † Use the private method gcd() to ensure that the numerator and denominator 
 *  never have any common factors. For example, the rational number 2/4 must be
 *  represented as 1/2.
 *  $ java Rational 10
 *  1023/512
 */
public class Rational {
    private long x; // numerator
    private long y; // denominator

    // Construct a rational number whose numerator is x and denominator is 1.
    public Rational(long x) {
        this.x = x;
        this.y = 1;
    }

    // Construct a rational number given its numerator and denominator.
    public Rational(long x, long y) {
        this.x = x / gcd(x, y);
        this.y = y / gcd(x, y);
    }

    // The sum of this and that rational number.
    public Rational add(Rational that) {
        long Cd = this.y * that.y;
        long num = this.x * that.y;
        num += that.x * this.y;
        return new Rational(num, Cd);
    }

    // The product of this and that rational number.
    public Rational multiply(Rational that) {
        long x = this.x * that.x;
        long y = this.y * that.y;
        return new Rational(x, y);
    }

    // A string representation of the rational number.
    public String toString() {
        long a = x, b = y;
        if (a == 0 || b == 1) {
            return a + "";
        }
        if (b < 0) {
            a *= -1;
            b *= -1;
        }
        return a + "/" + b;
    }

    // gcd(p, q), computed using Euclid's algorithm.
    private static long gcd(long p, long q) {
        return q == 0 ? p : gcd(q, p % q);
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Rational total = new Rational(0);
        Rational term = new Rational(1);
        for (int i = 1; i <= n; i++) {
            total = total.add(term);
            term = term.multiply(new Rational(1, 2));
        }
        System.out.println(total);
    }
}
