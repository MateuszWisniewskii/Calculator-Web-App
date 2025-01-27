package cherry.calculator.servlet;

import jakarta.servlet.http.HttpServlet;
import cherry.calculator.model.DataSource;
import cherry.calculator.model.History;

/**
 * Servlet responsible for initializing the application context.
 * Ensures that a {@link DataSource} is available in the servlet context during the application's lifecycle.
 * If no {@code DataSource} is found, a default implementation ({@link History}) is provided.
 * 
 * @author Mateusz Wiśniewski
 */
public class InitServlet extends HttpServlet {

    /**
     * Initializes the servlet by setting up a {@link DataSource} in the servlet context.
     * If a {@code DataSource} attribute is not already present in the servlet context, 
     * it creates a new {@link History} object and assigns it as the default data source.
     */
    @Override
    public void init() {
        // Retrieve the servlet context
        var context = getServletContext();

        // Check if a DataSource is already present in the context
        DataSource dataSource = (DataSource) context.getAttribute("DataSource");

        // If no DataSource is found, create a new History object and set it as the DataSource
        if (dataSource == null) {
            context.setAttribute("DataSource", new History());
        }
    }
}
