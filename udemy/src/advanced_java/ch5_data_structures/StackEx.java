package advanced_java.ch5_data_structures;

import java.util.Stack;

// items stored in a stack is stored as an Object data type.
// so the data type does not need to be specified.
public class StackEx {
    public static void main(String[] args) {
        Stack names = new Stack();
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