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


<%--@elvariable id="osobaDTO" type=""--%>
<form:form method="post" action="/login"
           modelAttribute="osobaDTO">
    <input type="text" name="username" placeholder="username">
    <input type="text" name="pass" placeholder="pass">

    <input type="submit" value="Log In">


</form:form>

</body>
</html>