package advanced_java.ch5_data_structures;

import java.util.Stack;

public class ConvertDecToBinary {
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

    public static void main(String[] args) {
        int num = 5; //101
        System.out.println(num + " in binary is " + binary(num));
    }
}
