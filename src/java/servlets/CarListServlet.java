package servlets;

import db.DBConnection;
import model.Car;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/cars")
public class CarListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Car> carList = new ArrayList<>();

        // Using try-with-resources to ensure closing of resources
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM cars"; // Your SELECT query
            try (PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                
                // Loop through result set and create Car objects
                while (rs.next()) {
                    Car car = new Car(
                            rs.getInt("id"),
                            rs.getString("model"),
                            rs.getString("company"),
                            rs.getDouble("price"),  // Using 'price' as per updated database column name
                            rs.getString("description")
                    );
                    carList.add(car);  // Adding to the list
                }
            }

        } catch (SQLException e) {
            // Log the exception and show an error message in the JSP
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error retrieving car list: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // Set car list attribute to be used in the JSP
        request.setAttribute("carList", carList);

        // Forward the request to the JSP page for displaying the cars
        request.getRequestDispatcher("cars.jsp").forward(request, response);
    }
}
