/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.calculator.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.polsl.calculator.model.Calculation;
import pl.polsl.calculator.model.CalculationData;
import pl.polsl.calculator.model.CalculatorModel;
import pl.polsl.calculator.model.DataSource;

/**
 *
 * @author mdw18
 */
@WebServlet(name = "CalculatorModelServlet", urlPatterns = {"/doCalculation"})
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
        
        
    // Pobieranie parametrów z żądania
        String firstNumberParam = request.getParameter("firstNumber");
        String secondNumberParam = request.getParameter("secondNumber");
        String operator = request.getParameter("operator");

                ServletContext context = request.getServletContext();
        DataSource dataSource = (DataSource)context.getAttribute("DataSource"); 
        
        // Przygotowanie odpowiedzi
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Wynik Kalkulatora</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Wynik Kalkulatora</h1>");

            try {
                // Parsowanie parametrów do liczb
                double firstNumber = Double.parseDouble(firstNumberParam);
                double secondNumber = Double.parseDouble(secondNumberParam);

                // Tworzenie modelu kalkulatora i obliczanie wyniku
                CalculatorModel calculator = new CalculatorModel(firstNumber, secondNumber, operator);
                double result = calculator.calculateResult();

                // Wyświetlenie wyniku
                out.println("<p>Liczba 1: " + firstNumber + "</p>");
                out.println("<p>Operator: " + operator + "</p>");
                out.println("<p>Liczba 2: " + secondNumber + "</p>");
                out.println("<p><strong>Wynik: " + result + "</strong></p>");
                dataSource.saveData(new CalculationData(calculator.getFirstNumber(),
                        calculator.getSecondNumber(),calculator.getResult(),calculator.getOperator()));
            } catch (NumberFormatException e) {
                // Obsługa błędów parsowania liczb
                out.println("<p><strong>Błąd: Niepoprawne dane wejściowe!</strong></p>");
            } catch (IllegalArgumentException | ArithmeticException e) {
                // Obsługa błędów kalkulacji (np. dzielenie przez zero)
                out.println("<p><strong>Błąd: " + e.getMessage() + "</strong></p>");
            }

            out.println("<a href=\"index.html\">Powrót do strony głównej</a>");
            out.println("</body>");
            out.println("</html>");
        }
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
