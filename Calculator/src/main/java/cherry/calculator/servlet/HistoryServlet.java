package cherry.calculator.servlet;

import cherry.calculator.model.DataSource;
import cherry.calculator.model.CalculationData;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet responsible for displaying the history of calculations.
 * Retrieves calculation data from the {@link DataSource} stored in the servlet context
 * and formats it as HTML for the response.
 * 
 * @author Mateusz Wiśniewski
 */
@WebServlet(name = "HistoryServlet", urlPatterns = {"/HistoryServlet"})
public class HistoryServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * Generates an HTML table of all stored calculations retrieved from the {@link DataSource}.
     *
     * @param request the HTTP request object
     * @param response the HTTP response object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the content type for the response
        response.setContentType("text/html;charset=UTF-8");

        // Retrieve the DataSource object from the servlet context
        ServletContext context = request.getServletContext();
        DataSource dataSource = (DataSource) context.getAttribute("DataSource");

        // Use a PrintWriter to write the HTML response
        PrintWriter out = response.getWriter();

        // Generate an HTML table for the calculation data
        for (CalculationData data : dataSource.getAllCalculation()) {
            out.println("<tr>");
            out.println("<td>");
            out.println(Integer.toString(data.getId())); // Display the ID
            out.println("</td>");
            out.println("<td>");
            out.println(Double.toString(data.getFirstNumber())); // Display the first number
            out.println("</td>");
            out.println("<td>");
            out.println(data.getOperator()); // Display the operator
            out.println("</td>");
            out.println("<td>");
            out.println(Double.toString(data.getSecondNumber())); // Display the second number
            out.println("</td>");
            out.println("<td>");
            out.println(Double.toString(data.getResultNumber())); // Display the result
            out.println("</td>");
            out.println("</tr>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * Forwards the request to the {@link #processRequest(HttpServletRequest, HttpServletResponse)} method.
     *
     * @param request the HTTP request object
     * @param response the HTTP response object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Forwards the request to the {@link #processRequest(HttpServletRequest, HttpServletResponse)} method.
     *
     * @param request the HTTP request object
     * @param response the HTTP response object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing the description of the servlet
     */
    @Override
    public String getServletInfo() {
        return "Servlet responsible for displaying the history of calculations.";
    }
    // </editor-fold>
}
