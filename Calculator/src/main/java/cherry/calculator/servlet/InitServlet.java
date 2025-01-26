/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cherry.calculator.servlet;

import jakarta.servlet.http.HttpServlet;
import cherry.calculator.model.DataSource;
import cherry.calculator.model.History;

/**
 *
 * @author mdw18
 */
public class InitServlet extends HttpServlet {

    @Override
    public void init() {

        var context = getServletContext();
        DataSource dataSource = (DataSource) context.getAttribute("DataSource");
        if (dataSource == null) {
            context.setAttribute("DataSource", new History());
        }

    }
}
