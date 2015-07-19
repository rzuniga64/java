package java_lessons.lesson33_lambda_expressions;

/**
 *  What if you want to use variables from your calling method
 *  in the block of code that you want to pass to a method?
 *  In JDK6, if you use a local variable in an anonymous class,
 *  you had to declare it final, but in JDK8, the “final” is no
 *  longer necessary -- provided we assign our local variable a
 *  value when we declare it and then don't change that value.
 */

interface Executable6 {
    int execute(int a, int numb);
}

class Runner6 {
    public void run(Executable6 e) {
        int value =  e.execute(3,4);
        System.out.println("Return value is: " + value);
    }
}

public class lambda_exp_and_scope {
    public static void main(String[] args) {

        /**
         *  Unlike the anonymous class method, the lambda expression inherits
         *  the scope of the enclosing method. Look at what happens if we define
         *  a local variable in our main method and define the same variable in
         *  our anonymous class method.
         */
        int c = 9;
        // Mustn't do this: c = 8;
        int d = 11; // define in anonymous class method

        /**
         *  Can use c in our anonymous class methods and lambda expressions
         *  as long as we don't change its value after assigning.
         *  We say it's "effectively final". In JDK 8, we're allowed to use
         *  effectively final variables in methods of anonymous classes,
         *  and we can also use them in lambda expressions. So we can happily
         *  use local variables within our lambda expression as long as they
         *  are effectively final, or for that matter actually final.
         */
        Runner6 runner = new Runner6();

        // Anonymous class
        runner.run(new Executable6() {
            public int execute(int a, int b) {
                /**
                 * Here, the second "d" is new variable that shadows the "d"
                 * declared earlier in the main method. The variable defined
                 * in the main method is no longer accessible in the anonymous
                 * class method -- at least not directly.
                 */

                int d = 24; // This is a completely new "d"!
                return a + b + c;
            }
        });

        // Lambda expression
        runner.run( (a, b) -> {
            /**
             * We get a compilation error now. The error is “variable 'd' is
             * already defined in the scope”. The lambda expression inherits the
             * calling method's scope, and we can't declare a variable that's
             * already defined in the calling method.
             * */
            // int d = 6;  // SYNTAX ERROR!
            return a + b + c;
        });

    }
}
