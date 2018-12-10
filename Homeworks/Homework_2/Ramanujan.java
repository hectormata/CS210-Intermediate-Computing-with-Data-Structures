/*
 *  Problem 2. (Ramanujan’s Taxi) Srinivasa Ramanujan was an Indian mathematician
 *  who became famous for his intuition for numbers. When the English mathematician
 *  G. H. Hardy came to visit him one day, Hardy remarked that the number of his 
 *  taxi was 1729, a rather dull number. To which Ramanujan replied, “No, Hardy! It
 *  is a very interesting number. It is the smallest number expressible as the sum 
 *  of two cubes in two different ways.” Verify this claim by writing a program
 *  Ramanujan.java that takes a command-line argument N and prints out all integers
 *  less than or equal to N that can be expressed as the sum of two cubes in two 
 *  different ways. In other words, find distinct positive integers a, b, c, and d 
 *  such that a3 + b3 = c3 + d3. Hint: Use four nested for loops, with these bounds
 *  on the loop variables: 0 < a ≤
 *
 *  $ javac Ramanujan . java
 *  $ java Ramanujan 40000
 *  1729 = 1^3 + 12^3 = 9^3 + 10^3
 *  4104 = 2^3 + 16^3 = 9^3 + 15^3
 *  13832 = 2^3 + 24^3 = 18^3 + 20^3
 *  39312 = 2^3 + 34^3 = 15^3 + 33^3
 *  32832 = 4^3 + 32^3 = 18^3 + 30^3
 *  20683 = 10^3 + 27^3 = 19^3 + 24^3
 */
 public class Ramanujan {
    public static void main(String[] args) {
        // read command line args
        int n = Integer.parseInt(args[0]);

        // check if a^3 + b^3 = c^3 +d^3
        for (int a = 1; a <= n; a++){
            int a3 = a * a * a;
            if (a3 > n){
                break;
            }
        
            // then b (start at a)
            for (int b = a; b <= n; b++){
                int b3 = b * b * b;
                if (a3 + b3 > n){
                    break;
                }

                // c: start at a+1
                for (int c = a + 1; c <= n; c++){
                    int c3 = c * c * c;
                    if (c3 > a3 + b3){
                        break;
                    }

                    // d: start at a
                    for (int d = c; d <= n; d++){
                        int d3 = d * d * d;
                        if (c3 + d3 > a3 + b3){
                            break;
                        }
                        if (c3 + d3 == a3 + b3){
                            System.out.print((a3 + b3) + " = ");
                            System.out.print(a + "^3 + " + b + "^3 = ");
                            System.out.print(c + "^3 + " + d + "^3");
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
