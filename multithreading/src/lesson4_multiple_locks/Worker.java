package lesson4_multiple_locks;

import java.util.*;

    /*  There are two problems when have more than one thread.
        1. Data being cached
        2. Threads interleaving

        This example will use multiple locks and synchronized code blocks
        to prevent thread interleaving to allow to allow two independent
        Worker threads to run at the same time.

        The synchronized method allows a thread to get the intrinsic lock
        of the Worker object and another thread cannot get it until the
        first thread releases it. But there is only one intrinsic lock
        for the Worker object.  So if one thread is running one method,
        stageOne, then another thread will have to wait to run another
        method, stageTwo.  But these methods are independent since they
        don't write to the same data.

        The solution is to create two explicit locks and synchronize on
        the two locks separately. Then instead of using synchronized methods
        we will use synchronized code blocks.  Synchronized code blocks work
        similarly to synchronized methods except now multiple threads can run the
        same method at the same time. But if one thread enters the synchronized
        code block the other threads will have to wait until the first thread
        has released the lock passed in and exits the code block so that it
        can run the synchronized code block.  Since we are using two different locks
        one thread can run StageOne while another thread can run StageTwo at the
        same time.
    */
public class Worker {
    private Random random = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    // shared data that can be accessed from multiple threads
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        System.out.println("Starting...");
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                process();
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

        long stop = System.currentTimeMillis();
        long duration = stop - start;

        System.out.println("Time take: " + duration + " milliseconds");
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());

    }
}
