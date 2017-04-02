package lesson8_wait_and_notify;

/**
 * {@link Object#wait()} and {@link Object#notify()} in Java; low-level
 * multi-threading methods of the {@link java.lang.Object} class
 * that allow you to have one or more threads sleeping, only to be woken up by
 * other threads at the right moment. Extremely useful for avoiding those
 * processor-consuming "polling loops".
 */
public final class App {

    /** Constructor. */
    private App() { }

    /**
     * Unit tests.
     * @param args args
     * @throws InterruptedException ie
     */
    public static void main(final String[] args) throws InterruptedException {

        final Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException ignored) { }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException ignored) { }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
