package ch13_inheritance;

public class Manager extends Employee
{
   private final String department;

   Manager(String n, int s, String d) {
      super(n, s);
      department = d;
   }

   public String getDepartment() {
      return department;
   }

   @Override
   public String displayEmpInfo() {
      String empinfo = super.displayEmpInfo();
      return empinfo + "Department: " + department + "\n";
   }

   public void setSalary(Employee e, double amount) {
      e.salary = amount;
   }
}