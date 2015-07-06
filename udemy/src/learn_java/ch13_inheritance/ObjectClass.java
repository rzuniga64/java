package learn_java.ch13_inheritance;

public class ObjectClass
{
   public static void main(String[] args)
   {
      Object anObject = new Employee("Smith", 30000);
      System.out.println("FileNotFound of anObject: " + anObject.getClass().getName());
      Employee e1 = (Employee)anObject; // casting
      System.out.println(e1.displayEmpInfo());
   }
}