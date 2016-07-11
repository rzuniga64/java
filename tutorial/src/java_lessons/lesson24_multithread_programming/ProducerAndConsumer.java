package java_lessons.lesson24_multithread_programming;

/**
 *  The type Market.
 *
 *  To make this program work correctly we need to add two methods, wait and notify, so that one thread will know to
 *  wait until another thread is finished and the other thread will have a notify to let the waiting thread know that
 *  it is actually finished. we only need to modify the get and set methods of the Market class.
*/

 class Market {
    private int n;
    private boolean valSet = false;

    /**
     * Get int.
     *
     * @return the int
     */
    synchronized  int get() {
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
     * Set.
     *
     * @param n the n
     */
    synchronized void set(int n) {
        if (valSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        this.n = n;
        valSet = true;
        System.out.println("Set: " + n);
        notify();
    }
}

/**
 * The type Producer.
 */
class Producer implements Runnable {
    private Market m;

    /**
     * Instantiates a new Producer.
     *
     * @param m the m
     */
    Producer(Market m)  {
        this.m = m;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true)
            m.set(i++);
    }
}

/**
 * The type Consumer.
 */
class Consumer implements Runnable {
    private Market m;

    /**
     * Instantiates a new Consumer.
     *
     * @param m the m
     */
    Consumer(Market m) {
        this.m = m;
        new Thread(this,"Consumer").start();
    }

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
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Market m = new Market();
        new Producer(m);
        new Consumer(m);
        System.out.println("Stop by pressing Ctrl-C");
    }
}
