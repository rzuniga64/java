package ch13_inheritance;

public class OverridingMethods
{
   public static void main(String[] args)
   {
      Employee e1 = new Employee("Smith", 30000);
      Manager m1 = new Manager("Brown", 50000, "IT");
      System.out.println(e1.displayEmpInfo());
      System.out.println(m1.displayEmpInfo());
   }
}