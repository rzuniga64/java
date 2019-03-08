package stack;

import stack.StackArray;

import java.util.Scanner;

/**
 *  Dijkstgra's two stack algorithm.
 *  Value: push onto the value stack.
 *  Operator: push onto the operator stack.
 *  Left parenthesis: ignore.
 *  Right paranthesis: pop operator and two values; push the result of the applying that operator to those values onto
 *  the operand stack.
 *
 *  value   operand
 *  stack   stack
 *  20
 *  5         *
 *  1         +
 *
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
