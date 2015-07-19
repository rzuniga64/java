package java_lessons.lesson32_lambda_expressions;

/**
 *  Lambda expressions purely a new alternative to methods of anonymous classes.
 *  Lambda expressions work a bit differently under the hood, but from the
 *  programmer’s point of view, it is just a new way of doing the same thing
 *  that we did before with anonymous classes, but they're a bit shorter and a
 *  lot simpler. You have to keep in mind that you are passing a block of code,
 *  and that block of code may have parameters and it may have a return value.
 *
 *  People are saying they open the door to functional programming
 *  where you’re passing around functions just like variables.
 *  The lambda expression is actually, in fact, an object.
 *  We still don’t have a more succinct way of specifying that a
 *  method expects a block of code; we’ve still got to work with
 *  interfaces, so they do not really represent a radical overhaul, yet.
 *
 *  What is nice is that if you’re passing some code to a button or a
 *  thread or something, you can do it without typing out a lot of
 *  unnecessary stuff.
 */

interface Executable7 {
    int execute(int num1, int num2);
}

class Runner7 {
    public void run(Executable7 e) {
        int value =  e.execute(3,4);
        System.out.println("Return value is: " + value);
    }
}

/**
 *  We can store the lambda expression in a variable of the interface type
 *  if we want.
 *
 */
public class lambda_exp_are_objects {
    public static void main(String[] args) {
        Runner7 runner = new Runner7();
        Executable7 ex = (a,b) -> {
           return a + b;
        };
        runner.run(ex);
    }
}
