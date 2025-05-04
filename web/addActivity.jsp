
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Activity</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/standalone.css">
<link rel="stylesheet" type="text/css" href="css/standalone.css">
</head>
<body>
    <h2>Add New Activity</h2>
    <form action="AddActivityServlet" method="post">
        <label>Name:</label><br/>
        <input type="text" name="name" required/><br/><br/>

        <label>Location:</label><br/>
        <input type="text" name="location" required/><br/><br/>

        <label>Price:</label><br/>
        <input type="number" step="0.01" name="price" required/><br/><br/>

        <label>Description:</label><br/>
        <textarea name="description" rows="4" cols="40"></textarea><br/><br/>

        <input type="submit" value="Add Activity"/>
    </form>
</body>
</html>
