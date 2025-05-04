

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" type="text/css" href="css/standalone.css">
    </head>
    <body>
      <h2>Available Hotels</h2>
<c:forEach var="hotel" items="${hotels}">
    <div>
        <h3>${hotel.name}</h3>
        <p>${hotel.location}</p>
        <p>${hotel.pricePerNight}</p>
        <p>${hotel.description}</p>
    </div>
</c:forEach>  
        
        
        
        
        
        
        
    </body>
</html>
