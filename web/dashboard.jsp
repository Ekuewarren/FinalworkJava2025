
<%@ page contentType="text/html;charset=UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" type="text/css" href="css/standalone.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">

<c:if test="${not empty user}">
    <h1 class="mb-4">Welcome <strong>${user.username}</strong>!</h1>

    <!-- 🔽 Navigation Links -->
    <div class="d-flex flex-wrap gap-2 mb-4">
        <a href="register.jsp" class="btn btn-primary">Register</a>
        <a href="login.jsp" class="btn btn-primary">Login</a>
        <a href="cars.jsp" class="btn btn-primary">Browse Cars</a>
        <a href="activities.jsp" class="btn btn-primary">Browse Activities</a>
        <a href="admin.jsp" class="btn btn-primary">Admin Dashboard</a>
    </div>

    <h3>Your Latest Bookings:</h3>

    <c:if test="${not empty bookings}">
        <table class="table table-bordered table-striped mt-3">
            <thead>
                <tr>
                    <th>Type</th>
                    <th>Item</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="booking" items="${bookings}">
                    <tr>
                        <td>${booking.type}</td>
                        <td>${booking.itemName}</td>
                        <td>${booking.date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty bookings}">
        <div class="alert alert-info mt-3">You have no bookings yet.</div>
    </c:if>

    <a href="logout.jsp" class="btn btn-danger mt-4">Logout</a>
</c:if>

<c:if test="${empty user}">
    <div class="alert alert-danger">You are not logged in. <a href="login.jsp">Login here</a>.</div>
</c:if>

</body>
</html>
