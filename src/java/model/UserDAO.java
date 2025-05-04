
package model;

import java.sql.*;
import java.util.*;

public class UserDAO {

    // Database connection details (change as per your setup)
    private static final String DB_URL = "jdbc:mysql://localhost:3307/vacation_planner";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Ekuewarren";

    // Method to fetch all users from the database
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            // Step 1: Establish connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Step 2: Create statement and execute query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, username, email FROM users");

            // Step 3: Iterate through the result set and populate the list
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }

            // Step 4: Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}

