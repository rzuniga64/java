package visitor;

/**
 * The interface Visitable.  Allows the Visitor to pass the object so the right operations occur on the right
 * type of object.
 */
interface Visitable {

    /**
     *  Accept double.
     *  Accept() is passed the same visitor object but then the method visit() is called using the visitor object.
     *  The right version of visit() is called because of method overloading.
     *
     * @param visitor the visitor
     * @return the double
     */
    double accept(Visitor visitor);
}