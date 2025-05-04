
package servlets;

import db.DBConnection;
import model.Hotel;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/hotels")
public class HotelListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // List to store hotels
        List<Hotel> hotelList = new ArrayList<>();

        // Query to fetch all hotels
        String query = "SELECT * FROM hotels";

        // Use DBConnection utility class to get connection
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Iterate through the result set and create Hotel objects
            while (rs.next()) {
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
            // Log the error and provide feedback to the user
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error fetching hotel data from database.");
        }

        // Set the list of hotels as a request attribute
        request.setAttribute("hotels", hotelList);

        // Forward to the JSP page to display the hotels
        request.getRequestDispatcher("/hotel_list.jsp").forward(request, response);
    }
}
