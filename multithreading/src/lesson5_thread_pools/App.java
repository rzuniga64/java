package lesson5_thread_pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

    private int id;

    Processor(final int newId) {
        this.id = newId;
    }

    /** run method. */
    public void run() {
        System.out.println("Starting: " + id);
        try {
            // Simulate some processing.
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("Completed: " + id);
    }
}

public final  class App {

    /** Constructor. */
    private App() { }

    /**
     *  Main method.
     *  @param args args
     *  A thread pool is like having a number of workers in a creational.factory
     *  which have tasks to complete. There is a lot of overhead in
     *  starting threads so its more efficient to recycle threads using a thread
     *  pool
     */
    public static void main(final String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks to executor. ExecutorService will run its own
        // managerial thread that will handle parsing out the tasks.
        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }

        /**
         *  Tell the managerial thread to stop accepting new tasks and to shut
         *  itself down when all the tasks have finished. It will not shutdown
         *  until all threads have completed their tasks.
         */
        executor.shutdown();
        System.out.println("All tasks submitted");

        // wait for all tasks to finish
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("All tasks completed.");
    }
}
