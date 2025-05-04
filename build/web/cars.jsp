
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Available Cars</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/standalone.css">
     <link rel="stylesheet" type="text/css" href="css/standalone.css">
</head>
<body>
    <div class="container">
        <h2>🚗 Available Rental Cars</h2>

        <!-- Display error message if any -->
        <c:if test="${not empty errorMessage}">
            <div class="error">❌ ${errorMessage}</div>
        </c:if>

        <!-- Display success message if any -->
        <c:if test="${not empty successMessage}">
            <div class="success">✅ ${successMessage}</div>
        </c:if>

        <!-- Display a message if no cars are available -->
        <c:if test="${empty carList}">
            <p>No cars available at the moment.</p>
        </c:if>

        <!-- Loop through the list of cars and display them -->
        <c:forEach var="car" items="${carList}">
            <div class="car-box">
                <h3>${car.model} - ${car.company}</h3>
                <p><strong>Price per day:</strong> $${car.price}</p>
                <p>${car.description}</p>

                <form method="post" action="bookCar">
                    <input type="hidden" name="carId" value="${car.id}" />
                    <input type="submit" class="button" value="Book This Car" />
                </form>
            </div>
        </c:forEach>

        <a class="back-link" href="dashboard.jsp">⬅ Back to Dashboard</a>
    </div>
</body>
</html>
