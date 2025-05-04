
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Available Activities</title>
    <link rel="stylesheet" type="text/css" href="css/standalone.css">
</head>
<body>

<h2>Available Activities</h2>

<!-- Display a success message if the activities were added successfully -->
<c:if test="${not empty successMessage}">
    <p style="color: green;">${successMessage}</p>
</c:if>

<!-- Check if there are any activities -->
<c:if test="${not empty activityList}">
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Name</th>
                <th>Location</th>
                <th>Price</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over the list of activities and display each activity -->
            <c:forEach var="activity" items="${activityList}">
                <tr>
                    <td>${activity.name}</td>
                    <td>${activity.location}</td>
                    <td>${activity.price}</td>
                    <td>${activity.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<!-- Display a message if no activities are available -->
<c:if test="${empty activityList}">
    <p>No activities available.</p>
</c:if>

<br/>
<a href="admin.jsp">Back to Admin Dashboard</a>

</body>
</html>
