
package servlets;

import db.DBConnection;
import model.Hotel;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/ViewHotelServlet")
public class ViewHotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // List to store the hotels
        List<Hotel> hotelList = new ArrayList<>();

        // Query to fetch all hotels
        String query = "SELECT * FROM hotels";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Create a new Hotel object for each row and add it to the list
                Hotel hotel = new Hotel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getDouble("price_per_night"),
                        rs.getString("description")
                );
                hotelList.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle the exception properly
        }

        // Set the list of hotels as a request attribute
        request.setAttribute("hotelList", hotelList);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/viewHotel.jsp").forward(request, response);
    }
}
