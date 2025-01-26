
package pl.polsl.calculator.servlet;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import pl.polsl.calculator.model.CalculationData;
import pl.polsl.calculator.model.CalculationHistory;
import pl.polsl.calculator.model.DataSource;

/**
 *
 * @author mdw18
 */
@WebServlet(name = "CalculationHistoryServlet", urlPatterns = {"/history-data"})
public class CalculationHistoryServlet extends HttpServlet {

    private CalculationHistory calculationHistory;

    @Override
    public void init() throws ServletException {
        //calculationHistory = new CalculationHistory();
    }


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

        response.setContentType("application/json;charset=UTF-8");

               ServletContext context = request.getServletContext();
        DataSource dataSource = (DataSource)context.getAttribute("DataSource");       
 List<CalculationData> history = dataSource.getAllCalculation();
        try (PrintWriter out = response.getWriter()) {
            out.print("[");
            for (int i = 0; i < history.size(); i++) {
                CalculationData data = history.get(i);
                out.print("{");
                out.print("\"id\": " + data.getId() + ",");
                out.print("\"firstNumber\": " + data.getFirstNumber() + ",");
                out.print("\"operator\": \"" + data.getOperator() + "\",");
                out.print("\"secondNumber\": " + data.getSecondNumber() + ",");
                out.print("\"result\": " + data.getResult());
                out.print("}");
                if (i < history.size() - 1) {
                    out.print(",");
                }
            }
            out.print("]");
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
