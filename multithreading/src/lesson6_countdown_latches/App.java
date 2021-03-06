package lesson6_countdown_latches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  There are many classes in Java that are thread-safe. This example will use a
 *  countdown latch.  A countdown latch will count down in seconds from the
 *  number specified as a parameter to the constructor.  It lets one or more
 *  threads wait until the count is zero.  Pass the latch to the Thread class
 *  via the constructor.
*/
class Processor implements Runnable {

    /**
     *  Don't have to use synchronized keyword because CountDownLatch is a
     *  thread-safe class.
     */
    private CountDownLatch latch;

    /**
     * Constructor.
     * @param newLatch latch
     */
    Processor(final CountDownLatch newLatch) {
        this.latch = newLatch;
    }

    // each thread will start and then call countdown after three seconds.
    public void run() {
        System.out.println("Started...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        // each countDown() decrements the latch by one
        latch.countDown();
    }
}

public final class App {

    /** Consturctor. */
    private App() { }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(final String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.submit(new Processor(latch));
        }

        // latch.await() waits until countdown latch has counted down to zero.
        // Each thread calls countdown method after three seconds.
        try {
            latch.await();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("Completed");
    }
}

