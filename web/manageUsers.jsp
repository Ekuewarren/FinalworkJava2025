
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vacation Planner - Manage Users</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

    <h1>User Management</h1>
    <p>Manage registered users: edit user info or remove accounts.</p>

    <c:if test="${not empty userList}">
        <table>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td class="actions">
                        <a href="editUser?id=${user.id}">Edit</a>
                        <a href="deleteUser?id=${user.id}" onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty userList}">
        <p class="no-users">No users found.</p>
    </c:if>

    <div class="menu">
        <a href="admin.jsp">Admin Dashboard</a><br>
        <a href="index.jsp">Home</a>
    </div>

</body>
</html>

