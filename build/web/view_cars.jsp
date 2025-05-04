
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Available Rental Cars</title>
    <link rel="stylesheet" type="text/css" href="css/standalone.css">
    
</head>
<body>
    <h2>Available Rental Cars</h2>

    <c:if test="${not empty cars}">
        <table border="1" cellpadding="10">
            <tr>
                <th>Model</th>
                <th>Company</th>
                <th>Price Per Day</th>
                <th>Description</th>
            </tr>
            <c:forEach var="car" items="${cars}">
                <tr>
                    <td>${car.model}</td>
                    <td>${car.company}</td>
                    <td>${car.pricePerDay}</td>
                    <td>${car.description}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty cars}">
        <p>No cars available.</p>
    </c:if>

    <br/>
    <a href="user_home.jsp">Back to Dashboard</a>
</body>
</html>
