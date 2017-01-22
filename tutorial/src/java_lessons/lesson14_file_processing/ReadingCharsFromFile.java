package java_lessons.lesson14_file_processing;

import java.io.*;

/**
 *  ReadingCharsFromFile class.
 *  FileWriter opens a file for output.
 *  FileWriter opens a file for reading.
 *  Must add throws IOException to the main function.
 */
public final class ReadingCharsFromFile {

    /** Constructor. */
    private ReadingCharsFromFile() { }

    /**
     * Unit tests.
     * @param args the arguments
     * @throws IOException IOException
     */
    public static void main(final String[] args) throws IOException {

        String inputFile = "tutorial\\src\\java_lessons\\lesson14_file_processing"
                + "\\chars.txt";
        String outputFile = "tutorial\\src\\java_lessons\\lesson14_file_processing"
                + "\\chars.bak";
        FileReader inFile = new FileReader(inputFile);
        FileWriter outFile = new FileWriter(outputFile);
        int ch;
        ch = inFile.read();

        while (ch != -1) {
            outFile.write(ch);
            ch = inFile.read();
        }

        outFile.close();
        inFile.close();
    }
}