package java_lessons.lesson22_network_programming;

import java.net.URL;
import java.net.URLConnection;
import java.io.*;

/**
 * The type urlProg. Make a connection to a website and retrieve the content.
 */
public class urlProg {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    // most of the time with network programming methods have to throw an exception.
    public static void main(String[] args) throws Exception {

        URL theURL = new URL("http://www.infiniteskills.com");

        System.out.println("Basic information: ");
        System.out.println();
        System.out.println("Protocol: " + theURL.getProtocol());
        System.out.println("Port: " + theURL.getPort());
        System.out.println("Host: " + theURL.getHost());

        // Display the content, or raw HTML, of the website. Must create a URL connection object
        URLConnection theConn = theURL.openConnection();

        // check to see if there is content
        int contentLength = theConn.getContentLength();
        int c;

        if (contentLength != 0) {
            System.out.println("Content: ");
            System.out.println();
            InputStream urlInput = theConn.getInputStream();

            while ((c = urlInput.read()) != -1)
                System.out.print((char) c);
            urlInput.close();
        } else {
            System.out.println("Sorry, no content.");
        }
    }
}
