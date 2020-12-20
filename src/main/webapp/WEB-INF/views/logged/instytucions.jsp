<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="adminHeader.jsp" %>


        <!-- SLIDE 1 -->
        <div class="help--slides active" data-id="1">




            <ul class="help--slides-items">
              <center> <a href="<c:url value="/admin/addInstytution" />"><button type="button" style="margin-left: 80%;" class="btn">Dodaj instytucje</button></a></center>

                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>


            <c:forEach items="${institutions}" var="i">

                    <li>
                    <div class="col">
                        <div class="title">
                           <a href="<c:url value="/admin/editInstytution/${i.id}"/>"><button type="button" class="btn" >Edytuj</button></a>
                            <a href="<c:url value="/admin/deleteInstytution/${i.id}"/>" ><button type="button" class="btn" onClick="if(confirm('Czy na pewno chcesz usunąć instytucje?')==false) return false;">Usuń</button></a>
                            &nbsp;&nbsp;&nbsp; Fundacja "${i.name}"</div>
                        <div class="subtitle">${i.description}</div>
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
