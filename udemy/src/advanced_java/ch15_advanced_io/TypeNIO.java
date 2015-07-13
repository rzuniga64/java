package advanced_java.ch15_advanced_io;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class TypeNIO {
    public static void main(String[] args) throws IOException {
        int count;  // keep track of the size of the buffer.
        File sourceFile = new File("C:\\Users\\Roy\\git\\java\\udemy\\src\\advanced_java\\ch15_advanced_io\\minmax.txt");
        FileChannel sourceChannel = new FileInputStream(sourceFile).getChannel();
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            do {
                count = sourceChannel.read(buffer);
                if (count != -1) {
                    buffer.rewind(); // read the beginning of the buffer's contents
                    for (int i = 0; i < count; i++)
                        System.out.print((char)buffer.get());
                }
            } while (count != -1);
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

    }
}
