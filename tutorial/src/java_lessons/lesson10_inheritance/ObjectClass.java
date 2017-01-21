package java_lessons.lesson10_inheritance;

/**
 * ObjectClass class.
 * Every feature in Java is an object and those objects are placed in a chain
 * of inheritance.
 * An instance of the Object class can take on any other object.
 * toString() and equals(Object object) are methods of the Object class which
 * are typically overridden.
 */
public final class ObjectClass {

   /** Constructor. */
   private ObjectClass() { }

   /**
    * Unit tests.
    * @param args the arguments
    */
   public static void main(final String[] args) {

      Object anObject = new Employee("Smith", 30000);
      System.out.println("Type of Object: "
              + anObject.getClass().getName());
      Employee e1 = (Employee) anObject; // casting
      System.out.println(e1.display());
   }
}