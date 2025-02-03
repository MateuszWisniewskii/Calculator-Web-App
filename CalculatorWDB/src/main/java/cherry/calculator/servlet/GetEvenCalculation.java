/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cherry.calculator.servlet;

import cherry.calculator.model.CalculationEntity;
import cherry.calculator.model.DataSource;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author mdw18
 */
@WebServlet(name = "GetEvenCalculation", urlPatterns = {"/GetEvenCalculation"})
public class GetEvenCalculation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
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

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>\n"
                + "        <title>Historia Obliczeń</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <link rel=\"stylesheet\" href=\"css/historyStyle.css\" />\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>");
         out.println("<body>");
        // Generate an HTML table for the calculation data
        for (CalculationEntity data : dataSource.getEvenCalculation()) {

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

        out.println("</body>");
        out.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
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
     *
     * @param request servlet request
     * @param response servlet response
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
