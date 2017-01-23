package java_lessons.lesson24_multithread_programming;

/**
 *  The type Market.
 *
 *  The synchronized keyword that when applied to a method acquires a lock to
 *  run. That means only one thread can have access to it.
 *
 *  To make this program work correctly we need to add two methods, wait and
 *  notify, so that one thread will know to wait until another thread is
 *  finished and the other thread will have a notify to let the waiting
 *  thread know that it is actually finished. we only need to modify the get
 *  and set methods of the Market class.
*/
 class Market {

    /** An integer. */
    private int n;
    /** Has a value been produced? */
    private boolean valSet = false;

    /** Constructor. */
    protected Market() { }

    /**
     * Get the value.
     * @return the int
     */
    synchronized int get() {
        if (!valSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        System.out.println("Got: " + n);
        valSet = false;
        notify();
        return n;
    }

    /**
     * Set the value.
     * @param newN the value
     */
    synchronized void set(final int newN) {

        if (valSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        n = newN;
        valSet = true;
        System.out.println("Set: " + n);
        notify();
    }
}

/**
 * The type Producer.
 */
class Producer implements Runnable {

    /** Market object.*/
    private Market m;

    /**
     * Instantiates a new Producer.
     * @param newM the market
     */
    Producer(final Market newM)  {
        this.m = newM;
        new Thread(this, "Producer").start();
    }

    /** The run method. */
    public void run() {
        int i = 0;
        while (true) {
            m.set(i++);
        }
    }
}

/**
 * The type Consumer.
 */
class Consumer implements Runnable {

    /** Market object. */
    private Market m;

    /**
     * Instantiates a new Consumer.
     * @param newM the market
     */
    Consumer(final Market newM) {
        this.m = newM;
        new Thread(this, "Consumer").start();
    }

    /** run method. */
    public void run() {
        while (true) {
            m.get();
        }
    }
}

/**
 * The type ProducerAndConsumer.
 */
public class ProducerAndConsumer {

    /** Constructor. */
    private ProducerAndConsumer() { }
    /**
     * The unit tests for ProducerAndConsumer class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        Market m = new Market();
        new Producer(m);
        new Consumer(m);
        System.out.println("Stop by pressing Ctrl-C");
    }
}
