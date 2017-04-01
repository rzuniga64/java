package behavorial.strategy.animal;

/**
 * The type Dog.
 */
public class Dog extends Animal {

    /**
     * Dig hole.
     */
    public void digHole() {

        System.out.println("Dug a hole");
    }

    /**
     * Instantiates a new Dog. We set the Flys interface polymorphically.
     * This sets the behavior as a non-flying Animal
     */
    public Dog() {

        super();
        setSound("Bark");
        flyingType = new CantFly();
    }
}
