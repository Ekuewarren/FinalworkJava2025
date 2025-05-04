

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/standalone.css">
    <link rel="stylesheet" type="text/css" href="css/standalone.css">
   </head>
<body>
    <h2>Admin Dashboard</h2>

    <!-- Feedback messages -->
    <c:if test="${param.success eq 'true'}">
        <div style="color: green;">✅ Car added successfully!</div>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">❌ ${errorMessage}</div>
    </c:if>

    <% String context = request.getContextPath(); %>
    <ul>
        <li><a href="<%= context %>/addHotel.jsp">Add Hotel</a></li>
        <li><a href="<%= context %>/addCar.jsp">Add Car</a></li>
        <li><a href="<%= context %>/addActivity.jsp">Add Activity</a></li>
        <li><a href="<%= context %>/viewBookings.jsp">View All Bookings</a></li>
        <li><a href="<%= context %>/manageUsers.jsp">Manage Users</a></li>
    </ul>
</body>
</html>
