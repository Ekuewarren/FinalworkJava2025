
package servlets;

import model.User;
import model.UserDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manageUsers")
public class ManageUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch the list of users from the database
        List<User> userList = UserDAO.getAllUsers();

        // Set the user list in the request scope for the JSP to use
        request.setAttribute("userList", userList);

        // Forward to manageUsers.jsp to render the list of users
        request.getRequestDispatcher("manageUsers.jsp").forward(request, response);
    }
}
