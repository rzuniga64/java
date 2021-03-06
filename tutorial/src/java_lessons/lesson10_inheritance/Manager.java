package java_lessons.lesson10_inheritance;

/**
 *  Manager class.
 *  When we write the constructor of the subclass we have to call the
 *  constructor of the superclass.
 *
 *  Overriding is the ability to overwrite the superclass's methods in subclass
 *  so it can use some of the information from the superclass plus adds
 *  its own information from the sublclass necessary to complete the method.
 */
public final class Manager extends Employee {

   /** Department. */
   private String department;

   /**
    * Constructor.
    * @param n name
    * @param s salary
    * @param d department
    */
   Manager(final String n, final int s, final String d) {
      super(n, s);  // call the constructor of the superclass.
      department = d;
   }

   /**
    * Get department.
    * @return department
    */
   public String getDepartment() {
      return department;
   }

    /**
     * Set the salary.
     * @param e employee
     * @param amount amount of salary
     */
    public void setSalary(final Employee e, final double amount) {

        e.salary = amount;
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
    * Unit tests.
    * @param args the arguments
    */
    public static void main(final String[] args) {

        Employee e1 = new Employee("Brown", 30000);
        System.out.println(e1.getName() + ": " + e1.getSalary());
        Manager m1 = new Manager("Smith", 50000, "Sales");

        System.out.println(m1.getName());
        System.out.println(m1.getSalary());
        System.out.println(m1.getDepartment());
        //m1.raise(.2);
        System.out.println(m1.getSalary());

        // test overriding methods
        System.out.println(e1.display());
        System.out.println(m1.display());

        // Test protected data member salary.
        m1.setSalary(e1, 25000);
        System.out.println(e1.display());
    }
}
