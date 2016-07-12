package java_lessons.lesson28_advanced_io;

import java.io.IOException;
import java.nio.file.*;

/**
 * The type FileData.
 */
public class FileData {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Path filePath = Paths.get("tutorial\\src\\java_lessons\\lesson28_advanced_io\\minmax.txt");
        System.out.println("File name: " + filePath.getName(4));

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
