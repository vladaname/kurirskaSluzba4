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
<%--        <td>id osobe</td>--%>
        <td>opis</td>
        <td>cena otkupa</td>
        <td>tezina</td>

    </tr>
        <c:forEach var="posiljka" items="${listaPosiljki}">
    <tr>
<%--        <td>${posiljka.idOsobe}</td>--%>
        <td>${posiljka.opis}</td>
        <td>${posiljka.cenaOtkupa}</td>
        <td>${posiljka.tezina}</td>
    </tr>

        </c:forEach>
</table>
</body>
</html>