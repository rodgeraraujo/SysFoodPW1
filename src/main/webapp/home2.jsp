<%@ page import="com.ifpb.pw1.sysfood.entities.Usuario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>Login Success Page</title>
    </head>
    <body>
    <%
        Usuario u = (Usuario) session.getAttribute("usuario");
    %>
        <h3>Login Success</h3>
        <h4>Bem vindo <%= u.getNome()%></h4>
        <img src="<%= u.getFotoPerfil()%>" alt="">
        <br><br>
        <form action="/front?action=Logout" method="post">
            <input type="button" value="Logout">
        </form>
    </body>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        var erro = "${param.erro}";
        if (erro == 1) {
            swal("Erro!", "Usuário não encontrado!", "error");
        } else if(erro == 2){
            swal("Erro!", "Não possivel autenticar o usuário!", "error");
        }
        var mensagem = "${param.mensagem}";
        if(mensagem == "1"){
            swal("OK!","A conta foi excluida.","success");
        }
    </script>
</html>