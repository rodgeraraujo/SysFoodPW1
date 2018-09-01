<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 28/08/2018
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bem vindo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">--%>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
  <h1>Bem vindo!!</h1>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<%--<jsp:include page="errorToast.jsp"/>--%>
</body>
</html>