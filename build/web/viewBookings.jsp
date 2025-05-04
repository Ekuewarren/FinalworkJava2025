
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Booking" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Bookings</title>
    <link rel="stylesheet" type="text/css" href="css/standalone.css">
</head>
<body>
    <h2>All Bookings</h2>

    <%
        List<Booking> bookingList = (List<Booking>) request.getAttribute("bookings");
        if (bookingList == null || bookingList.isEmpty()) {
    %>
        <p>No bookings found.</p>
    <%
        } else {
    %>
        <table border="1" cellpadding="10">
            <tr>
                <th>Booking ID</th>
                <th>User</th>
                <th>Type</th>
                <th>Item</th>
                <th>Date</th>
            </tr>
            <%
                for (Booking b : bookingList) {
            %>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getUsername() %></td>
                <td><%= b.getType() %></td>
                <td><%= b.getItemName() %></td>
                <td><%= b.getDate() %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>

    <br/>
    <a href="admin.jsp">Back to Admin Dashboard</a>
</body>
</html>
