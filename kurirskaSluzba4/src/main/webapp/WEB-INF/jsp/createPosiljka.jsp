<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
Poruka:${poruka}


<%--@elvariable id="posiljkaDTO" type=""--%>
<form:form method="post" action="/createPosiljka"
           modelAttribute="posiljkaDTO">
    <table>
        <tr>
            <td><form:label path="cenaKm">cenaKm</form:label></td>
            <td><form:input path="cenaKm" /></td>
        </tr>
        <tr>
            <td><form:label path="cenaOtkupa">cenaOtkupa</form:label></td>
            <td><form:input path="cenaOtkupa" /></td>
        </tr>
        <tr>
            <td><form:label path="opis">opis</form:label></td>
            <td><form:input path="opis" /></td>
        </tr>
        <tr>
            <td><form:label path="sifraPosiljke">sifraPosiljke</form:label></td>
            <td><form:input path="sifraPosiljke" /></td>
        </tr>
        <tr>
            <td><form:label path="statusPosiljke">statusPosiljke</form:label></td>
            <td><form:input path="statusPosiljke" /></td>
        </tr>
        <tr>
            <td><form:label path="tezina">tezina</form:label></td>
            <td><form:input path="tezina" /></td>
        </tr>
        <tr>
            <td><form:label path="vremeSlanja">vremeSlanja</form:label></td>
            <td><form:input path="vremeSlanja" /></td>
        </tr>
        <tr>
            <td><form:label path="vremeDostave">vremeDostave</form:label></td>
            <td><form:input path="vremeDostave" /></td>
        </tr>
        <tr>

            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>

</form:form>

</body>
</html>