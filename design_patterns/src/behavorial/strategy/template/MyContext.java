package behavorial.strategy.template;

/**
 *  MyContext class. Context.
 *  Configured with a ConcreteStrategy object and maintains a reference to a
 *  Strategy object.
 */
public class MyContext {

    private Strategy strategy;

    /** Constructor. */
    public MyContext(final Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy() {
        getStrategy().execute();
    }
}
