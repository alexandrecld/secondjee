<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport"
content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Liste Personne</title>
</head>
<body>
<table>
<tr>
<th>Nom</th>
<th>Prenom</th>
</tr>
<c:forEach items="${personnes}" var="p">
<tr>
<td>${p.nom}</td>
<td>${p.prenom}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
