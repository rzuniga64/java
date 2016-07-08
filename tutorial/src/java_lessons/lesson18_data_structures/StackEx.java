package java_lessons.lesson18_data_structures;

import java.util.Stack;

/**
 * The type Stack ex. Items stored in a stack is stored as an Object data type so the data type does not need to be
 * specified.
 * Methods used:
 * - push(e)
 * - pop()
 * - empty()
 *
 */
public class StackEx {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Stack<String> names = new Stack<>();

        names.push("Raymond");
        names.push("David");

        System.out.println("Top of stack: " + names.peek());
        names.pop();
        System.out.println("Top of stack: " + names.peek());
        names.push("Cynthia");
        System.out.println("Top of stack: " + names.peek());

        if (!names.empty())
            names.pop();

        System.out.println("Top of stack: " + names.peek());
        names.pop();

        if (!names.empty())
            System.out.println("Top of stack: " + names.peek());
        else
            System.out.println("Stack empty.");
    }
}
