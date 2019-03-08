package stack;

import stack.StackArray;

import java.util.Scanner;

/**
 *  Input an arithmetic expression such as ( 1 + 1 ) /
 *  ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) /
 */
public class ArithmeticExpressionEvaluation {

    public static void main(String[] args) {

        String s;
        StackArray<String> operations = new StackArray<>();
        StackArray<Double> values = new StackArray<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("input an arithmetic expression");

        while ( !(s = scan.next()).equals("/")) {

            if      (s.equals("("));
            else if (s.equals("+")) operations.push(s);
            else if (s.equals("*")) operations.push(s);
            else if (s.equals(")")) {

                String op = operations.pop();
                if      (op.equals("+")) values.push(values.pop() + values.pop());
                else if (op.equals("*")) values.push(values.pop() + values.pop());
            }
            else values.push(Double.parseDouble(s));
        }
        System.out.println(values.pop());
    }
}
