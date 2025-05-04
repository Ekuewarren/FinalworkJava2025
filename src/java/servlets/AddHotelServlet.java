
package servlets;

import db.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddHotelServlet")
public class AddHotelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String location = request.getParameter("location");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        boolean isSuccess = false; // To track if the operation is successful

        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to insert a new hotel record
            String sql = "INSERT INTO hotels (name, location, price_per_night, description) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, location);
            stmt.setDouble(3, price);
            stmt.setString(4, description);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error adding hotel: " + e.getMessage());
        }

        // If the operation was successful, redirect with a success message; otherwise, show the error message
        if (isSuccess) {
            response.sendRedirect("hotels?success=true");
        } else {
            request.setAttribute("errorMessage", "Failed to add hotel. Please try again.");
            request.getRequestDispatcher("/addHotel.jsp").forward(request, response);
        }
    }
}
