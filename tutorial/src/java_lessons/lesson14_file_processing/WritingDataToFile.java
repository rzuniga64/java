package java_lessons.lesson14_file_processing;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *  WritingDataToFile class.
 *  PrintWrite is the class that allows us to write data to a file.
 *  FileWrite opens a file for output.
 *  Must add throws IOException to the main function.
 *
 */
public final class WritingDataToFile {

    /** Constructor. */
    private WritingDataToFile() { }

    /**
     * Unit tests.
     * @param args the arguments
     * @throws IOException IOException
     */
    public static void main(final String[] args) throws IOException {

        String fileName = "tutorial\\src\\java\\lesson14_file_processing"
                + "\\grades.txt";
        PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
        outFile.println(85);
        outFile.println(77);
        outFile.close();
    }
}