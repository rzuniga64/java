package lesson7_producer_consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    /*  ArrayBlockingQueue is a data structure that can hold data items
        as in ArrayList.  Items can be added/removed from the queue. It
        is First In/First Out (FIFO).  The classes in the concurrent
        package are threadsafe so you can use multiple threads without
        having to worry about thread synchronization.
     */
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    /*  Producers are one or more threads that are producing things
        and those threads are things to a common data share such as
        our queue. Other threads remove things from this queue and
        process it.  Random numbers are going to be added to the queue
        for this example to simulate some processing.  Real world
        processing might include getting text messages form a text
        message server and putting them into the queue.  Another
        thread will take texts messages off of the queue and send them
        to their destination.
     */
    private static void producer() throws InterruptedException {
        Random random = new Random();

        while(true) {
            try {
                // add a number in the range 0-99
                queue.put(random.nextInt(100));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();
        Integer value = -1;

        while(true) {
            try {
                Thread.sleep(100);
                if(random.nextInt(10) == 0)
                    value = queue.take();
                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public static void main(String [] args) {
        // producer thread
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    producer();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });

        // consumer thread
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
