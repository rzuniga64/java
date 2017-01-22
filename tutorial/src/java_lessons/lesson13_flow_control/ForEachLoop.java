package java_lessons.lesson13_flow_control;

import java.util.ArrayList;

/**
 *  ForEachLoop class.
 *  for(variable declaration : collection-name) {
 *      set of statements;
 *  }
*/
public final class ForEachLoop {

    /** Constructor. */
    private ForEachLoop() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        int[] numbers = new int[10];
        // initialize the array.
        for (int i = 0; i < 10; ++i) {
            numbers[i] = i + 1;
        }
        // print the array.
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        ArrayList<Employee> emps = new ArrayList<>();

        Employee emp1 = new Employee("Brown", 20000);
        Employee emp2 = new Employee("Smith", 21000);
        Employee emp3 = new Employee("Jones", 22000);
        Employee emp4 = new Employee("Green", 23000);
        emps.add(emp1);
        emps.add(emp2);
        emps.add(emp3);
        emps.add(emp4);

        for (Employee emp : emps) {
            System.out.println(emp.displayEmpInfo());
        }
    }
}
