package lesson1_starting_threads;
/*
    A thread is kind of like a separate operating system process
    which can run concurrently with other threads.

    Two ways to start a thread in java.
    1. Extend the Thread class
    2. Implement Runnable and pass it to the constructor of the Thread class
 */

class Runner1 extends Thread {
    // Runner has a method called 'run' that we want to override
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println("Hello " + i);
        try {
            Thread.sleep(100);      // pause thread from specified number of milliseconds.
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

public class ExtendThreadClass {
    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        // tell the thread class to look for the run method
        // and to run that in its own special thread
        runner1.start();

        Runner1 runner2 = new Runner1();
        runner2.start();


    }
}
