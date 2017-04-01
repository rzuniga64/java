package behavorial.strategy.animal;

/**
 * The TestStrategy class.
 */
public class TestStrategy {

    /**
     * Main.
     * @param args the args
     */
    public static void main(final String[] args){

        Animal sparky = new Dog();
        Animal tweety = new Bird();

        System.out.println("Dog: " + sparky.tryToFly());
        System.out.println("Bird: " + tweety.tryToFly());

        // This allows dynamic changes for flyingType
        sparky.setFlyingAbility(new ItFlys());
        System.out.println("Dog: " + sparky.tryToFly());
    }
}
