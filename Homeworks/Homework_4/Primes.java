/*
 *  Problem 5. (Iterable Primes) Implement an immutable, iterable data type
 *  Primes in Primes.java to systematically iterate over the first n primes. 
 *  The data type must support the following API:
 *
 *  method                          description
 *  Primes(int n)                   construct an iterable Primes object given the number of primes needed
 *  Iterator<Integer> iterator()    an iterator for the given number of primes
 *  $ java Primes 10
 *  2
 *  3
 *  5
 *  7
 *  11
 *  13
 *  17
 *  19
 *  23
 *  29
*/
import java.util.Iterator;
 
// An immutable data type to systematically iterate over the first n primes.
public class Primes implements Iterable<Integer> {
    private final int n; // need first n primes
 
    // Construct an iterable Primes object given the number of primes needed.
    public Primes(int n) {
        this.n = n;
    }
 
    // A PrimesIterator object.
    public Iterator<Integer> iterator() {
        return new PrimesIterator();
    }
    
    // Primes iterator.
    private class PrimesIterator implements Iterator<Integer> {
        private int count = 0; // number of primes returned
        private int p = 2;     // current prime
 
        // Are there anymore primes left to be iterated?
        public boolean hasNext() {
            return count < n;
        }
 
        // The next prime.
        public Integer next() {
            while (!isPrime(p)) {
                p = p + 1;
            }
            count = count + 1;
            p = p + 1;
            return p - 1;
        }
        
        // Remove is not supported.
        public void remove() {
            // nothing to do
        }
 
        // Is x (>= 2) prime?
        private boolean isPrime(int x) {
            for (int i = 2; i <= x / i; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
 
    // Test client. [DO NOt EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i : new Primes(n)) {
            System.out.println(i);
        }
    }
}
