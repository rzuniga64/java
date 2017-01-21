package java_lessons.lesson11_polymorphism;

/**
 * InheritFromAbstractClass class.
 */
public final class InheritFromAbstractClass {

    /**Consturctor. */
    private InheritFromAbstractClass() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
   public static void main(final String[] args) {
        //Shape is abstract so cannot be instantiated
        //ShapeInterface s1 = new ShapeInterface(3,3);
        Circle c1 = new Circle(5, 10, 5);
        c1.draw();
        Rectangle r1 = new Rectangle(5, 10,  10, 10);
        r1.draw();
   }
}
