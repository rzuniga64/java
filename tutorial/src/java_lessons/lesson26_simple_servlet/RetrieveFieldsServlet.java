/*package java_lessons.lesson26_simple_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
*/

/**
 * The type RetrieveFieldsServlet. Pass information from a form to a java servlet using a GET request.
 */
//public class RetrieveFieldsServlet   extends HttpServlet {
    /**
     * Do get.
     *
     * @param request  the request
     * @param response the response
     * @throws IOException      the io exception
     * @throws ServletException the servlet exception
     */
/*    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException, ServletException {

        response.setContentType("text/html");
        // PrintWrite allows data to be written to page
        PrintWriter writer = response.getWriter();

        // call getParameter on the request object with the name of the field from our form
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
} */
