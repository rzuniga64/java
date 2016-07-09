package java_lessons.lesson32_lambda_expressions;

/**
 *   Sometimes you do need to specify the type of the parameters in the lambda expression.  We'll create another
 *   interface and give the Runner class another method.
 */

interface Executable5 {
    int execute(int num);
}

interface StringExecutable5 {
    String execute(String str);
}

interface AnotherExecutable5 {
    int execute(int num1, int num2);
}

class Runner5 {
    public void run(Executable5 e) {
        int value =  e.execute(10);
        System.out.println("Return value is: " + value);
    }

    public void run(StringExecutable5 e) {
        String value =  e.execute("Hello ");
        System.out.println("Return value is: " + value);
    }

    public void run(AnotherExecutable5 e) {
        int  value =  e.execute(1, 2);
        System.out.println("Return value is: " + value);
    }
}

/**
 *  In this case, Java doesn't know which method in the Runner class we intend to call with our lambda expression.
 *  To disambiguate, we need to specify the parameter types in the lambda expression. If one of the Runner methods
 *  happened to take two parameters and the other one, then the ambiguity would go away and again we wouldn't need to
 *  specify parameter types.
 */
public class resolving_parameter_ambiguity {
    public static void main(String[] args) {
        Runner5 runner = new Runner5();
        runner.run( (int a) -> 7 + a);
        runner.run( (String a) -> a + "World!");
        runner.run( (a,b) -> a + b);
    }
}
