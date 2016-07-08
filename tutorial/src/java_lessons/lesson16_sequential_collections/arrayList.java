package java_lessons.lesson16_sequential_collections;

import java.util.ArrayList;

/**
 * The type A list.
 */
public class arrayList {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(100);
        grades.add(90);
        grades.add(80);
        grades.add(70);
        grades.add(60);

        int total = 0;
        for (Integer grade : grades)
            total += grade;
        double average = total / grades.size();
        System.out.println("Size of grades: " + grades.size());
        System.out.println("Average: " + average);

        grades.remove(4);
        System.out.println("New size: " + grades.size());
        grades.add(60);
        grades.add(50);
        System.out.println("Newer size: " + grades.size());
    }
}
