package advanced_java.ch7_exception_handling;

import java.io.*;
import java.util.*;

public class FileNotFound {
    public static void main(String[] args) {
        // String file = "C:\\mydata.dat";
        String file = "C:\\Users\\Roy\\git\\java\\udemy\\src\\advanced_java\\ch7_exception_handling\\FileNotFound.java";
        String line = "";
        BufferedReader inFile = null;
        try {
            inFile = new BufferedReader(new FileReader(file));
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
