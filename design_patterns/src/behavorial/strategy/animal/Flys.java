package behavorial.strategy.animal;

/**
 *  The interface Flys.
 *
 *  The interface is implemented by many other subclasses that allow for many
 *  types of flying without effecting Animal, or Flys. Avoid interfaces that
 *  just force action.
 *
 *  Classes that implement new Flys interface subclasses can allow other classes
 *  to use that code eliminating code duplication
 *
 *  Interface is implemented by many other subclasses. This allows us to make
 *  many different methods of flying without affecting Animal class or any of
 *  its subclasses. I'm DECOUPLING : encapsulating the concept that varies.
 */
interface Flys {

    /**
     * Fly string.
     *
     * @return the string
     */
    String fly();
}

/**
 *  The type ItFlys. Class used if the Animal can fly
 */
class ItFlys implements Flys {

    /** fly method. */
    public String fly() {
        return "Flying High";
    }
}

/**
 *  The type CantFly. Class used if the Animal can't fly.
 */
class CantFly implements Flys {

    /** fly method. */
    public String fly() {
        return "I can't fly";
    }
}
