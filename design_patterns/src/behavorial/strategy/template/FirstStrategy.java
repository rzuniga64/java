package behavorial.strategy.template;

/**
 * FirstStrategy class. Concrete Strategy.
 * Implements the algorithm using the Strategy interface.
 */
public class FirstStrategy implements Strategy {

    public void execute() {
        System.out.println("Called FirstStrategy execute.");
    }
}
