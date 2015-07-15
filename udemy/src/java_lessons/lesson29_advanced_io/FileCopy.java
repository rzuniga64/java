package java_lessons.lesson29_advanced_io;

import java.io.*;
import java.nio.channels.*;

// io in Java uses file and channels
public class FileCopy {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File("C:\\Users\\Roy\\git\\java\\udemy\\src\\java_lessons\\lesson29_advanced_io\\minmax.txt");
        File destFile = new File("C:\\Users\\Roy\\git\\java\\udemy\\src\\java_lessons\\lesson29_advanced_io\\minmax.bak");
        if (!destFile.exists())
            destFile.createNewFile();
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;

        try {
            sourceChannel = new FileInputStream(sourceFile).getChannel();
            destChannel = new FileOutputStream(destFile).getChannel();
            destChannel.transferFrom(sourceChannel,0,sourceChannel.size());

        } finally {
            if (sourceChannel != null)
                sourceChannel.close();
            if (destChannel != null)
                destChannel.close();
        }
    }
}
