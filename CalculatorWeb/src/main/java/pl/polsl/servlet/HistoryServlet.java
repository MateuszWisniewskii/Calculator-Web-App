


package pl.polsl.servlet;




 


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Definicja rekordu do przechowywania obliczeń
record Calculation(String arg1, String operator, String arg2, String result) {}

@WebServlet(name = "HistoryServlet", urlPatterns = {"/HistoryServlet"})
public class HistoryServlet extends HttpServlet {
    // Lista do przechowywania obliczeń
    private final List<Calculation> calculations = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pobranie parametrów
        String arg1 = request.getParameter("arg1");
        String operator = request.getParameter("operator");
        String arg2 = request.getParameter("arg2");

        String result;
        try {
            // Obliczanie wyniku
            result = calculateResult(arg1, operator, arg2);
            // Dodawanie do listy
            calculations.add(new Calculation(arg1, operator, arg2, result));
        } catch (IllegalArgumentException e) {
            result = "Błąd: " + e.getMessage();
        }

        // Generowanie odpowiedzi HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Historia obliczeń</title></head>");
        out.println("<body>");
        out.println("<h1>Historia obliczeń</h1>");
        out.println("<form action=\"calculator\" method=\"GET\">");
        out.println("  <input type=\"text\" name=\"arg1\" placeholder=\"Pierwszy argument\" required>");
        out.println("  <select name=\"operator\">");
        out.println("    <option value=\"+\">+</option>");
        out.println("    <option value=\"-\">-</option>");
        out.println("    <option value=\"*\">*</option>");
        out.println("    <option value=\"/\">/</option>");
        out.println("  </select>");
        out.println("  <input type=\"text\" name=\"arg2\" placeholder=\"Drugi argument\" required>");
        out.println("  <input type=\"submit\" value=\"Oblicz\">");
        out.println("</form>");
        out.println("<table border=\"1\">");
        out.println("<tr><th>Pierwszy argument</th><th>Operator</th><th>Drugi argument</th><th>Rezultat</th></tr>");

        // Wypełnianie tabeli wynikami
        for (Calculation calc : calculations) {
            out.println("<tr>");
            out.println("<td>" + calc.arg1() + "</td>");
            out.println("<td>" + calc.operator() + "</td>");
            out.println("<td>" + calc.arg2() + "</td>");
            out.println("<td>" + calc.result() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    // Metoda do obliczania wyniku
    private String calculateResult(String arg1, String operator, String arg2) {
        try {
            double num1 = Double.parseDouble(arg1);
            double num2 = Double.parseDouble(arg2);
            return switch (operator) {
                case "+" -> String.valueOf(num1 + num2);
                case "-" -> String.valueOf(num1 - num2);
                case "*" -> String.valueOf(num1 * num2);
                case "/" -> {
                    if (num2 == 0) throw new IllegalArgumentException("Dzielenie przez zero");
                    yield String.valueOf(num1 / num2);
                }
                default -> throw new IllegalArgumentException("Nieznany operator: " + operator);
            };
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Nieprawidłowe argumenty liczby");
        }
    }
}
//   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>