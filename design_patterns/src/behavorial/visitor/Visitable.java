package behavorial.visitor;

/**
 *  The Visitable interface.  Allows the Visitor to pass the object so the right operations occur on the right type of
 *  object.
 */
interface Visitable {

    /**
     *  Accept() is passed the same Visitor object but then the method visit() is called using the Visitor object.
     *  The right version of visit() is called because of method overloading.
     *  @param visitor the visitor
     *  @return a double
     */
    double accept(Visitor visitor);
}