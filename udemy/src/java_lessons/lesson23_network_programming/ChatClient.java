package java_lessons.lesson23_network_programming;

import java.net.*;
import java.io.*;

public class ChatClient {
   public static void main(String[] args) throws Exception {
       // create a socket with the server ip address and port
      Socket client = new Socket("127.0.0.1", 10007);
       // create an input object to receive input from socket
      BufferedReader input = new BufferedReader(
         new InputStreamReader(client.getInputStream()));
       // create an output object to send output
      PrintStream output = new PrintStream(client.getOutputStream());
       // create an input object to receive input from the keyboard
      BufferedReader clientInput = new BufferedReader(
         new InputStreamReader(System.in));
       // create variable to hold data typed in
      String line;
      while (true) {
         System.out.print("Client: ");
         line = clientInput.readLine(); // receive input from keyboard
         output.println(line);          // write data to server
         line = input.readLine();       // wait for input coming back
         System.out.print("Server: " + line + "\n");
         if (line.equals("bye")) {
            break;
         }
      }
      client.close();
      input.close();
      clientInput.close();
      output.close();
   }
}