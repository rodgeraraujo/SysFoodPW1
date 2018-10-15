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
        <p>O resultado:</p>

        <c:forEach var="pesquisa" items="${sessionScope.pesquisa}">
            <p>${pesquisa}</p>
        </c:forEach>
    </body>
</html>
