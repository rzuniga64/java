package java_lessons.lesson27_simple_servlet;
/*
    I had to copy this file and compile it in directory
    C:\xampp\tomcat\webapps\examples\WEB-INF\classes.
    Then I had to modify C:\xampp\tomcat\webapps\examples\WEB-INF\web.xml
    and add servlet and servlet-mapping tags.
    Then the server must be started and in the browser type
    localhost:8080/examples/servlets/servlet/HelloWorldServlet.
 */

import java.io.*;
/*import javax.servlet.*;

public class HelloWorldServlet extends GenericServlet {
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("Hello, world!");
        pw.close();
    }
} */
      