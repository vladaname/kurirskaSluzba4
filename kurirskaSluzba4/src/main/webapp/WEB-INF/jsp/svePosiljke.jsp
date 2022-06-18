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
        <td>opis</td>
        <td>cena otkupa</td>
        <td>tezina</td>
        <td>status</td>


    </tr>
    <c:forEach var="posiljka" items="${svePosiljke}">
        <tr>
            <td>${posiljka.opis}</td>
            <td>${posiljka.cenaOtkupa}</td>
            <td>${posiljka.tezina}</td>
            <td>${posiljka.statusPosiljke}</td>
        </tr>
        <tr>
            <%--@elvariable id="promeniStatusDTO" type=""--%>
            <form:form method="post" action="/promeniStatus" modelAttribute="promeniStatusDTO">
                <td><input type="hidden" name="idPosiljka" value="${posiljka.idPosiljka}"></td>
                <td><input type="submit" value="promeniStatus"></td>


            </form:form>
        </tr>

    </c:forEach>
</table>
</body>
</html>