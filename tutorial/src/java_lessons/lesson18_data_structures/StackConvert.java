package java_lessons.lesson18_data_structures;

import java.util.Stack;

/**
 *  StackConvert class.
 *  This class uses a Stack to convert decimal numbers to binary.
 */
public final class StackConvert {

    /** Constructor. */
    private StackConvert() { }

    /**
     * Convert a decimal number to binary format.
     *
     * @param number an integer number
     * @return the binary number as a String
     */
    private static String binary(int number) {

        final int base = 2;
        Stack digits = new Stack();

        do {
            digits.push(number % base);  // this will be a bit or a binary digit
            // divide number by base to continue on to next place holder
            number /= base;
        } while (number != 0);

        String bits = "";
        while (!digits.empty()) {
            bits += digits.pop();
        }
        return bits;
    }

    /**
     * Unit tests for StackConvert class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        int num = 5; //101
        System.out.println(num + " in binary is " + binary(num));
    }
}
