package recursion;


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

    static int fib(int x) {
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

    static int factorial( int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n-1);
    }

    /**
     * Recursive function example
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

    static int gcd(int x, int y) {
        System.out.println("gcd called with " + x + " and " + y);
        if (x % y == 0)
            return y;
        else {
            return gcd(y, x % y);
        }
    }
}
