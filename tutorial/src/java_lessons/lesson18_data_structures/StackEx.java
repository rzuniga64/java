package java_lessons.lesson18_data_structures;

import java.util.Stack;

/**
 *  The StackEx class. Items stored in a stack is stored as an Object data type
 *  so the data type does not need to be specified.
 *
 *  The Stack class represents a last-in-first-out (LIFO) stack of objects.
 *  It extends class Vector with five operations that allow a vector to be
 *  treated as a stack. The usual push and pop operations are provided, as well
 *  as a method to peek at the top item on the stack, a method to test for
 *  whether the stack is empty, and a method to search the stack for an item
 *  and discover how far it is from the top. When a stack is first created,
 *  it contains no items.
 *
 *  Methods used:
 *  - push(e)
 *  - pop()
 *  - peek()
 *  - empty()
 *  - search()
 */
public final class StackEx {

    /** Constructor. */
    private StackEx() { }

    /**
     * Unit tests for StackEx class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        Stack<String> names = new Stack<>();

        names.push("Raymond");
        names.push("David");

        System.out.println("Top of stack: " + names.peek());
        names.pop();
        System.out.println("Top of stack: " + names.peek());
        names.push("Cynthia");
        System.out.println("Top of stack: " + names.peek());

        if (!names.empty()) {
            names.pop();
        }
        System.out.println("Top of stack: " + names.peek());
        names.pop();

        if (!names.empty()) {
            System.out.println("Top of stack: " + names.peek());
        } else {
            System.out.println("Stack empty.");
        }
    }
}
