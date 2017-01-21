package java_lessons.lesson10_inheritance;

/**
 * Manager class.
 */
public class Manager extends Employee {

   /** Department. */
   private String department;

   /**
    * Constructor.
    * @param n name
    * @param s salary
    * @param d department
    */
   Manager(final String n, final int s, final String d) {
      super(n, s);
      department = d;
   }

   /**
    * Get department.
    * @return department
    */
   public String getDepartment() {
      return department;
   }

   @Override
   /**
    * Display the manager information.
    */
   public String display() {

      String empinfo = super.display();
      return empinfo + "Department: " + department + "\n";
   }

    /**
     * Set the salary.
     * @param e employee
     * @param amount amount of salary
     */
   public void setSalary(final Employee e, final double amount) {

       e.setSalary(amount);
   }
}
