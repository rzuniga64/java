package java_lessons.lesson22_network_programming;

import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

/**
 *   The type EchoClient.
 *
 *   Use TCP/IP to connect two computers to send messages back and forth.
 *   Server is only echoing back what the client received.
 */

public class EchoClient {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {

        Socket socket = null;
        PrintWriter output = null;
        BufferedReader input = null;

        try {
            socket = new Socket("127.0.0.1", 10007);
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (UnknownHostException e) {
            System.out.println("Unknown host");
            System.exit(1);
        } catch (IOException ie) {
            System.out.println("Cannot connect to host");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        while ((userInput = stdIn.readLine()) != null)
            output.println(userInput);

        output.close();
        input.close();
        stdIn.close();
        socket.close();
    }
}
