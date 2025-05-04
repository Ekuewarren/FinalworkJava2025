
package servlets;

import db.DBConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form parameters
        String model = request.getParameter("model");
        String company = request.getParameter("company");
        String priceStr = request.getParameter("price");
        String description = request.getParameter("description");

        try {
            double price = Double.parseDouble(priceStr); // Convert to double

            // Insert into database using updated column name 'price'
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO cars (model, company, price, description) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, model);
            stmt.setString(2, company);
            stmt.setDouble(3, price);
            stmt.setString(4, description);
            stmt.executeUpdate();

            // Redirect to form with success message
            response.sendRedirect("addCar.jsp?success=true");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error adding car: " + e.getMessage());
            request.getRequestDispatcher("addCar.jsp").forward(request, response);
        }
    }
}
