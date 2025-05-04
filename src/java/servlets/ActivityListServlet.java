

package servlets;

import db.DBConnection;
import model.Activity;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/activities")
public class ActivityListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Activity> activityList = new ArrayList<>();

        // Use try-with-resources to automatically close the connection, statement, and result set
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM activities")) {

            while (rs.next()) {
                Activity activity = new Activity(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("location"),
                    rs.getDouble("price"),
                    rs.getString("description")
                );
                activityList.add(activity);
            }
        } catch (SQLException e) {
            // Log the error (for better debugging and monitoring)
            e.printStackTrace(); 
            request.setAttribute("errorMessage", "Error retrieving activities. Please try again later.");
        }

        // Set the list of activities as an attribute for the JSP page
        request.setAttribute("activityList", activityList);

        // Forward to the JSP page for rendering
        request.getRequestDispatcher("activities.jsp").forward(request, response);
    }
}
