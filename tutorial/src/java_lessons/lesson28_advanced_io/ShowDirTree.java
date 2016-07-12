package java_lessons.lesson28_advanced_io;

import java.io.*;
import java.nio.file.*;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.*;

/**
 * The type File visitor.
 */
class FileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}

/**
 * The type Show dir tree.
 */
public class ShowDirTree {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String dir = "C:\\Users\\Roy\\git\\java\\udemy\\src\\java_lessons\\lesson28_advanced_io";
        System.out.println("Starting directory: " + dir + ": ");
        try {
            Files.walkFileTree(Paths.get(dir), new FileVisitor());
        } catch (IOException e) {
            System.out.println("Error walking directory tree");
        }
    }
}