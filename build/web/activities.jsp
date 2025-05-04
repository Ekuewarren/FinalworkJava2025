
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Activities</title>
    <link rel="stylesheet" type="text/css" href="css/standalone.css">
</head>
<body>
    <h2>Available Activities</h2>

    <c:if test="${not empty activityList}">
        <c:forEach var="activity" items="${activityList}">
            <div style="border:1px solid #ccc; padding:10px; margin:10px;">
                <h3>${activity.name}</h3>
                <p>Location: ${activity.location}</p>
                <p>Price: <fmt:formatNumber value="${activity.price}" type="currency" /></p>
                <p>${activity.description}</p>
            </div>
        </c:forEach>
    </c:if>

    <c:if test="${empty activityList}">
        <p>No activities available at the moment.</p>
    </c:if>
</body>
</html>
