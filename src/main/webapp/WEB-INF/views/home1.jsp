<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<c:forEach var="al" items="${al}" varStatus="status">
        <tr>
            <td><c:out value="${al.name}"/></td>
            <td><c:out value="${al.open}"/></td>
            <td><c:out value="${al.high}"/></td>
        </tr>   
    </c:forEach>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
