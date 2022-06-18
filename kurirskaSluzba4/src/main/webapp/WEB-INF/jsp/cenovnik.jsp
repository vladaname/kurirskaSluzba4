<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
${poruka}
<table>
    <tr>
        <td>cenaDo5kg</td>
        <td>cenaOd5do10kg</td>
        <td>cenaPreko10kg</td>

    </tr>
<%--    <c:forEach var="cenovnik" items="${cenovnikLista}">--%>
        <tr>
            <td>${cenovnik.cenaDo5kg}</td>
            <td>${cenovnik.cenaOd5do10kg}</td>
            <td>${cenovnik.cenaPreko10kg}</td>

        </tr>

<%--    </c:forEach>--%>
</table>
</body>
</html>