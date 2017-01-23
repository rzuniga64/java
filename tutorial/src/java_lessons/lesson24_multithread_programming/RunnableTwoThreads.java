/* this program is based on a similar program in
   Java Programming: Advanced Topics, Wigglesworth and McMillan

   Concurrent programming is quite complex. One problem is we
   create object oriented programs where we use inheritance
   there is a problem using the thread class as a superclass.
   Notice ComputeLog and UserInteraction extend the Thread class.
   The problem is if I have a Vehicle class, for example, that in
   turn is derives another class called Car I can't also extend
   that class to include thread.  So what we have to do instead
   is write our classes as implementations of the interface
   called Runnable. The Runnable interface allows us to create
  a derived class that is derived from a base or superclass
   that also can be written in its own thread or written as a
   multi-threaded program.

   Runnable interface gives a way to create classes that can be
   multi-threaded and also be derived from other base classes.
*/
package java_lessons.lesson24_multithread_programming;

import java.io.*;

/**
 * The RunnableThreads class.
 */
public class RunnableTThreads {

    /** Constructor. */
    private RunnableTThreads() { }

    /**
     * The unit tests for RunnableThreads class.
     * @param args the input arguments
     * @throws InterruptedException the interrupted exception
     */
    public static void main(final String[] args) throws InterruptedException {

        Thread firstThread = new Thread(new UserInteraction2());
        firstThread.start();
        ComputeLog2 numProc = new ComputeLog2();
        Thread secondThread = new Thread(numProc);
        secondThread.start();
        // the join method waits for the thread process to terminate once that
        // thread process is terminated we go to the second thread and call
        // end to it.
        firstThread.join();
        // cast thread back to ComputeLog because the end method is part of
        // the ComputeLog class not the thread class.
        numProc.end();
    }
}

/** The UserInteraction2 class. */
class UserInteraction2 implements Runnable {

    /** run method. */
    public void run() {
        try {
            BufferedReader userIn = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.print("Hello, how are you? ");
            String in = userIn.readLine();
            System.out.print("What are you doing today? ");
            in = userIn.readLine();
            System.out.println(in + " sounds like fun.");
        } catch (IOException e) {
            System.out.println("Caught I/O exception.");
        }
    }
}

/**
 * The type ComputeLog2.
 */
class ComputeLog2 implements Runnable {

    /** Is thread stopped. */
    private static boolean stop = false;

    /** run method. */
    public void run() {
        try {
            int i = 1;
            double d = 0;
            while (!stop) {
                d = Math.log(i++);
                Thread.currentThread().sleep(1);
            }
            System.out.println("The log of " + i + " is " + d);
        } catch (InterruptedException e) {
            System.out.println("Thread execution was interrupted.");
        }
    }

    /** end method. */
    void end() {
        stop = true;
    }
}
