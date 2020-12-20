<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="adminHeader.jsp" %>


<!-- SLIDE 1 -->
<div class="help--slides active" data-id="1">


    <ul class="help--slides-items">
        <center><a href="<c:url value="/admin/addAdmin" />">
            <button type="button" style="margin-left: 80%;" class="btn">Dodaj admina</button>
        </a></center>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>


        <c:forEach items="${admins}" var="a">

        <li>
            <div class="col">
                <div class="title">
                    <a href="<c:url value="/admin/editAdmin/${a.id}"/>">
                        <button type="button" class="btn">Edytuj</button>
                    </a>
                    <a href="<c:url value="/admin/deleteAdmin/${a.id}"/>">
                        <button type="button" class="btn"
                                onClick="if(confirm('Czy na pewno chcesz usunąć admina?')==false) return false;">
                            Usuń
                        </button>
                    </a>
                    &nbsp;&nbsp;&nbsp; Admin "${a.username}"
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
