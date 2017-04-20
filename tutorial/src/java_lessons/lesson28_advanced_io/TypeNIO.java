package java_lessons.lesson28_advanced_io;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

/**
 * The type TypeNIO. This is a utility to recreate the 'type' behavorial.command in DOS that displays the contents of a file on
 * the screen. In doing that we are going to demonstrate how to read data from a buffer.
 */
public class TypeNIO {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

        int count;  // keep track of the size of the buffer.
        File sourceFile = new File("tutorial\\src\\java\\lesson28_advanced_io\\minmax.txt");
        FileChannel sourceChannel = new FileInputStream(sourceFile).getChannel();

        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            do {
                count = sourceChannel.read(buffer); // read the data from source channel into buffer
                if (count != -1) {
                    buffer.rewind(); // read the beginning of the buffer's contents
                    for (int i = 0; i < count; i++)
                        System.out.print((char)buffer.get()); // pull out data from buffer
                }
            } while (count != -1);
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}