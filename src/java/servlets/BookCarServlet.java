



package servlets;

import db.DBConnection;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/bookCar")
public class BookCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        int userId = user.getId();

        String carIdParam = request.getParameter("carId");

        if (carIdParam == null || carIdParam.isEmpty()) {
            response.getWriter().println("❌ Car ID is missing.");
            return;
        }

        try {
            int carId = Integer.parseInt(carIdParam);

            try (Connection conn = DBConnection.getConnection()) {
                String sql = "INSERT INTO bookings (user_id, car_id, booking_date) VALUES (?, ?, NOW())";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, userId);
                    stmt.setInt(2, carId);
                    stmt.executeUpdate();
                }
                // Optionally: add success message in session
                response.sendRedirect("dashboard.jsp");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("❌ Invalid Car ID format.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("❌ Database error while booking car.");
        }
    }
}
