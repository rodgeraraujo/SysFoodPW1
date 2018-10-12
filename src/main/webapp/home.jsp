<%@ page import="com.ifpb.pw1.sysfood.entities.Usuario" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.io.ByteArrayInputStream" %><%--
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysFood | Welcome ${sessionScope.usuario.nome}!</title>
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

    <body id="wall">
        <%
            Usuario u = (Usuario) session.getAttribute("usuario");

            if  (u == null) {
                response.sendRedirect("index.jsp");
            }

        %>
        <!--Header with Nav -->
        <header class="text-right">
            <form class="text-left search" method="GET">
                <input name="q" type="text" placeholder="Search..">
            </form>
            <div class="menu-icon">
                <div class="dropdown">
                    <span class="dropdown-toggle" role="button" id="dropdownSettings" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                      <span class="hidden-xs hidden-sm"> </span> <i class="fa fa-cogs" aria-hidden="true"></i>
                    </span>
                    <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownSettings">
                        <li>
                            <a href="settings.jsp" title="Settings" data-toggle="modal" data-target="#settingsmodal">
                                <div class="col-xs-4">
                                    <i class="fa fa-wrench" aria-hidden="true"></i>
                                </div>
                                <div class="col-xs-8 text-left">
                                    <span>Configurações</span>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="establishment.jsp" title="Establishment" data-toggle="modal" data-target="#establishmentmodel">
                                <div class="col-xs-4">
                                    <i class="fas fa-store" aria-hidden="true"></i>
                                </div>
                                <div class="col-xs-8 text-left">
                                    <span>Estabelecimento</span>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#faq" title="Settings">
                                <div class="col-xs-4">
                                    <i class="fa fa-question" aria-hidden="true"></i>
                                </div>
                                <div class="col-xs-8 text-left">
                                    <span>FAQ</span>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="/front?action=Logout" title="Settings">
                                <div class="col-xs-4">
                                    <i class="fas fa-sign-out-alt" aria-hidden="true"></i>
                                </div>
                                <div class="col-xs-8 text-left">
                                    <span>Sair</span>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="second-icon dropdown menu-icon">
                <span class="dropdown-toggle" role="button" id="dropdownNotification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <span class="hidden-xs hidden-sm">Notifications</span> <i class="fas fa-bell" aria-hidden="true"></i> <span class="badge">2</span>
                </span>
                <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownNotification">
                    <li class="new-not">
                        <a href="#link1" title="User name comment"><img src="./profile/user2.jpg" alt="User name" class="img-circle img-user-mini"> User comments your post</a>
                    </li>
                    <li class="new-not">
                        <a href="#link2" title="User name comment"><img src="./profile/user3.jpg" alt="User name" class="img-circle img-user-mini"> User comments your post</a>
                    </li>
                    <li>
                        <a href="#link3" title="User name comment"><img src="./profile/user4.jpg" alt="User name" class="img-circle img-user-mini"> User comments your post</a>
                    </li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#allnotifications" title="All notifications">Todas as notificações</a></li>
                </ul>
            </div>
            <div class="second-icon menu-icon">
                <span><a href="profile.jsp" title="Profile"><span class="hidden-xs hidden-sm">Perfil</span> <i class="fa fa-user" aria-hidden="true"></i></a>
                </span>
            </div>
            <div class="second-icon menu-icon">
                <span><a href="home.jsp" title="Wall"><span class="hidden-xs hidden-sm">Home</span> <i class="fa fa-database" aria-hidden="true"></i></a>
                </span>
            </div>
        </header>

        <!--Left Sidebar with info Profile -->
        <div id="settingsmodal" class="modal fade text-center">
            <div class="modal-dialog">
                <div class="modal-content">
                </div>
            </div>
        </div>


        <div id="establishmentmodel" class="modal fade text-center">
            <div class="modal-dialog">
                <div class="modal-content">
                </div>
            </div>
        </div>

        <!--Wall with Post -->
        <div class="sidebar-nav">
            <a href="profile.jsp" title="Profile">
                <img width="200" height="200" src="${sessionScope.foto}" alt="User name" class="img-circle img-user">
            </a>
            <h2 class="text-center hidden-xs"><a href="profile.jsp" title="Profile">${sessionScope.usuario.nome}</a></h2>
            <p class="text-center user-description hidden-xs">
                <i>${sessionScope.usuario.descricao}</i>
            </p>
        </div>
        <!-- Close #posts -->
        <!-- Modal container for settings--->
        <div class="content-posts active" id="posts">
            <div id="posts-container" class="container-fluid container-posts">

                <div class="card-post">
                    <div class="row">
                        <form method="post" action="/front?action=PublicacaoController" enctype="multipart/form-data">
                            <div class="col-sm-6">
                                <textarea class="form-control" name="conteudo" id="" cols="30" rows="10"></textarea>
                                <input class="form-control" name="fotoPublicacao" type="file" required>
                                <input class="form-control" type="submit" value="Post">
                            </div>
                        </form>
                    </div>
                </div>

                <jsp:useBean id="dao" class="com.ifpb.pw1.sysfood.dao.impl.UsuarioDaoBD"/>
                <c:forEach var="publicacao" items="${dao.buscaPublicacao()}">
                    <div class="card-post">
                        <div class="row">
                            <div class="col-xs-3 col-sm-2">
                                <a href="profile.jsp?id=<c:out value="${publicacao.idUsuario}"/>" title="Profile">
                                    <img src="<c:out value="${publicacao.usuarioFoto}"/>"  alt="User name" class="img-circle img-user">
                                </a>
                            </div>
                            <div class="col-xs-9 col-sm-10 info-user">
                                <h3>
                                    <a href="profile.jsp?id=<c:out value="${publicacao.idUsuario}"/>" title="Profile">
                                        <c:out value="${publicacao.nomeUsuario}"/>
                                    </a>
                                </h3>
                                <p><i><c:out value="${publicacao.dataPublicacao}"/></i></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-8 col-sm-offset-2 data-post">
                                <p>${publicacao.conteudo}</p>
                                <img src="<c:out value="${publicacao.foto}"/>" alt="image post" class="img-post">
                                <div class="comments">
                                    <form method="post" action="#">
                                        <input type="text" class="form-control" placeholder="Add a comment">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <%--<div class="card-post">--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-xs-3 col-sm-2">--%>
                            <%--<a href="https://socialyte.codeplus.it/user-profile.html" title="User Profile">--%>
                                <%--<img src="./profile/user2.jpg" alt="User name" class="img-circle img-user">--%>
                            <%--</a>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-9 col-sm-10 info-user">--%>
                            <%--<h3><a href="profile.jsp" title="User Profile">User Name</a></h3>--%>
                            <%--<p><i>2h</i></p>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="row">--%>
                        <%--<div class=" col-sm-8 col-sm-offset-2 data-post">--%>
                            <%--<p>Lorem Ipsum Dolor si amet</p>--%>
                            <%--<img src="./profile/post.jpg" alt="image post" class="img-post">--%>
                            <%--<div class="reaction">--%>
                                <%--<img draggable="false" class="emoji" alt="❤" src="./profile/2764.png"> 1234 <img draggable="false" class="emoji" alt="😃" src="./Wall Template_files/1f603.png"> 54--%>
                            <%--</div>--%>
                            <%--<div class="comments">--%>
                                <%--<div class="more-comments">View more comments</div>--%>
                                <%--<ul>--%>
                                    <%--<li><b>User1</b> Lorem Ipsum Dolor si amet</li>--%>
                                    <%--<li><b>User2</b> Lorem Ipsum Dolor si amet <img draggable="false" class="emoji" alt="😂" src="./Wall Template_files/1f602.png"></li>--%>
                                <%--</ul>--%>
                                <%--<form>--%>
                                    <%--<input type="text" class="form-control" placeholder="Add a comment">--%>
                                <%--</form>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="card-post">--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-xs-3 col-sm-2">--%>
                            <%--<a href="https://socialyte.codeplus.it/personal-profile.html" title="User Profile">--%>
                                <%--<img src="./profile/user.jpg" alt="User name" class="img-circle img-user">--%>
                            <%--</a>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-9 col-sm-10 info-user">--%>
                            <%--<h3><a href="profile.jsp" title="User Profile">My User</a></h3>--%>
                            <%--<p><i>2h</i></p>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-sm-8 col-sm-offset-2 data-post">--%>
                            <%--<p>Lorem Ipsum Dolor si amet</p>--%>
                            <%--Video here--%>
                            <%--<video controls="">--%>
                                <%--<source src="img/post-video.mp4" type="video/mp4">--%>
                                <%--Your browser does not support the video tag.--%>
                            <%--</video>--%>
                            <%--<div class="reaction">--%>
                                <%--<img draggable="false" class="emoji" alt="❤" src="./profile/2764.png"> 1234 <img draggable="false" class="emoji" alt="😃" src="./Wall Template_files/1f603.png"> 54--%>
                            <%--</div>--%>
                            <%--<div class="comments">--%>
                                <%--<div class="more-comments">View more comments</div>--%>
                                <%--<ul>--%>
                                    <%--<li><b>User1</b> Lorem Ipsum Dolor si amet</li>--%>
                                    <%--<li><b>User2</b> Lorem Ipsum Dolor si amet <img draggable="false" class="emoji" alt="😂" src="./Wall Template_files/1f602.png"></li>--%>
                                <%--</ul>--%>
                                <%--<form>--%>
                                    <%--<input type="text" class="form-control" placeholder="Add a comment">--%>
                                <%--</form>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                </div>
            </div>
            <!--Close #posts-container-->
            <%--<div id="loading">--%>
                <%--<img src="./profile/load.gif" alt="loader">--%>
            <%--</div>--%>
        </div>

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
                type: 'success',
                title: 'Logado com sucesso'
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
                title: 'Estabelecimento cadastrado com sucesso'
            })
        }
    </script>
</html>
