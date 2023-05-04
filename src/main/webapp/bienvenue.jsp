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
<title>Document</title>
</head>
<body>
<h2>${titre}</h2>
<h3>
<fmt:bundle basename="message">
<fmt message key="msg"/>
</fmt:bundle>
</h3>
<p>
<fmt:formatDate value="${date}" type="date" pattern="dd MMM YYYY"/>
</p>
<p><h5>${personne.fullName()}</h5></p>
</body>
</html>
