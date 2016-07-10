package java_lessons.lesson20_exception_handling;

import java.io.*;

/**
 * The type FileNotFound.
 */
public class FileNotFound {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // String file = "C:\\mydata.dat";
        String file = "java_lessons\\lesson20_exception_handling\\FileNotFound.java";
        String line;
        BufferedReader inFile = null;

        try {
            inFile = new BufferedReader(new FileReader(file));
            System.out.println("File found. Output to come later");
            while ((line = inFile.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {

            System.out.print("File not found. Try again");
        } catch (IOException e) {

            System.out.print("Problem reading file.");
        } finally {

            if (inFile != null)
                try {
                    inFile.close();
                } catch (IOException e) {
                    System.out.println("Problem with file.");
                }
        }
    }
}
