<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>Login Success Page</title>
    </head>
    <body>
        <h3>Login Success</h3>
        <h4>Bem vindo ${sessionScope.usuario.nome}</h4>
        <img src="${sessionScope.usuario.nome}">
        <br><br>
        <form action="/front?action=Logout" method="post">
            <input type="button" value="Logout">
        </form>
    </body>
</html>