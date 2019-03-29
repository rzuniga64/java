package behavorial.strategy.animal;

/**
 *  The type Dog.
 */
public class Dog extends Animal {

    /**
     * Instantiates a new Dog. We set the Flys interface polymorphically.
     * This sets the behavior as a non-flying Animal.
     */
    public Dog() {

        super();
        setSound("Bark");
        flyingType = new ItCantFly();
    }

    /**
     *  digHole method.
     */
    public void digHole() {

        System.out.println("Dug a hole");
    }
}
