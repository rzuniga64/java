package java_lessons.lesson6_methods;

/**
 * VoidMethods class.
 */
public final class VoidMethods {

    /** Constructor. */
    private VoidMethods() { }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {

      heading("Jones", "6/6/11");
   }

    /**
     * Print a heading.
     * @param name the name
     * @param date the data
     */
   private static void heading(final String name, final String date) {
      System.out.println("**************");
      System.out.println("*  " + name + "   *");
      System.out.println("*  " + date + "   *");
      System.out.println("**************");
   }
}
