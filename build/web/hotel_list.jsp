
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Available Hotels</title>
     <link rel="stylesheet" type="text/css" href="css/standalone.css">
</head>
<body>
    <h2>Available Hotels</h2>

    <!-- Displaying the list of hotels -->
    <c:forEach var="hotel" items="${hotels}">
        <div>
            <h3>${hotel.name}</h3>
            <p><strong>Location:</strong> ${hotel.location}</p>
            <p><strong>Price per Night:</strong> $${hotel.pricePerNight}</p>
            <p><strong>Description:</strong> ${hotel.description}</p>
            <hr>
        </div>
    </c:forEach>

</body>
</html>
