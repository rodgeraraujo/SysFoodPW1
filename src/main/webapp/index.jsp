<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 10/10/2018
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.ifpb.pw1.sysfood.entities.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>SysFood</title>

    <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css'>
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Arvo:400,700'>
    <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Kreon:300,400,700'>
    <link rel="stylesheet" href="./assets/pages/css/home.css">
</head>
<body>
<%
    Usuario u = (Usuario) session.getAttribute("usuario");

    if  (u != null) {
        response.sendRedirect("home.jsp");
    }

%>
<div id="header">
    <div class='slide1'></div>
    <div class='slide2'></div>
    <div class='slide3'></div>
    <div class='slide4'></div>
    <div class='slide5'></div>

    <div class="bg-overlay"></div>
    <div class="center text-center">
        <div class="subtitle"><h4>Seja bem-vindo a... </h4></div>
        <div class="banner">
            <h1 class="">SysFood</h1>
        </div>
        <br><br><br><br>
        <div class="bottom text-bottom"><h2><a href="register.jsp">Inscreva-se já!   </a></h2></div>
    </div>
    <!-- <div class="bottom text-center">
        <a id="scrollDownArrow" href="login.hmtl"><i>Increva-se!</i></a>
    </div> -->

</div>

<footer id="footer" class="dark-wrapper">
    <section class="ss-style-top"></section>
    <div class="container inner">
        <div class="row">
            <div class="col-sm-6">
                &copy; Copyright SysFood 2018

            </div>
            <div class="col-sm-6">
                <div class="social-bar">
                    <a href="#" class="fa fa-instagram tooltipped" title="instagram"></a>
                    <!-- <a href="#" class="fa fa-youtube-square tooltipped" title="youtube"></a> -->
                    <!-- <a href="#" class="fa fa-facebook-square tooltipped" title="facebook"></a> -->
                    <a href="#" class="fa fa-twitter-square tooltipped" title="twitter"></a>
                    <!-- <a href="#" class="fa fa-google-plus-square tooltipped" title="google+"></a> -->
                </div>
            </div>
        </div>
    </div>
    <!-- /.container -->
</footer>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery.actual/1.0.17/jquery.actual.min.js'></script>

<script src='http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js'></script>

<script  src="./assets/pages/js/home.js"></script>
<script>
    var erro = "${param.erro}";
    if (erro == 1) {
        swal("Erro!", "Usuário não encontrado!", "error");
    }
    var mensagem = "${param.mensagem}";
    if(mensagem == "1"){
        swal("OK!","A conta foi excluida.","success");
    }
</script>
</body>

</html>
