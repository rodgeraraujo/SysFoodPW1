<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 13/10/2018
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="./assets/css/bootstrap.min.css" type="text/css">
        <script src="./assets/js/jquery-3.2.0.min.js.download"></script>
        <script src="./assets/js/bootstrap.min.js.download"></script>
        <%--<link rel="stylesheet" href="./assets/css/font-awesome.min.css">--%>
        <link href="https://socialyte.codeplus.it/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./assets/css/bootstrap-switch.min.css">
        <script src="./assets/js/bootstrap-switch.min.js"></script>
        <script src="./assets/js/twemoji.min.js"></script>
        <script src="./assets/js/lazy-load.min.js"></script>
        <script src="./assets/js/socialyte.min.js"></script>
        <link href="./assets/css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,600,700" rel="stylesheet">
        <link rel="stylesheet" href="./assets/css/style.css" type="text/css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    </head>
    <body>
        <!--Header with Nav -->
        <jsp:include page="/navbar.jsp"/>

        <br> <b> <br> <br> <br>
        <p style="width:40%; margin-left: 10%;">A pesquisa por "<i id="resultado">${requestScope.pesquisa}</i>"  retornou  o(s)  seguinte(s)  valor(es):</p>
            <br>

        <c:forEach var="usuarios" items="${sessionScope.usuarios}">
            <div class="card-post" style="width:40%; margin-left: 10%;">
                <div class="row">
                    <div class="col-xs-3 col-sm-2">
                        <a href="/visited/profile.jsp?id=<c:out value="${usuarios.id}"/>" title="Profile">
                            <img src="<c:out value="${usuarios.fotoPerfil}"/>"  alt="User name" class="img-circle img-user-post">
                        </a>
                    </div>
                    <div class="col-xs-9 col-sm-10 info-user">
                        <h3>
                            <a href="/visited/profile.jsp?id=<c:out value="${usuarios.id}"/>" title="Profile">
                                <c:out value="${usuarios.nome}"/>
                            </a>
                        </h3>
                        <p class="text-date">
                            <i><c:out value="${usuarios.descricao}"/></i>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>

        <c:forEach var="estabelecimentos" items="${sessionScope.estabelecimentos}">
            <div class="card-post" style="width:40%; margin-left: 10%;">
                <div class="row">
                    <div class="col-xs-3 col-sm-2">
                        <a href="/visited/profile.jsp?id=<c:out value="${estabelecimentos.id}"/>" title="Profile">
                            <img src="<c:out value="${estabelecimentos.fotoPerfil}"/>"  alt="User name" class="img-circle img-user-post">
                        </a>
                    </div>
                    <div class="col-xs-9 col-sm-10 info-user">
                        <h3>
                            <a href="/page/profile.jsp?id=<c:out value="${estabelecimentos.id}"/>" title="Profile">
                                <c:out value="${estabelecimentos.nome}"/>
                            </a>
                        </h3>
                        <p class="text-date">
                            <i><c:out value="${estabelecimentos.descricao}"/></i>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </body>
    <script>
        <%--var name = "${param.name}";--%>
        <%--if  (name != ""){--%>
            <%--document.getElementById("resultado").innerHTML = name;--%>
        <%--}else {--%>
            <%--alert("eh!");--%>
        <%--}--%>
    </script>
</html>
