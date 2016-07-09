package java_lessons.lesson32_lambda_expressions;

/**
 *  We want to pass a block of code to the run method. We might want to pass some code to a thread to execute it in its
 *  own thread or you want to pass some code to a button in Swing to be executed when the button is clicked.
 *  Do this by defining an interface, Executable1, for example, and give it a method (execute), and this method would be
 *  the place where we put the code we want to run.
 */
interface Executable1 {
    void execute();
}

/**
 *  We can make a class accept an object that implements the Executable1 interface. Make the class call the execute
 *  method of whatever object implements Executable1.
 */
class Runner1 {
    public void run(Executable1 e) {
        System.out.println("Executing code block ...");
        e.execute();
    }
}

/**
 *  To use this we need an instance of the Runner1 class. In previous versions of Java, to actually pass some block of
 *  code we've got to somehow have an object that implements this interface, and we can do that using an anonymous class
 *  syntax. the point  is to pass in some code to the run method.  Then the run method can do what it likes with it, and
 *  in this case it's just executing the code that we passed it in the execute method.  This is a lot of code just to
 *  pass a code block.  How can we do this with lambda expressions in Java8?
 */
public class anonymous_class {
    public static void main(String[] args) {
        Runner1 runner = new Runner1();
        runner.run(new Executable1() {
            public void execute() {
                System.out.println("Hello There!");
            }
        });
    }
}
