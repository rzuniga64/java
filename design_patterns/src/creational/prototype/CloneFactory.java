package creational.prototype;

class CloneFactory {

    /**
     *  Receives any Animal, or Animal subclass and makes a copy of it and stores it in its own location in memory.
     *  CloneFactory has no idea what these objects are except that they are subclasses of Animal.
     *  @param animal animalSample
     */
    Animal getClone(final Animal animal) {


         //  Because of Polymorphism the Animal's makeCopy() is called here instead of Sheep.
        return animal.makeCopy();
    }
}
