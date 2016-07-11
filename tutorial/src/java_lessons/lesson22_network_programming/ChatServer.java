package java_lessons.lesson22_network_programming;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The type Chat server.
 */
public class ChatServer {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {

        // set up server socket and tell it what port to listen on
        ServerSocket server = new ServerSocket(10007);
        // create a regular socket that accepts incoming messages
        Socket sock = server.accept();
        // create an input object to receive input into the socket
        BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        // create an output object to send output
        PrintStream output = new PrintStream(sock.getOutputStream());
       // create a buffered reader object so we can type in messages from the server using system.in for them to go out.
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

       // create a variable to hold data typed in
        String line;

        while (true) {
            line = input.readLine();
            if (line.equals("bye"))
                break;
         // print message from client
         System.out.println("Client: " + line);
         System.out.print("Server: ");
         // print message sent from server
         line = serverInput.readLine();
         output.println(line);
      }

        server.close();
        sock.close();
        input.close();
        output.close();
        serverInput.close();
   }
}