package advanced_java.ch7_exception_handling;

import com.sun.org.apache.bcel.internal.generic.ArithmeticInstruction;

public class TryCatch {
    public static void main(String[] args) {
        int numer = 12;
        int denom = 0;
        try {
            System.out.print(numer / denom);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero.");
            denom = 2;
            System.out.print(numer / denom);
        }
    }
}
