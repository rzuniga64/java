package java_lessons.lesson28_advanced_io;

import java.io.*;
import java.nio.channels.*;

/**
 * The type File copy. This new IO in Java uses buffers and channels rather than buffers and streams.
 * File copying is quick. We use one method to copy. We don't have to set up a loop to copy byte by byte.
 */
public class FileCopy {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

        File sourceFile = new File("tutorial\\src\\java\\lesson28_advanced_io\\minmax.txt");
        File destFile   = new File("tutorial\\src\\java\\lesson28_advanced_io\\minmax.bak");

        if (!destFile.exists()) destFile.createNewFile();

        // We have to associate our source and destination files with a channel.
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
