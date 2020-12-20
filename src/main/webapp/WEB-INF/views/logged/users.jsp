<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="adminHeader.jsp" %>


<!-- SLIDE 1 -->
<div class="help--slides active" data-id="1">


    <ul class="help--slides-items">
        <center><a href="<c:url value="/admin/addUser" />">
            <button type="button" style="margin-left: 80%;" class="btn">Dodaj Urzytkownika</button>
        </a></center>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>


        <c:forEach items="${users}" var="a">

        <li>
            <div class="col">
                <div class="title">
                    <a href="<c:url value="/admin/editUser/${a.id}"/>">
                        <button type="button" class="btn">Edytuj</button>
                    </a>
                    <a href="<c:url value="/admin/deleteUser/${a.id}"/>">
                        <button type="button" class="btn"
                                onClick="if(confirm('Czy na pewno chcesz usunąć urzytkownika?')==false) return false;">
                            Usuń
                        </button>
                    </a>

                      ${a.username}


                </div>


            </div>


            </c:forEach>


    </ul>


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

</div>


</section>


</header>

</body>
</html>
