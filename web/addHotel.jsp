

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Hotel</title>

</head>
<body>
    <h2>Add New Hotel</h2>
    
    <!-- Display any error or success messages -->
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">❌ ${errorMessage}</div>
    </c:if>
    <c:if test="${param.success eq 'true'}">
        <div style="color: green;">✅ Hotel added successfully!</div>
    </c:if>

    <form action="AddHotelServlet" method="post">
        <label for="name">Name:</label><br/>
        <input type="text" id="name" name="name" required><br/><br/>

        <label for="location">Location:</label><br/>
        <input type="text" id="location" name="location" required><br/><br/>

        <label for="price">Price Per Night:</label><br/>
        <input type="number" id="price" name="price" step="0.01" required><br/><br/>

        <label for="description">Description:</label><br/>
        <textarea id="description" name="description" rows="4" cols="50"></textarea><br/><br/>

        <input type="submit" value="Add Hotel">
    </form>

    <br/>
    <a href="admin.jsp">Back to Admin Dashboard</a>
</body>
</html>
