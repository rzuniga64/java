package lesson10_reentrant_locks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Source:
 * http://www.journaldev.com/2377/java-lock-example-and-concurrency-lock-vs-synchronized
 * <p>
 * {@link java.util.concurrent.locks.Lock}:
 * This is the base interface for Lock API. It provides all the features
 * of synchronized keyword with additional ways to create different Conditions
 * for locking, providing timeout for thread to wait for lock. Some of the
 * important methods are
 * {@link java.util.concurrent.locks.Lock#lock()} to acquire the lock,
 * {@link java.util.concurrent.locks.Lock#unlock()} to release the lock,
 * {@link java.util.concurrent.locks.Lock#tryLock()} to wait for lock for a
 * period of time,
 * {@link java.util.concurrent.locks.Lock#newCondition()} to create the
 * Condition etc.
 * <p>
 * {@link java.util.concurrent.locks.ReentrantLock}:
 * This is the most widely used implementation class of Lock interface.
 * This class implements the Lock interface in similar way as synchronized
 * keyword.
 * (see App.java for more)
 * <p>
 * {@link java.util.concurrent.locks.Condition}:
 * Condition objects are similar to Object wait-notify model with additional
 * feature
 * to create different sets of wait. A Condition object is always created by
 * Lock object.
 * Some of the important methods are
 * {@link java.util.concurrent.locks.Condition#await()} similar to
 * {@link Object#wait()}.
 * {@link java.util.concurrent.locks.Condition#signal()} and
 * {@link java.util.concurrent.locks.Condition#signalAll()}
 * that are similar to {@link Object#notify()} and {@link Object#notifyAll()}
 * methods.
 */
public class Runner {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    /** get the condition of the lock you are locking on. */
    private Condition cond = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("Waiting ....");
        // Do the same thing as wait in a synchronized block.
        // Unlock the lock so another thread can get the lock and lock it
        cond.await();
        System.out.println("Woken up!");
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {

        Thread.sleep(1000);
        lock.lock();
        System.out.println("Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key!");
        // signal() is like notify(). This will wake up firstThread.
        cond.signal();
        try {
            increment();
        } finally {
            // must unlock the lock whenever signal() is called
            // so other threads can reacquire the lock.
            lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }
}
