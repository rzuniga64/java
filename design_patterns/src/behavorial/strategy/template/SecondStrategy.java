package behavorial.strategy.template;

/**
 *  FirstStrategy class. Concrete Strategy.
 *  Implements the algorithm using the strategy interface.
 */
public class SecondStrategy implements Strategy {

    public void execute() {
        System.out.println("Called SecondStrategy execute.");
    }
}
