<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

    </nav>



    <section class="help">
        <br>
        <br>
        <br>
        <br>
        <div class="slogan--item">

            <div class="slogan--steps">

                <ul class="slogan--steps-boxes1">
                    <a href="<c:url value="/admin/adminDashboard" />" >
                        <li class="boxeshover">
                            <div><em>1</em><span>Profil</span></div>
                        </li>
                    </a>
                    <a href="<c:url value="/admin/instytutions" />" >
                        <li class="boxeshover">
                            <div><em>2</em><span>Instytucje</span></div>
                        </li>
                    </a>
                    <a href="<c:url value="/admin/admins" />" >
                        <li class="boxeshover">
                            <div><em>3</em><span>Admini</span></div>
                        </li>
                    </a>
                    <a href="<c:url value="/admin/users" />" >
                    <li class="boxeshover">
                        <div><em>4</em><span>Urzytkownicy</span></div>
                    </li>
                    </a>
                </ul>
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
