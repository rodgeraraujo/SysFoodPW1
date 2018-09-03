<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 02/09/2018
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<html>
<head>
    <title>Sysfood - Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">--%>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>

<jsp:include page="navbar.jsp"/>
<div class="container">
    <h4>Usuários</h4>
    <div class="row">
        <div class="col l6">
            <div class="row">

                <form method="post" enctype="multipart/form-data"
                      action="/front?action=LoginUsuario" class="col l5 offset-l1">
                <h5>Login</h5>
                    <div class="row">
                        <div class="input-field col l6">
                            <input placeholder="E-mail" id="email" name="email" type="email" class="validate" required>
                            <label for="email">E-mail</label>
                        <div class="input-field col l6">
                            <input placeholder="Senha" id="senha" name="senha" type="password" class="validate" required>
                            <label for="Senha">Senha</label>
                        </div>
                    </div>

                    <button class="btn-large waves-effect waves-light" type="submit" name="action">LOGIN
                        <i class="material-icons right">send</i>
                    </button>
                    </div>
                </form>
            </div>
        </div>

        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
        <%--<jsp:include page="errorToast.jsp"/>--%>
</body>
</html>
