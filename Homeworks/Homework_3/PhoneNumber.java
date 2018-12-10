/*
 *  Problem 2. (US Phone Number ) Implement an immutable data type
 *  PhoneNumber in PhoneNumber.java that represents a US phone number,
 *  and supports the following API:
 *
 *  method                                   description
 *  PhoneNumber(int area, int exch, int ext) construct a phone number given the area code, exchange, and extension
 *  boolean equals(PhoneNumber that)          is the phone number same as that?
 *  String toString()                         a string representation of the phone number, in "(area) exch-ext" format (use String.format())
 *  $ java PhoneNumber
 *  (609) 258 -4455
 *  (609) 876 -5309
 *  (609) 003 -5309
 *  (215) 876 -5309
 *  (609) 876 -5309
 *  true
 *  false
 *  true
 *  true
 */
 public class PhoneNumber {
    private final int area; // area code (3 digits)
    private final int exch; // exchange  (3 digits)
    private final int ext;  // extension (4 digits)
    
    // Construct a phone number given the area code, exchange, and extension.
    public PhoneNumber(int area, int exch, int ext) {
        this.area = area;
        this.exch = exch;
        this.ext = ext;
    }

    // Is this phone number the same as that?
    public boolean equals(PhoneNumber that) {
        return (this.area == that.area && this.exch == that.exch && this.ext == that.ext);
    }

    // A string representation of the phone number, in "(area) exch-ext" 
    // format. Use String.format().
    public String toString() {
        return String.format("(%03d) %03d-%04d", area, exch, ext);
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        PhoneNumber a = new PhoneNumber(609, 258, 4455);
        PhoneNumber b = new PhoneNumber(609, 876, 5309);
        PhoneNumber c = new PhoneNumber(609, 003, 5309);
        PhoneNumber d = new PhoneNumber(215, 876, 5309);
        PhoneNumber e = new PhoneNumber(609, 876, 5309);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(b == b);
        System.out.println(b == e);
        System.out.println(b.equals(b));
        System.out.println(b.equals(e));
    }
}
