package java_lessons.lesson13_flow_control;

/**
 * Employee class.
 */
public class Employee {
    /** Name. */
    private final String name;
    /** Salary. */
    private double salary;

    /**
     * Constructor.
     * @param n name
     * @param s salary
     */
    Employee(final String n, final double s) {
        name = n;
        salary = s;
    }

    /**
     * Get the name.
     * @return the name.
     */
    public String getName() {
      return name;
   }

    /**
     * Get the salary.
     * @return the salary
     */
    public double getSalary() {
      return salary;
   }

    /**
     * Display the employee information.
     * @return the employee info as a string.
     */
    public String display() {
        return "Name: " + getName() + "\n" + "Salary: " + getSalary() + "\n";
    }
}
