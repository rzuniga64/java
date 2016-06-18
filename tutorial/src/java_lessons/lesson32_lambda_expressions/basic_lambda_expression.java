package java_lessons.lesson32_lambda_expressions;

/** FUNCTIONAL INTERFACE:
 *  We want to pass a block of code to the run method.
 *  We might want to pass some code to a thread to execute it
 *  in its own thread or you want to pass some code to a button
 *  in Swing to be executed when the button is clicked.
 *  Do this by defining an interface, Executable1, for example,
 *  and give it a method (execute), and this method would be
 *  the place where we put the code we want to run.
 */
interface Executable2 {
    void execute();
}

/**
 *  We can make a class accept an object that implements
 *  the Executable1 interface. Make the class call the
 *  execute method of whatever object implements Executable1.
 */
class Runner2 {
    public void run(Executable2 e) {
        e.execute();
    }
}

/**
 *  Use a lambda expression to pass a block of code
 *  that the run() method is going to execute. The
 *  lambda expression by itself is just a away of
 *  passing code to our Runner2 object. It just so
 *  happens in this case, the run() method we defined,
 *  happens to execute that code, but it can do whatever
 *  it likes with it. Lambda expressions are associated
 *  with interfaces that have a single method.
 */
public class basic_lambda_expression {
    public static void main(String[] args) {
        Runner2 runner = new Runner2();
        runner.run(() -> System.out.println("Hello there."));
    }
}
