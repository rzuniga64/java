package java_lessons.lesson14_file_processing;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * WritingDataToFile class.
 */
public final class WritingDataToFile {

    /** Constructor. */
    private WritingDataToFile() { }

    /**
     * Unit tests.
     * @param args the arguments
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {

        String fileName = "grades.txt";
        PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
        outFile.println(85);
        outFile.println(77);
        outFile.close();
    }
}