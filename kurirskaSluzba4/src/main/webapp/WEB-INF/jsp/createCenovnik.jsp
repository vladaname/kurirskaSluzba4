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

<h1>Kreiranje cenovnika</h1>

<%--@elvariable id="cenovnikDTO" type=""--%>
<form:form method="post" action="/createCenovnik"
           modelAttribute="cenovnikDTO">
    <table>
        <tr>
            <td><form:label path="cenaDo5kg">cenaDo5kg</form:label></td>
            <td><form:input path="cenaDo5kg" /></td>
        </tr>
        <tr>
            <td><form:label path="cenaOd5do10kg">cenaOd5do10kg</form:label></td>
            <td><form:input path="cenaOd5do10kg" /></td>
        </tr>
        <tr>
            <td><form:label path="cenaPreko10kg">cenaPreko10kg</form:label></td>
            <td><form:input path="cenaPreko10kg" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>


</form:form>

</body>
</html>