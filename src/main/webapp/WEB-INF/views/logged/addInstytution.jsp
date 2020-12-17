<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
<%--    <link rel="stylesheet" href="<c:url value="../resources/css/style.css" />"/>--%>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj Adminie ${user.username}
                <ul class="dropdown">
                    <li><a href="#">Profil</a></li>
                    <li><a href="<c:url value="/user/form"/> ">Moje zbiórki</a></li>
                    <sec:authorize access="isAuthenticated()">
                        <li><a href="javascript: document.logoutForm.submit()">Logout</a></li>
                    </sec:authorize>

                    <form action="<c:url value="/logout"/>" method="post" hidden="hidden" name="logoutForm">
                        <input type="submit" value="logout"/>
                    </form>
                </ul>
            </li>
        </ul>

        <ul>
            <li><a href="index.html" class="btn btn--without-border active">Start</a></li>
            <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

<section class="login-page">
    <h2>Dodaj Instytucje</h2>

    <form:form modelAttribute="instytution" method="post">
        <div class="form-group">
            <form:input  path="name" type="name" name="name" placeholder="Nazwa" />
        </div>
        <div class="form-group">
            <form:input  path="description" type="description" name="description" placeholder="Opis" />
        </div>

        <div class="form-group form-group--buttons">

            <button class="btn" type="submit">Dodaj</button>
        </div>
    </form:form>


</section>





<%@ include file="../footer.jsp" %>