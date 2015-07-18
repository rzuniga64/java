package lesson14_interrupting_threads;

import java.util.Random;

public class App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting.");
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                Random ran = new Random();

                for (int i = 0; i < 1E8; i++) {
                    /* if(Thread.currentThread().isInterrupted() {
                        System.out.println("Interrupted!");
                        break;
                      } */
                    try {
                        // Thread.sleep throws an InterruptedException.
                        // After half a second Thread.sleep(1) will detect
                        // t1.interrupt() and will throw an Interrupted Exception
                        // which is caught and a break is executed.
                        Thread.sleep(1);
                    } catch (InterruptedException ie) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    Math.sin(ran.nextDouble());
                }
            }
        });
        t1.start();

        // give thread plenty of time to start running
        Thread.sleep(500);

        // t1.interrupt() doesn't actually stop the thread.
        // It sets a flag that tells that its been interrupted.
        t1.interrupt();

        t1.join();
        System.out.println("Finished");
    }
}
