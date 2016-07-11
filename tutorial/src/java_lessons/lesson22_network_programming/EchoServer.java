package java_lessons.lesson22_network_programming;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The type EchoServer.
 */
public class EchoServer {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        // set up a server socket
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(10007);
        } catch (IOException ie) {
            System.out.println("Can't listen on 10007");
            System.exit(1);
        }

        // set up a client socket
        Socket clientSock = null;
        System.out.println("Listening for connection....");

        try {
            clientSock = serverSocket.accept(); // wait for server socket to connect to client socket
        }catch (IOException ie) {
            System.out.println("Accept failed.");
            System.exit(1);
        }

        System.out.println("Connection successful");
        System.out.println("Listening for input....");

        // get data from client socket
        PrintWriter output = new PrintWriter(clientSock.getOutputStream(),true);
        // print the data received from the client socket
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
        String inputLine;

        while((inputLine = input.readLine()) != null) {
            System.out.println("Server: " + inputLine);
            output.println(inputLine);
            if (inputLine.equals("Bye"))
                break;
        }

        output.close();
        input.close();
        clientSock.close();
        serverSocket.close();
    }
}
