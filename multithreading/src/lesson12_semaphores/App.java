package lesson12_semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  A semaphore is an object that maintains a count. We refer to a count as
 *  the number of available permits of the semaphore. You can get the number of
 *  available permits by using the semaphore method called availablePermits().
 *  The method to increase the number of available permits is the semaphore
 *  method called release().The method to decrease the number of available
 *  permits is the semaphore method called acquire(). Acquire will wait if there
 *  are no permits available. You can release from different threads where you
 *  did the acquire. With a thread you have to unlock from the same thread you
 *  locked from. It is used to control access to some resource.
 * {@link java.util.concurrent.Semaphore}s
 * are mainly used to limit the number of simultaneous threads that
 * can access a resources, but you can also use them to implement deadlock
 * recovery systems since a semaphore with one permit is basically a lock that
 * can unlock from other threads.
 * <br>
 * Source:
 * <a href="http://stackoverflow.com/questions/771347/what-is-mutex-and-semaphore-in-java-what-is-the-main-difference">
 * http://stackoverflow.com/questions/771347/what-is-mutex-and-semaphore-in-java-what-is-the-main-difference
 * </a>
 * <p>
 * Mutex (or a semaphore initialized to 1; meaning there's only one resource)
 * is basically a mutual exclusion; Only one thread can acquire the resource
 * at once, and all other threads trying to acquire the resource are blocked
 * until the thread owning the resource releases.
 * <p>
 * Semaphore is used to control the number of threads executing. There will be
 * fixed set of resources. The resource count will gets decremented every time
 * when a thread owns the same. When the semaphore count reaches 0 then no other
 * threads are allowed to acquire the resource. The threads get blocked till
 * other threads owning resource releases.
 * </p>
 * <p>
 * In short, the main difference is how many threads are allowed to acquire the
 * resource at once.
 * TODO -- go a little more in depth explaining that
 * Mutex --its ONE. Semaphore -- its DEFINED_COUNT, ( as many as semaphore
 * count)
 * </p>
 * <br><br>
 */
public final class App {

    /** Constructor. */
    private App() { }

    /**
     * Unit tests.
     * @param args args
     * @throws Exception e
     */
    public static void main(final String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 200; i++) { //200 hundred times will be called
            executor.submit(new Runnable() {
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
