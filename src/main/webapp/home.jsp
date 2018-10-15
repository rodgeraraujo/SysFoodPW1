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
        <jsp:include page="/navbar.jsp"/>

        <!--Wall with Post -->
        <div class="sidebar-nav">
            <a href="profile.jsp" title="Profile">
                <img width="200" height="200" src="${sessionScope.usuario.fotoPerfil}" alt="User name" class="img-circle img-user">
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
                        <form method="post" action="/front?action=SalvarPublicacao" enctype="multipart/form-data">
                            <%--<div class="col-sm-8">--%>
                                <%--<textarea class="form-control" name="conteudo" id="" cols="30" rows="10"></textarea>--%>
                                <%--<br>--%>
                                <%--<input class="form-control" name="fotoPublicacao" type="file">--%>
                                <%--<br>--%>
                                <%--<input class="form-control" type="submit" value="Post">--%>
                            <%--</div>--%>
                            <li class="add-post">
                                <textarea class="add-post-textarea" name="conteudo" placeholder="Write a post..."></textarea>
                            </li>

                                <div class="image-upload">
                                <label for="file-input">
                                    <%--<img src="https://placehold.it/100/000000/ffffff?text=UPLOAD" style="pointer-events: none"/>--%>
                                        <i class="fa fa-upload post-file" aria-hidden="true" name="conteudo" style="cursor: pointer"></i>
                                </label>
                                    <input id="file-input" type="file" name="fotoPublicacao"/>
                                </div>
                                <input type="submit" class="post-button" value="Post">
                        </form>
                    </div>
                </div>

                <jsp:useBean id="dao" class="com.ifpb.pw1.sysfood.dao.impl.UsuarioDaoBD"/>
                <c:forEach var="publicacao" items="${dao.buscaPublicacao()}">
                    <div class="card-post">
                        <div class="row">
                            <div class="col-xs-3 col-sm-2">
                                <a href="profile.jsp?id=<c:out value="${publicacao.idUsuario}"/>" title="Profile">
                                    <img src="<c:out value="${publicacao.usuarioFoto}"/>"  alt="User name" class="img-circle img-user-post">
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
                        <br>
                        <div class="row">
                            <div class="col-sm-8 col-sm-offset data-post">
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
