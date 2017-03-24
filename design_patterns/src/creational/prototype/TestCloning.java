package creational.prototype;

public class TestCloning {

    public static void main(final String[] args){

        // Handles routing makeCopy method calls to the right subclasses of Animal
        PrototypeFactory animalMaker = new PrototypeFactory();

        // Creates a new Sheep instance
        Sheep sally = new Sheep();

        // Creates a clone of Sally and stores it in its own memory location
        Sheep clonedSheep = (Sheep) animalMaker.getClone(sally);

        // These are exact copies of each other
        System.out.println(sally);
        System.out.println(clonedSheep);

        // Prove that they are in different locations in memory
        System.out.println("Sally HashCode: " + System.identityHashCode(sally));
        System.out.println("Clone HashCode: " + System.identityHashCode(clonedSheep));
    }
}
