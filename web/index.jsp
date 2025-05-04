

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Vacation Planner-Home</title>
     <link rel="stylesheet" type="text/css" href="css/standalone.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/standalone.css">
    <style>
        
        h1{
           color: red;
            }
            body{
                background-color:lightskyblue;
            }
            .menu {
    background-color: #ffffff;
    border: 2px solid #ccc;
    padding: 20px;
    width: fit-content;
    margin: 50px auto;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
}

.menu a {
    display: block;
    margin: 10px 0;
    padding: 12px 20px;
    background-color: #007bff;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    font-weight: bold;
    transition: background-color 0.3s;
}
            
            
            
    </style>
   
</head>
<body>

    <h1>Welcome to Vacation Planner</h1>
    <p>Plan your dream vacation: book hotels, rent cars, and schedule exciting activities!</p>

    <div class="menu">
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
        <a href="cars">Browse Cars</a>
        <a href="activities">Browse Activities</a>
        <a href="admin.jsp">Admin Dashboard</a>
    </div>

</body>
</html>
