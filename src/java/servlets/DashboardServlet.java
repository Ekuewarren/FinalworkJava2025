

package servlets;

import db.DBConnection;
import model.Booking;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        List<Booking> bookings = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = 
                "SELECT b.booking_date, c.model AS item_name, 'Car' AS type " +
                "FROM bookings b JOIN cars c ON b.car_id = c.id WHERE b.user_id = ? AND b.car_id IS NOT NULL " +
                "UNION " +
                "SELECT b.booking_date, h.name AS item_name, 'Hotel' AS type " +
                "FROM bookings b JOIN hotels h ON b.hotel_id = h.id WHERE b.user_id = ? AND b.hotel_id IS NOT NULL " +
                "UNION " +
                "SELECT b.booking_date, a.name AS item_name, 'Activity' AS type " +
                "FROM bookings b JOIN activities a ON b.activity_id = a.id WHERE b.user_id = ? AND b.activity_id IS NOT NULL " +
                "ORDER BY booking_date DESC";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.setInt(2, user.getId());
            stmt.setInt(3, user.getId());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setType(rs.getString("type"));
                booking.setItemName(rs.getString("item_name"));
                booking.setDate(rs.getString("booking_date"));
                bookings.add(booking);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to load bookings.");
        }

        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
