/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
 *
 * @author mdw18
 */
@WebServlet(name = "CalculatorServlet", urlPatterns = {"/CalculatorServlet"})
public class CalculatorServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        Cookie c = null;
        Cookie[] ck = request.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if ("calculationsCount".equals(cookie.getName())) {
                    c = cookie;
                }
            }
        }
        int id = c == null ? 1 : Integer.parseInt(c.getValue()) + 1;

        ServletContext context = request.getServletContext();
        DataSource dataSource = (DataSource) context.getAttribute("DataSource");

        String firstNumberParam = request.getParameter("firstNumber");
        String secondNumberParam = request.getParameter("secondNumber");
        String operator = request.getParameter("operator");

        double firstNumber = Double.parseDouble(firstNumberParam);
        double secondNumber = Double.parseDouble(secondNumberParam);

        CalculatorModel calculator = new CalculatorModel(firstNumber, secondNumber, operator);

        dataSource.persistObject(new CalculationData(id, calculator.getFirstNumber(),
                calculator.getSecondNumber(), calculator.getResultNumber(), calculator.getOperator()));

        PrintWriter out = response.getWriter();
        response.addCookie(new Cookie("calculationsCount", Integer.toString(id)));

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Wynik Kalkulatora</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Wynik Kalkulatora</h1>");
        out.println("<p>Liczba 1: " + firstNumber + "</p>");
        out.println("<p>Operator: " + operator + "</p>");
        out.println("<p>Liczba 2: " + secondNumber + "</p>");
        out.println("<p><strong>Wynik: " + calculator.getResultNumber() + "</strong></p>");
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
