package java_lessons.lesson33_lambda_expressions;

/**
 *   Another thing that you often want to do is to allow the the
 *   block of code that you want to pass, to accept some parameters.
 *   Remember, we don’t want to pass in literal values with our block
 *   of code. We’ll be passing a block of code, and the method that
 *   you pass it to would then supply the parameters to the block of
 *   code, if there are any.
 */

interface Executable4 {
    int execute(int num1, int num2);
}

class Runner4 {
    public void run(Executable4 e) {
        int value =  e.execute(3,4);
        System.out.println("Return value is: " + value);
    }
}

/**
 *  The actual method that you pass that block of code to
 *  is going to have to supply a value for that parameter.
 */
public class lambda_expr_parameters {
    public static void main(String[] args) {
        Runner4 runner = new Runner4();
        runner.run( (a,b) -> a + b);
        //runner.run( a, b) -> {
        //    return a + b;
        //});
    }
}