package java_lessons.lesson1;

/**
 *  MixedMath class.
 *  Don't go from a wide data type to a narrower data type.
 */
public final class MixedMath {

    /** Constructor. */
    private MixedMath() { }

    /**
     * Unit tests.
     * @param args the arguments
     */
    public static void main(final String[] args) {

        // Cant convert a double to an int because of possible loss of data.
        // A double is a wider data type than an integer.
        int num;
        double dnum = 2;
        //num = dnum;
        //System.out.println(dnum);

        // Prints the ASCII value of a character.
        int num2;
        char c = 'z';
        num = c;
        System.out.println(num);
    }
}
