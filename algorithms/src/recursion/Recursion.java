package recursion;

import data_structure.linkedlist.LinkedList;

/**
 * WHY USE RECURSION?
 *
 *  It is true that recursion is never required to solve a problem
 *  Any problem that can be solved with recursion cab also be solved using iteration.
 *  Recursion requires extra overhead: function call + return mechanism uses extra resources
 *  However some repetitive problems are more easily and naturally solved with recursion
 *  Iterative solution may be unreadable to humans
 *
 *  Recursion is the primary method of performing repetition in most functional languages.
 *
 *  Once programmers adapt to solving problems using recursion, the code produced is generally shorter, more elegant,
 *  easier to read and debug.
 *
 *  HOW TO WRITE RECURSIVE FUNCTIONS
 *  Branching is required!! (If or switch)
 *  Find a base case
 *  - one (or more) values for which the result of the function is known (no repetition required to solve it)
 *  Develop the recursive case
 *  - For a given argument (say n), assume the function works for a smaller value (n-1).
 *  - Use the result of calling the function on n-1 to form a solution for n
 *
 *  Many recursive functions (over integers) look
 *  like this:
 *  type f(int n) {
 *	    if (n==0)
 *		    // do the base case
 *	    else
 *		    // ... f(n-1) ...
 *      ! Note these functions are undefined for n < 0.
 */

public class Recursion {

    public static void main(String[] args) {

        Recursion recursionTool = new Recursion();

        // Fibonacci
        System.out.println( "The first 13 fibonacci nubers: ");
        for (int i = 0; i < 13; i++)
            System.out.println( fib(i) + " ");
        System.out.println();

        // Factorial of a number
        int number = 10;
        System.out.println("The factorial of " + number + " is " + factorial(number));

        // Greatest Common Divisor(GCD) of a number
        System.out.println("\nGCD(9.1): " + gcd(9,1));
        System.out.println("GCD(9.1): " + gcd(1,9) + "\n");
        System.out.println("GCD(9.1): " + gcd(9,2) + "\n");
        System.out.println("GCD(9.1): " + gcd(70,25) + "\n");
        System.out.println("GCD(9.1): " + gcd(25,70) + "\n");

        // Table of squares
        tableOfSquares(10);

        // Power of a number
        System.out.println("\n" + 2 + " to the power of " + 2 + " is " + power(2,2));
        System.out.println(3 + " to the power of " + 3 + " is " + power(3,3));

        // recursion over a list
        int[] list = { 1, 2, 3, 4, 5, 6, 7, 9, 10, 11 };
        System.out.println("\nIs " + number + " a member of array? " + isMember(list, 9, 11));

        // Maximum value of a linked list
        LinkedList theLinkedList = new LinkedList();
        theLinkedList.insert(12.0);
        theLinkedList.insert(24.0);
        theLinkedList.insert(100.0);
        theLinkedList.insert(90.0);

        LinkedList.Link link = theLinkedList.getFirstLink();
        System.out.println("\nThe max value of the list is " + maxValue(link, 1.00));

        // Recursive binary search
        System.out.println("\nThe index of " + number + " is " + binarySearchRecursive(list, 0, 9, number));
    }

    /**
    *   Fibonacci numbers
    *   Series of Fibonacci numbers : 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
    *   Starts with 0, 1. Then each number is the sum
    *   of the two previous numbers
    *   F0 = 0
    *   F1 = 1
    *   Fi = Fi-1 + Fi-2 (for i > 1)
    *   It�s a recursive definition
    */

    private static int fib(int x) {
        if (x <= 1)
            return x;
        else
            return fib(x - 1) + fib(x - 2);
    }

    /**
     * Recursive function example
     * Mathematical definition of n! (factorial of n)
     * if n=0 then n! = 1
     * if n>0 then n! = 1 x 2 x 3 x ... x (n-1) x n
     *
     * base case: n=0 (result is 1)
     * recursive case:
     * If we assume (n-1)! can be computed, how can we get n! from that?
     * n! = n * (n-1)!
     */

    private static int factorial( int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n-1);
    }

    /**
     * greatest common divisor
     * Greatest common divisor of two non-zero ints is the largest positive integer
     * that divides the numbers without a remainder.
     *
     * If x < y then x % y is x (so gcd(x,y) = gcd(y,x)
     *
     * This is a variant of Euclidean algorithm:
     *      gcd(x,y) = y if y divides x evenly, otherwise:
     *      gcd(x,y) = gcd(y,remainder of x/y) //gcd(y,x%y) in c++
     *
     *  It is a recursive mathematical definition.
     *  If x < y, then x%y is x (so gcd(x,y) = gcd(y,x))
     *  This moves the larger number to the first position.
     */

    private static int gcd(int x, int y) {
        System.out.println("gcd called with " + x + " and " + y);
        if (x % y == 0)
            return y;
        else {
            return gcd(y, x % y);
        }
    }

    /**
     * Table of squares
     * Precondiction: none
     * Postcondition: return a table of squares from 1 to n
     */

    private static void tableOfSquares(int number){
        if (number > 0) {
            tableOfSquares(number - 1);
            System.out.printf( "%2d %3d \n", number, number*number);
        }
    }

    /**
     * Power of a number
     * Preconditions: takes two arguments, the number raised to the power and the power
     * PostConditions: returns a number raised to a power using recursion
     */

    private static double power(double num, int pow) {
        if (pow == 0)
            return 1;
        else
            return num * power(num, pow - 1);
    }

    /**
     *  Member of an aray
     *  Preconditions: the function takes three arguments: an array of ints, its size and a target value.
     *  Postconditions: returns true if the target value is found in the array, or false if the value is not in the array
     */

    private static boolean isMember(int array[], int size, int value) {
        return (array[size] == value || isMember(array, size-1, value));
    }

    /**
     * Maximum value of an array
     * Precondition: The function takes two argument: a Link, and the value to compare against.
     * PostCondition: returns the maximum value in a linked list
     */

    private static Double maxValue(LinkedList.Link Link, Double maxValue) {
        if (Link == null)
            return maxValue;
        if ( (Double)Link.getValue() > maxValue)
            return maxValue(Link.getNext(), (Double) Link.getValue());
        else
            return maxValue(Link.getNext(), maxValue);

    }

    /**
     * Recursive binary search
     * Runtime Analysis: O log(N)
     *
     * Find an item in a list, return the index or -1.
     * Base case: if search is narrowed down to 0 elements, return -1. Divide an conquer algorithm.
     * - if empty list return -1
     * Recursive case
     * - if equal, then return index
     * - if less than middle value, search in first half
     * - if more than middle value, search in last half
     *
     * Need to add parameters for first and last index of the current subpart of the list to search.
     *
     * @param array
     * @param first
     * @param last
     * @param value
     * @return
     *
     *  Precondition: The list must be sorted.
     *  PostCondition: the index of the item in the list or -1 if not found
     */
    private static int binarySearchRecursive(int array[], int first, int last, int value) {
        // base case: check for empty list
        if (first > last)
            return -1;
        // computer middle index
        int middle = (first + last)/2;
        if (array[middle] == value)
            return middle;
        if (value < array[middle])
            return binarySearchRecursive(array, middle-1, last, value);
        else
            return binarySearchRecursive(array, middle+1, last, value);
    }

    int binarySeaarch(int array[], int size, int value) {
        return binarySearchRecursive(array, 0, size-1, value);
    }
}
