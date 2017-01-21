package java_lessons.lesson7_arraylist;

import java.util.ArrayList;

/**
 * ArrayListIntro class.
 */
public final class ArrayListIntro {

    /** Constructor. */
    private ArrayListIntro() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
   public static void main(final String[] args) {

      double average;
      int total = 0;

      ArrayList<Integer> grades = new ArrayList<>();

      grades.add(78);
      grades.add(84);
      grades.add(90);

      for (int grade : grades) {
          total += grade;
      }
      average = total / grades.size();
      System.out.println("The average is " + average);
   }
}
