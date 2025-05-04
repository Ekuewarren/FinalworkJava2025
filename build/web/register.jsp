



<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/standalone.css">
    <link rel="stylesheet" type="text/css" href="css/standalone.css">
</head>
<body>
    <h2>Register</h2>
    
    <form method="post" action="register">
        Username: <input type="text" name="username" required /><br/>
        Password: <input type="password" name="password" required /><br/>
        Confirm Password: <input type="password" name="confirm_password" required /><br/>
        Email: <input type="email" name="email" required /><br/>
        <input type="submit" value="Register" />
    </form>
    
    <!-- Display error messages if any -->
    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>
    
</body>
</html>
