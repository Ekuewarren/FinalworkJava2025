
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Available Hotels</title>
    <link rel="stylesheet" type="text/css" href="css/standalone.css">
</head>    
    
       
    
<body>
    <h2>Available Hotels</h2>

    <!-- If there are hotels, display them in a table -->
    <c:if test="${not empty hotels}">
        <table border="1" cellpadding="10">
            <tr>
                <th>Hotel Name</th>
                <th>Location</th>
                <th>Price Per Night</th>
                <th>Description</th>
            </tr>
            <!-- Loop through the hotels list -->
            <c:forEach var="hotel" items="${hotels}">
                <tr>
                    <td>${hotel.name}</td>
                    <td>${hotel.location}</td>
                    <td>${hotel.pricePerNight}</td>
                    <td>${hotel.description}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <!-- If there are no hotels, display a message -->
    <c:if test="${empty hotels}">
        <p>No hotels available.</p>
    </c:if>

    <br/>
    <a href="user_home.jsp">Back to Dashboard</a>
</body>
</html>
