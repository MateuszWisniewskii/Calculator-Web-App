/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.calculator.servlet;

import jakarta.servlet.http.HttpServlet;
import pl.polsl.calculator.model.CalculationHistory;
import pl.polsl.calculator.model.DataSource;

/**
 *
 * @author mdw18
 */
public class CalculatorInitializotionServlet extends HttpServlet {
    @Override
    public void init() {
        
        var context = getServletContext();        
        DataSource dataSource = (DataSource)context.getAttribute("DataSource");
        if(dataSource == null) {
            context.setAttribute("DataSource", new CalculationHistory());
        }
        
    }  
}
