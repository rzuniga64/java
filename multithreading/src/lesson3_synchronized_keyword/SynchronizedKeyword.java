package lesson3_synchronized_keyword;

    /**
     *  There are two problems when have more than one thread.
     *  1. Data being cached
     *  2. Threads interleaving
     *
     *  This example will demonstrate the use of the synchronized keyword
     *  to prevent thread interleaving.  Every object in Java has an intrinsic
     *  lock (mutex). If a synchronized method of an object is called you
     *  have to acquire the intrinsic lock before you can call it.  Only one
     *  thread can acquire the intrinsic lock at a time. When one thread
     *  acquires the intrinsic lock and runs a synchronized method and then
     *  if another thread tries to call the method at the same time the second
     *  thread will have to wait until the first thread releases the intrinsic
     *  lock by the method finishing its execution. Only one thread at a time
     *  can acquire an intrinsic lock.
    */

public class SynchronizedKeyword {
    /**
     * Doesn't need to be declared volatile because if you run code in a
     * synchronized block then it is guaranteed that the current state
     * of the shared variables will be visible to all threads.
     */
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        SynchronizedKeyword sk = new SynchronizedKeyword();
        sk.doWork();
    }

    /**
     * When count is incremented it likes an atomic operation which happens in
     * one step but it isn't.  It sort of equivalent to: count = count + 1;

        There are three steps here which takes considerable
        time between each step in computer terms.
        1. Get the value of count
        2. Increment the value of count by one
        3. Store it back in count

        Each thread could be incrementing different values of count
        or one thread could have incremented more than once before the
        second thread increments its value.
    */
    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++)
                    //count ++;
                    increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++)
                    //count ++;
                    increment();
            }
        });

        //  Start always returns immediately because it spawns a thread
        t1.start();
        t2.start();

        /**
         *  Both threads are accessing the variable count. We are accessing the
         *  value of count before the loops can get started. We need to wait for
         *  both thread to finish executing before we display the value of count.
         *  To wait for the threads to finish we can use the join method.
         */
        try {
            t1.join();  // pauses execution of thread its called in
            t2.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("count is: " + count);
    }
}
