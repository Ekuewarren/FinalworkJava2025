
package servlets;

import model.Booking;
import db.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;







@WebServlet("/bookings")
public class BookingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        List<Booking> bookings = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {

            String sql = """
                SELECT b.id, u.username, 
                       COALESCE(h.name, c.model, a.name) AS item_name,
                       CASE 
                           WHEN b.hotel_id IS NOT NULL THEN 'Hotel'
                           WHEN b.car_id IS NOT NULL THEN 'Car'
                           WHEN b.activity_id IS NOT NULL THEN 'Activity'
                           ELSE 'Unknown'
                       END AS type,
                       b.booking_date
                FROM bookings b
                JOIN users u ON b.user_id = u.id
                LEFT JOIN hotels h ON b.hotel_id = h.id
                LEFT JOIN cars c ON b.car_id = c.id
                LEFT JOIN activities a ON b.activity_id = a.id
                ORDER BY b.booking_date DESC
            """;

            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Booking b = new Booking(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("type"),
                        rs.getString("item_name"),
                        rs.getString("booking_date")
                    );
                    bookings.add(b);
                }
            }

            request.setAttribute("bookings", bookings);
            request.getRequestDispatcher("viewBookings.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/plain");
            response.getWriter().println("Error loading bookings: " + e.getMessage());
        }
    }
}
