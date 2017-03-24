package behavorial.strategy;

/**
 * The type Dog.
 */
public class Dog extends Animal{

    /**
     * Dig hole.
     */
    public void digHole(){

        System.out.println("Dug a hole");
    }

    /**
     * Instantiates a new Dog. We set the Flys interface polymorphically. This sets the behavior as a non-flying Animal
     */
    public Dog(){

        super();
        setSound("Bark");
        flyingType = new CantFly();
    }

	/* BAD
	* You could override the fly method, but we are breaking the rule that we need to abstract what is different to
	* the subclasses
	*
	public void fly(){

		System.out.println("I can't fly");
	}*/
}