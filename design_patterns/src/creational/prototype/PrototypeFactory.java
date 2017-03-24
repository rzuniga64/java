package creational.prototype;

class PrototypeFactory {

    /**
     *  Receives any Animal, or Animal subclass and makes a copy of it and
     *  stores it in its own location in memory. PrototypeFactory has no idea
     *  what these objects are except that they are subclasses of Animal.
     *  @param animalSample animalSample
     */
    Animal getClone(final Animal animalSample) {

        /**
         *  Because of Polymorphism the Sheeps makeCopy() is called here instead
         *  of Animals.
         */
        return animalSample.makeCopy();
    }
}
