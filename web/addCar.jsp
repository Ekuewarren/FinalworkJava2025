
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Car</title>
    <link rel="stylesheet" type="text/css" href="css/standalone.css">
    
</head>
<body>
    <h2>Add New Car</h2>

    <!-- Display any error or success messages -->
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">❌ ${errorMessage}</div>
    </c:if>
    <c:if test="${param.success eq 'true'}">
        <div style="color: green;">✅ Car added successfully!</div>
    </c:if>

    <form action="AddCarServlet" method="post">
        <label for="model">Model:</label><br/>
        <input type="text" id="model" name="model" required /><br/><br/>

        <label for="company">Company:</label><br/>
        <input type="text" id="company" name="company" required /><br/><br/>

        <label for="price">Price:</label><br/>
        <input type="number" step="0.01" id="price" name="price" required /><br/><br/>

        <label for="description">Description:</label><br/>
        <textarea id="description" name="description" rows="4" cols="50"></textarea><br/><br/>

        <input type="submit" value="Add Car" />
    </form>

    <br/>
    <a href="admin.jsp">← Back to Admin Dashboard</a>
</body>
</html>


