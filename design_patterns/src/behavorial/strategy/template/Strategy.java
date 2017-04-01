package behavorial.strategy.template;

/**
 * Strategy inteface.
 * The classes that implement a concrete strategy should implement this.
 * The context class uses this to call teh concrete strategy.
 */
public interface Strategy {

    void execute();
}
