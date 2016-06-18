package java_lessons.lesson22_network_programming;

import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;


/*  Example using TCP/IP sockets using a simple client program that
 *  connects to a whois server.
 *  Whois allows you to see some specific domain registration information.
 *  A socket is a way to make a connection to a server. When you are communicating
 *  via sockets, you have a server socket and a client socket in order to have
 *  two-way communication.
 */
public class ClientSocket {
    public static void main(String[] args) throws Exception {
        // create a socket, input stream to receive data and output stream to send data
        Socket socket = new Socket("whois.internic.net", 43);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        String url = "infiniteskills.com\n";
        // turn the string into bytes and store it in a byte array.
        byte buffer[] = url.getBytes();
        // send our command through the socket
        output.write(buffer);
        // get the input that comes back (grab chars as they come in)
        int ch;
        while ((ch = input.read()) != -1)
            System.out.print((char) ch);
        socket.close();
    }
}
