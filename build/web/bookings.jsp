
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Bookings</title>
    <link rel="stylesheet" type="text/css" href="css/standalone.css">
    </head>
<body>
    <h2>All Bookings</h2>

    <c:choose>
        <c:when test="${not empty bookings}">
            <table>
                <tr>
                    <th>Username</th>
                    <th>Type</th>
                    <th>Item Name</th>
                    <th>Date</th>
                </tr>
                <c:forEach var="booking" items="${bookings}">
                    <tr>
                        <td>${booking.username}</td>
                        <td>${booking.type}</td>
                        <td>${booking.itemName}</td>
                        <td>${booking.date}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p style="text-align:center;">No bookings found.</p>
        </c:otherwise>
    </c:choose>

    <div style="text-align:center; margin-top: 20px;">
        <a href="admin.jsp">Back to Admin Dashboard</a>
    </div>
</body>
</html>
