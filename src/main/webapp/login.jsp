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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>

<jsp:include page="navbar.jsp"/>
<%--<div class="container">--%>
    <%--<h4>Usuários</h4>--%>
    <%--<div class="row">--%>
        <%--<div class="col l6">--%>
            <%--<div class="row">--%>

                <%--<form method="post" enctype="multipart/form-data"--%>
                      <%--action="/front?action=Login" class="col l5 offset-l1">--%>
                <%--<h5>Login</h5>--%>
                    <%--<div class="row">--%>
                        <%--<div class="input-field col l6">--%>
                            <%--<input placeholder="E-mail" id="email" name="email" type="email" class="validate" required>--%>
                            <%--<label for="email">E-mail</label>--%>
                        <%--<div class="input-field col l6">--%>
                            <%--<input placeholder="Senha" id="senha" name="senha" type="password" class="validate" required>--%>
                            <%--<label for="Senha">Senha</label>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<button class="btn-large waves-effect waves-light" type="submit" name="action">LOGIN--%>
                        <%--<i class="material-icons right">send</i>--%>
                    <%--</button>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%
            String email=(String)session.getAttribute("email");

            //redireciona o usuario para a pagina home caso logado
            if(email!=null){
                response.sendRedirect("home.jsp");
            }

        %>

        <form method="post" action="/front?action=Login">
            <table cellpadding="5">
                <tr>
                    <td><b>Email:</b></td>
                    <td><input type="text" name="email" required/></td>
                </tr>

                <tr>
                    <td><b>Password:</b></td>
                    <td><input type="password" name="senha" required/></td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Login"/></td>
                </tr>

            </table>
        </form>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
        <%--<jsp:include page="errorToast.jsp"/>--%>
</body>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.28.4/dist/sweetalert2.all.min.js"></script>
<script>
    var value = "${param.value}";

    if (value == 1) {
        const toast = swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3000
        });

        toast({
            type: 'error',
            title: 'Não possivel autenticar o usuário!'
        })
    }
    if (value == 2) {
        const toast = swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3000
        });

        toast({
            type: 'success',
            title: 'Deslogado com sucesso!'
        })
    }
</script>
</html>
