package lesson13_callable_and_future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * {@link java.util.concurrent.Callable} and
 * {@link java.util.concurrent.Future}
 * in Java to get results from your threads and to allow
 * your threads to throw exceptions. Plus, Future allows you to control your
 * threads, checking to see if they’re running or not, waiting for results and
 * even interrupting them or de-scheduling them.
 * <p>
 * {@link java.lang.Runnable}
 * is the default abstraction for creating a task in Java.
 * It has a single method {@link Runnable#run()}
 * that accepts no arguments and returns no value, nor can it throw
 * any checked exception. To overcome these limitations, Java 5 introduced a new
 * task abstraction through {@link java.util.concurrent.Callable} interface.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        //anonymous call of Callable
        Future<Integer> future = executor.submit(new Callable<Integer>() {

            //return value is Integer
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);
                if (duration > 2000) {
                    throw new TimeoutException ("Sleeping for too long.");
                }

                System.out.println("Starting ...");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException ignored) {}
                System.out.println("Finished.");
                return duration;
            }
        });

        executor.shutdown();
        // use when submitting multiple threads
        // executor.awaitTermination(1, TimeUnit.DAYS);

         /**
            get returned value from call() using future.get(). get() will block
            until the thread associated with this future has terminated.
            If an exception is thrown from call() the exception will be thrown
            from get(). Get() won't throw TimeoutException but it will throw
            an ExecutionException.  The call from the ExecutionException will
            be the TimeoutException.
          */
        try {
            System.out.println("Result is: " + future.get());

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (ExecutionException e) {
            //TimeoutException ex = (TimeoutException) e.getCause();
            System.out.println(e.getMessage());
        }
    }
}
