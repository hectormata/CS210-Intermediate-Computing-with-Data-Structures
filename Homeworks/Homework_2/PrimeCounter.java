/*
 *  Problem 1. (Counting Primes) Implement the static method isPrime()
 *  in PrimeCounter.java that takes an integer argument x and returns 
 *  true if it is prime and false otherwise. Also implement the static
 *  method primes() that takes an integer argument N and returns the 
 *  number of primes less than or equal to N. Recall that a number x
 *  is prime if it is not divisible by any number i ∈ [2,√x].
 *
 *  $ javac PrimeCounter . java
 *  $ java PrimeCounter 100
 *  25
 *  $ java PrimeCounter 1000000
 *  78498
 */
 public class PrimeCounter {
    // Returns true if x is prime, and false otherwise.
    private static boolean isPrime(int x) {
        for (int i = 2; i <= Math.pow(x, 0.5); i++) {
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }

    // Returns the number of primes <= N.
    private static int primes(int N) {
        int count = 0;
        for (int i = 2; i <= N; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        System.out.println(primes(N));
    }
}
