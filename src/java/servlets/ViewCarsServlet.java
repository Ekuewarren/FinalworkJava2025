package servlets;

import model.Car;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/ViewCarsServlet")
public class ViewCarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/vacation_planner";  // Replace with your DB URL
        String user = "root";      // Replace with your DB username
        String password = "Ekuewarren";  // Replace with your DB password

        List<Car> carList = new ArrayList<>();
        String query = "SELECT * FROM cars";  // Make sure the table is named 'cars'

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Now using 'price_per_day' as the column name
                Car car = new Car(
                    rs.getInt("id"),
                    rs.getString("model"),
                    rs.getString("company"),
                    rs.getDouble("price_per_day"),  // Correct column name for price
                    rs.getString("description")
                );
                carList.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set the car list as an attribute and forward the request to the JSP
        request.setAttribute("cars", carList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_cars.jsp");
        dispatcher.forward(request, response);
    }
}
