
package servlets;

import db.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddActivityServlet")
public class AddActivityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the parameters from the form
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        // Establish a connection to the database
        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to insert a new activity into the database
            String sql = "INSERT INTO activities (name, location, price, description) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, location);
            stmt.setDouble(3, price);
            stmt.setString(4, description);
            
            // Execute the query
            stmt.executeUpdate();
            
            // Redirect to the activities page with a success message
            response.sendRedirect("activities?success=true");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle errors and optionally forward to an error page
            request.setAttribute("errorMessage", "Error adding activity: " + e.getMessage());
            request.getRequestDispatcher("addActivity.jsp").forward(request, response);
        }
    }
}
