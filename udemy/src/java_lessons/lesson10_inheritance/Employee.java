package java_lessons.lesson10_inheritance;

public class Employee
{
   private final String name;
   protected double salary;

   Employee(String n, double s) {
      name = n;
      salary = s;
   }
 
   public String getName() {
      return name;
   }

   public double getSalary() {
      return salary;
   }

   public String displayEmpInfo() {
      return "Name: " + name + "\n" + 
             "Salary: " + salary + "\n";
   }
}