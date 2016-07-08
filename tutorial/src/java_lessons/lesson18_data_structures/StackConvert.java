package java_lessons.lesson18_data_structures;

import java.util.Stack;

/**
 * This class uses a Stack to convert decimal numbers to binary.
 */
public class StackConvert {
    /**
     * this method converts a decimal number to binary format.
     *
     * @param number an integer number
     * @return the binary number as a String
     */
    static String binary(int number) {

        final int base = 2;
        Stack digits = new Stack();

        do {
            digits.push(number % base);  // this will be a bit or a binary digit
            number /= base; // divide number by base to continue on to next place holder
        } while (number != 0);

        String bits = "";
        while(!digits.empty())
            bits += digits.pop();

        return bits;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        int num = 5; //101
        System.out.println(num + " in binary is " + binary(num));
    }
}
