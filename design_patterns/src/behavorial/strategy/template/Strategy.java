package behavorial.strategy.template;

/**
 * Strategy interface. Strategy.
 * The classes that implement a concrete strategy should implement this.
 * The context class uses this to call teh concrete strategy.
 */
public interface Strategy {

    /** the method that does the work. */
    void execute();
}
