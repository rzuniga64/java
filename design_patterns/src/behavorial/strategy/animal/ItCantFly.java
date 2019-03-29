package behavorial.strategy.animal;

/**
 *  The type ItCantFly. Class used if the Animal can't fly.
 */
public class ItCantFly implements Flys {

    /**
     *  ItCantFly method.
     *  @return a string.
     */
    public String fly() {
        return "I can't fly";
    }
}
