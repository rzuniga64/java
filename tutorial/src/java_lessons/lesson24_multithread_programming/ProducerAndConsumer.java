package java_lessons.lesson24_multithread_programming;

// to make this program work correctly we need to add two methods,
// wait and notify, so that one thread will know to wait until
// another thread is finished and the other thread will have a
// notify to let the waiting thread know that it is actually finished.
// we only need to modify the get and set methods of the Market class.
class Market {
    private int n;
    private boolean valSet = false;

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

class Producer implements Runnable {
    private Market m;

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

class Consumer implements Runnable {
    private Market m;

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

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Market m = new Market();
        new Producer(m);
        new Consumer(m);
        System.out.println("Stop by pressing Ctrl-C");
    }
}
