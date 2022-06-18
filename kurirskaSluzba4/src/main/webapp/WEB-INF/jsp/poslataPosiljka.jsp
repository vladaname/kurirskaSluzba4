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
<h2>Vasa posiljka je poslata!</h2><br>
<h3>Bice dostavljena u roku od 5 radnih dana.</h3>
<p>Za informacije o posiljci mozete nas kontaktirati na telefon 021/555 444.</p><br>
<p>Posiljku mozete pratiti preko sifre:</p> ${sifraPosiljke}
<p>Ukupna cena:</p> ${ukupanRacun}


</body>
</html>