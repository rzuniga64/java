package java_lessons.lesson32_lambda_expressions;

/**
 *   In this tutorial we're also looking at defining the code that uses lambda expressions, but most often you just
 *   want to create a button or a thread, and you'll only need to know how to define the lambda expression itself.
 */

interface Executable3 {
    int execute();
}

class Runner3 {
    public void run(Executable3 e) {
        int value =  e.execute();
        System.out.println("Return value is: " + value);
    }
}

/**
 *  With the lambda expression we can just put it in a return value. We don't need to specify the return type anymore,
 *  and in fact there's no way to do that. All we've got to do is just literally return a value. Java knows what the
 *  return type is going to be, because it knows what the corresponding interface looks like.
 *
 *  Now, sometimes all you want to return is either a literal value, or more likely, the results of a method call that
 *  returns a value. If you've just got a single expression, which could even be a literal value, you don't even need
 *  a return statement.
 */
public class return_values_in_lambda_exp {
    public static void main(String[] args) {
        Runner3 runner = new Runner3();
        runner.run( () -> 7);
       // runner.run( () -> {
       //     return 7;
       // });
    }
}
