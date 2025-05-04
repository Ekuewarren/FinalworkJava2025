
package servlets;

import model.Booking;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/viewBookings")
public class ViewBookingsServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vacation_planner";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Ekuewarren";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Booking> bookingList = new ArrayList<>();
        String query = "SELECT id, username, type, item_name, booking_date FROM bookings";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("type"),
                        rs.getString("item_name"),
                        rs.getString("booking_date")
                );
                bookingList.add(booking);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
        }

        request.setAttribute("bookings", bookingList);
        request.getRequestDispatcher("viewBookings.jsp").forward(request, response);
    }
}
