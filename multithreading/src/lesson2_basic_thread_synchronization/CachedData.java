package lesson2_basic_thread_synchronization;

import java.util.Scanner;

/*  There are two problems when have more than one thread.
    1. Data being cached
    2. Threads interleaving

    This example will demonstrate the use of the volatile keyword
    and do some basic thread synchronization.

    Have a class run some code in its own thread.
    The problem comes when you want to terminate Processor gracefully
    when it uses shared data.

    On some systems or conditions or versions of Java the Processor
    thread might decide to cache the value of the variable at the start
    so it will never see the changed value of it.  The reason for that
    is there are two threads (the main program which spawns the
    Processor thread).  Both threads are accessing the same variable.
    The Processor thread is reading the variable while the main thread
    is writing the variable.  When Java tries to optimize code it
    doesn't expect other threads to modify its data.  So the Processor
    thread is only reading the variable and is not expecting other threads
    to modify it by using the shutdown method.

    So Java does some optimization and does not check the value of running
    in the while loop.  It will assume the value of 'running' is always
    true.  To prevent a thread from caching the value of a variable use
    the volatile keyword in the declaration of the variable.  Now
    the program is guaranteed to work on any system or version of Java.

*/
class Processor extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class CachedData {
    public static void main(String[] args){
        Processor proc1 = new Processor();
        // start will tell the Thread class to run the code in
        // the run method in its own thread
        proc1.start();

        // need a way to pause until shutdown method is called.
        System.out.println("Press return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();
    }
}
