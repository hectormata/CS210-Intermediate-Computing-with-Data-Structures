/*
 *  Problem 1. (Comparable Six-sided Die) Implement a comparable data type
 *  Die in Die.java that represents a six-sided die and supports the 
 *  following API:
 *
 *  method                              description
 *  Die()                               construct a die
 *  void roll()                         roll the die
 *  int value()                         face value of the die
 *  boolean equals(Die that)            does the die have the same face value as that?
 *  int compareTo(Die that)             the signed difference between the face values of this die and that
 *  String toString()                   a string representation of the current face value of the die, ie,
 *
 *  $ java Die 5 3 3
    *   *
      *
    *   *
 *  false
 *  true
 *  2
 *  0
 */
public class Die implements Comparable<Die> {
    private int value; // face value

    // Roll the die.
    public void roll() {
        this.value = 1 + (int) (Math.random() * 6);
    }

    // Face value of the die.
    public int value() {
        return this.value; 
    }

    // Does the die have the same face value as that?
    public boolean equals(Die that) {
        return this.value == that.value;
    }

    // A negative integer, zero, or positive integer depending on whether this
    // die's value is less than, equal to, or greater than the that die's value.
    public int compareTo(Die that) {
        //if (this.value > that.value) { return 2; }
        //if (this.value == that.value) { return 0; }
        //else { return -1; }
        return this.value - that.value;
    }

    // A string representation of the die giving the current face value.
    public String toString() {
        if (this.value == 1)  return "     \n  *  \n     "; 
        if (this.value == 2)  return "*    \n     \n    *"; 
        if (this.value == 3)  return "*    \n  *  \n    *"; 
        if (this.value == 4)  return "*   *\n     \n*   *"; 
        if (this.value == 5)  return "*   *\n  *  \n*   *"; 
        if (this.value == 6)  return "* * *\n     \n* * *"; 
        return "unknown number";       
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        Die a = new Die();
        a.roll();
        while (a.value() != x) {
            a.roll();
        }
        Die b = new Die();        
        b.roll();
        while (b.value() != y) {
            b.roll();
        }
        Die c = new Die();        
        c.roll();
        while (c.value() != z) {
            c.roll();
        }
        System.out.println(a);
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));        
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(c));        
    }
}
