package cherry.calculator.servlet;

import cherry.calculator.model.CalculationData;
import cherry.calculator.model.CalculatorModel;
import cherry.calculator.model.DataSource;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet that handles calculation requests, performs the calculation, 
 * stores the result, and displays it to the user. It also maintains a 
 * calculation count using cookies.
 * 
 * @author Mateusz Wiśniewski
 */
@WebServlet(name = "CalculatorServlet", urlPatterns = {"/CalculatorServlet"})
public class CalculatorServlet extends HttpServlet {

    /**
     * Processes both HTTP <code>GET</code> and <code>POST</code> requests.
     * Performs calculations, validates input, stores results in the application's data source, 
     * and tracks the calculation count using cookies.
     *
     * @param request the HTTP request object
     * @param response the HTTP response object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Retrieve or initialize the "calculationsCount" cookie
        Cookie c = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("calculationsCount".equals(cookie.getName())) {
                    c = cookie;
                    break;
                }
            }
        }

        // Set the ID based on the cookie value or start from 1 if no cookie exists
        int id = (c == null) ? 1 : Integer.parseInt(c.getValue()) + 1;

        // Retrieve the application's data source from the servlet context
        ServletContext context = request.getServletContext();
        DataSource dataSource = (DataSource) context.getAttribute("DataSource");

        // Get parameters from the request
        String firstNumberParam = request.getParameter("firstNumber");
        String secondNumberParam = request.getParameter("secondNumber");
        String operator = request.getParameter("operator");

        try (PrintWriter out = response.getWriter()) {
            // Validate the parameters
            if (firstNumberParam == null || secondNumberParam == null || operator == null) {
                out.println("<h1>Error: All fields must be filled.</h1>");
                return;
            }

            // Parse the numbers
            double firstNumber;
            double secondNumber;
            try {
                firstNumber = Double.parseDouble(firstNumberParam);
                secondNumber = Double.parseDouble(secondNumberParam);
            } catch (NumberFormatException e) {
                out.println("<h1>Error: The inputs must be numeric values.</h1>");
                return;
            }

            // Perform the calculation
            CalculatorModel calculator = new CalculatorModel(firstNumber, secondNumber, operator);

            // Store the result in the application's data source
            CalculationData calculationData = new CalculationData(
                    id,
                    calculator.getFirstNumber(),
                    calculator.getSecondNumber(),
                    calculator.getResultNumber(),
                    calculator.getOperator()
            );
            dataSource.persistObject(calculationData);

            // Add or update the "calculationsCount" cookie
            response.addCookie(new Cookie("calculationsCount", Integer.toString(id)));

            // Generate the response with the result
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Calculator Result</title></head>");
            out.println("<body>");
            out.println("<h1>Calculator Result</h1>");
            out.println("<p>Number 1: " + firstNumber + "</p>");
            out.println("<p>Operator: " + operator + "</p>");
            out.println("<p>Number 2: " + secondNumber + "</p>");
            out.println("<p><strong>Result: " + calculator.getResultNumber() + "</strong></p>");
            out.println("<a href='history.html'><button>View History</button></a>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            response.getWriter().println("<h1>An error occurred: " + e.getMessage() + "</h1>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * Forwards the request to {@link #processRequest(HttpServletRequest, HttpServletResponse)}.
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
     * Forwards the request to {@link #processRequest(HttpServletRequest, HttpServletResponse)}.
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
     * @return A string containing a description of the servlet.
     */
    @Override
    public String getServletInfo() {
        return "Servlet for performing calculations and storing results.";
    }
    // </editor-fold>
}
