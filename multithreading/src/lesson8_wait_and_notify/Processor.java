package lesson8_wait_and_notify;

import java.util.Scanner;

/**
 * Some background knowledge<br>
 * Source: <em>http://www.programcreek.com/2009/02/notify-and-wait-example/</em>
 * <br><br>
 * {@code synchronized} keyword is used for exclusive accessing. To make a
 * method {@code synchronized}, simply add the {@code synchronized} keyword to
 * its declaration.<be>
 * Then no two invocations of synchronized methods on the same object can
 * interleave with each other.
 * <br>
 * Synchronized statements must specify the object that
 * provides the intrinsic lock. When {@code synchronized(this)} is used, you
 * have to avoid to synchronizing invocations of other objects' methods.
 * <br>
 * {@link Object#wait()} tells
 * the calling thread to give up the lock and go to sleep (not polling) until
 * some other thread enters the same lock and calls {@link Object#notify()}.
 * <br>
 * {@link Object#notify()} wakes up the first thread that called wait() on
 * the same object.
 */
public class Processor {

    /**
     * produce method.
     * @throws InterruptedException ie
     */
    public void produce() throws InterruptedException {

        /**
         * Need a mutex (object)to synchronize on so we'll use the Processor
         * object itself. This will use the intrinsic lock so the synchronized
         * code block can't run until it's acquired the intrinsic lock of the
         * processor object
        */
        synchronized (this) {
            System.out.println("Producer thread running....");
            /**
             * Every object in Java has a wait method which is a method of
             * the Object class.  It waits without using loads of system
             * resources. It can only be called within synchronized code blocks.
             * It hands over the control of the lock that the synchronized block
             * is locked on. This thread will not resume until two things
             * happen. First, it must be possible for this thread to regain
             * control of this lock in order for it to resume.  Second, I must
             * run another thread that is locked on the same object that calls
             * a method called notify().
             */
            wait();  // relinquishes the lock but can reacquire it.
            System.out.println("Resumed.");
        }
    }

    /**
     * Very important! This thread must use the same lock as the produce thread
     * in the synchronized block.  So if produce is running it waits for it to
     * finish and then acquire the lock.
     * @throws InterruptedException ie
     */
    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread .sleep(2000);

        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed");
            /** notify method can only be used within a synchronized code block.
             * It will notify the first other thread to lock onto the same
             * lock object.  It does relinquish control of the lock.  When the
             * synchronized block is finished then it relinquishes the lock.
             */
            notify();
        }
    }
}

