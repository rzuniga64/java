package java_lessons.lesson28_advanced_io;

import java.io.IOException;
import java.nio.file.*;

public class FileData {
    public static void main(String[] args) {
        Path filePath = Paths.get("C:\\Users\\Roy\\git\\java\\udemy\\src\\java_lessons\\lesson28_advanced_io\\minmax.txt");
        System.out.println("File name: " + filePath.getName(8));
        try {
            if (!Files.isHidden(filePath))
                System.out.println("File is not hidden");
            else
                System.out.println("File is hidden");
            if (Files.isWritable(filePath))
                System.out.println("File is writable");
            if (Files.isReadable(filePath))
                System.out.println("File is readable");
        } catch (IOException e) {
            System.out.println("Error checking file attributes");
        }
    }
}
