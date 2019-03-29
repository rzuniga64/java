package behavorial.strategy.animal;

/**
 *  The interface Flys.
 *
 *  The interface is implemented by many other subclasses that allow for many types of flying without effecting Animal,
 *  or any of the subclasses. Avoid interfaces that just force action.
 *
 *  Classes that implement new Flys interface subclasses can allow other classes to use that code eliminating code
 *  duplication.
 *
 *  Interface is implemented by many other subclasses. This allows us to make many different methods of flying without
 *  affecting Animal class or any of its subclasses. I'm DECOUPLING : encapsulating the concept that varies.
 */
interface Flys {

    /**
     * Fly string.
     * @return the string
     */
    String fly();
}
