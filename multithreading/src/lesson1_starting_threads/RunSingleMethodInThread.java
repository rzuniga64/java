package lesson1_starting_threads;

/**
 * Sometimes you just want to run one method inside of a thread. It can be done
 * using an anonymous class.
 */
public class RunSingleMethodInThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++)
                    System.out.println("Hello " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });
        t1.start();
    }
}