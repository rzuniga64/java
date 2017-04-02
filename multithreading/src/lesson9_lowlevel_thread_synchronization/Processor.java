package lesson9_lowlevel_thread_synchronization;

import java.util.LinkedList;
import java.util.Random;

/**
 * It's better to use a pre-built class like ArrayBlockingQueue and not go
 * low-level. Then you can be pretty sure that even multiple consumers and
 * multiple producers will work just fine.
 */
@SuppressWarnings("InfiniteLoopStatement")
public class Processor {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int limit = 10;

    // used to call wait and notify on the object you are locking on
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        Random random = new Random();
        while (true) {
            synchronized (lock) {
                //whenever the thread is notified starts again from the loop
                while (list.size() == limit) {
                    lock.wait(); // wait() is also true
                }
                list.add(value);

                System.out.println("Producer added:   " + value
                        + " queue size is: " + list.size());
                value++;
                lock.notify();
                //force producer fill the queue to LIMIT_SIZE
                Thread.sleep(random.nextInt(1000));
            }
        }
    }

    /**
     * The consume method can acquire the lock whenever the produce method calls
     * notify() on the lock. This happens each time a value is added to the list
     * - regardless of whether or not list.size() LIMIT has been reached. In
     * "startup mode" - i.e. while the list is initially being filled - the lock
     * is up for grabs by either thread, so the first reported size will not
     * always be the same.
     * @throws InterruptedException ie
     */
    public void consume() throws InterruptedException {
        Random random = new Random();
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }
                int value = list.removeFirst();
                System.out.print("Consumer removed: " + value);
                System.out.println(" queue size is: " + list.size());
                lock.notify();
            }
            //force producer fill the queue to LIMIT_SIZE
            //Thread.sleep(random.nextInt(100));
        }
    }
}
