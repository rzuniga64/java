package java_lessons.lesson20_exception_handling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The FileNotFound class.
 */
public final class FileNotFound {

    List<Object> myList = new ArrayList<String>();

    /** Constructor. */
    private FileNotFound() { }
    /**
     * The unit tests for FileNotFound class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        String file =
                "java_lessons\\lesson20_exception_handling\\FileNotFound.java";
        String line;
        Scanner inFile = null;

        try {
            inFile = new Scanner(new FileReader(file));
            System.out.println("File found. Output to come later");
            while (inFile.hasNextLine()) {
                System.out.println(inFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.print("File not found. Try again");
        } catch (IOException e) {
            System.out.print("Problem reading file.");
        } finally {

            if (inFile != null) {
                inFile.close();
            }
        }
    }
}
