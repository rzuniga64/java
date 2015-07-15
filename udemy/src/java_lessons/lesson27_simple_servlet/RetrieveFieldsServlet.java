package java_lessons.lesson27_simple_servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// pass information from a form to a java servelt using a GET request
// This is the servlet code
public class RetrieveFieldsServlet   extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException, ServletException {
        response.setContentType("text/html");
        // PrintWrite allows data to be written to page
        PrintWriter writer = response.getWriter();
        // call getParameter on the request object with the name of the
        // field from our form
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        writer.println("Full name: " + fullname);
        writer.println("Address: " + address);
        writer.println("City: " + city);
        writer.println("State: " + state);
        writer.println("Zip code: " + zip);
        writer.close();
    }
}
