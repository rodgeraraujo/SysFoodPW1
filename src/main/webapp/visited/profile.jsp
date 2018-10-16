<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 25/09/2018
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.ifpb.pw1.sysfood.entities.Usuario" %>
<%@ page import="com.ifpb.pw1.sysfood.managers.GerenciadorUsuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<%
    GerenciadorUsuario gerencia = new GerenciadorUsuario();
    Usuario u = (Usuario) session.getAttribute("usuario");
    String id = request.getParameter("id");

    if  (u != null) {
        if  (id !=null){
            Usuario usuarioAtual = gerencia.buscarId(Integer.valueOf(id));
            if (usuarioAtual != null){
                request.setAttribute("usuario", usuarioAtual);
            }else{
                response.sendRedirect("home.jsp");
            }
        }
    } else{
        response.sendRedirect("login.jsp");
    }

%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${requestScope.usuario.nome} | Profile!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../assets/css/bootstrap.min.css" type="text/css">
    <script src="../assets/js/jquery-3.2.0.min.js.download"></script>
    <script src="../assets/js/bootstrap.min.js.download"></script>
    <link href="https://socialyte.codeplus.it/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./assets/css/bootstrap-switch.min.css">
    <script src="../assets/profile/js/bootstrap-switch.min.js"></script>
    <script src="../assets/profile/js/twemoji.min.js"></script>
    <script src="../assets/profile/js/lazy-load.min.js"></script>
    <script src="../assets/profile/js/socialyte.min.js"></script>
    <link href="../assets/css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,600,700" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/style.css" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>

<body id="wall">

<!--Header with Nav -->
<jsp:include page="/navbar.jsp"/>

    <!--Left Sidebar with info Profile -->
    <div class="sidebar-nav">
        <a href="profile.jsp" title="Profile">
            <img src="${requestScope.usuario.fotoPerfil}" alt="User name" class="img-circle img-user">
        </a>
        <h2 class="text-center hidden-xs"><a href="profile.jsp" title="Profile">${requestScope.usuario.nome}</a></h2>
        <p class="text-center user-description hidden-xs">
            <i>${requestScope.usuario.descricao}</i>
        </p>
        <div id="extwaiimpotscp" style="display:none" v="{b384" f="ZTJJek9EUmlOelZqTFdNNU56Z3ROR00wWkMxaU0yTm1MVFl5WVRneVpEaG1PR1l4TW4wPQ==" q="be61240b" c="2.501" i="6.549" u="1.627" s="8d4e4c40" w="false" vn="0yotr"></div></div>

    <div class="content-posts profile-content">
        <div class="banner-profile">
        </div>
        <!-- Tab Panel -->
        <ul class="nav nav-tabs" role="tablist">
            <li class="active"><a href="#posts" role="tab" id="postsTab" data-toggle="tab" aria-controls="posts" aria-expanded="true">Publicações</a></li>
            <li><a href="#profile" role="tab" id="profileTab" data-toggle="tab" aria-controls="profile" aria-expanded="true">Informações</a></li>
            <li><a href="#amigo" role="tab" id="amigoTab" data-toggle="tab" aria-controls="amigos" aria-expanded="true">Amigos</a></li>
            <li><a href="#estabelecimento" role="tab" id="estabelecimetoTab" data-toggle="tab" aria-controls="estabelecimentos" aria-expanded="true">Estabelecimentos</a></li>
        </ul>

        <!--Start Tab Content-->
        <div class="tab-content">

            <!-- Tab Posts -->
            <div class="tab-pane fade active in" role="tabpanel" id="posts" aria-labelledby="postsTab">
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
                    <c:forEach var="publicacao" items="${dao.buscaPublicacaoUsuario(requestScope.usuario.id)}">
                        <div class="card-post">
                            <div class="row">
                                <div class="col-xs-3 col-sm-2">
                                    <a href="profile.jsp?id=<c:out value="${publicacao.idUsuario}"/>" title="Profile">
                                        <img src="<c:out value="${publicacao.usuarioFoto}"/>"  alt="User name" class="img-circle img-user-post">
                                    </a>
                                </div>
                                <div class="col-xs-9 col-sm-10 info-user">
                                    <h3>
                                        <a href="/visited/profile.jsp?id=<c:out value="${publicacao.idUsuario}"/>" title="Profile">
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
                </div>
                <div id="loading" style="display: none;">
                    <img src="Personal%20Profile%20Template_arquivos/load.gif" alt="loader">
                </div>
            </div><!-- end Tab Posts -->

            <!--Start Tab Profile-->
            <div class="tab-pane fade" role="tabpanel" id="profile" aria-labelledby="profileTab">
                <div class="container-fluid container-posts">
                    <div class="card-post">
                        <ul class="profile-data">
                            <li><b>Nome:</b> ${requestScope.usuario.nome}</li>
                            <li><b>Email:</b>  ${requestScope.usuario.email}</li>
                            <li><b>Data de aniversário:</b>  ${requestScope.usuario.aniversario}</li>
                            <li><b>Profissão:</b> ${requestScope.usuario.profissao}</li>
                            <li><b>Telefone:</b> ${requestScope.usuario.telefone}</li>
                            <li><b>Sexo:</b> ${requestScope.usuario.sexo}</li>
                            <li><b>Endereco:</b> ${requestScope.usuario.rua}, ${requestScope.usuario.numero},
                                ${requestScope.usuario.cep}, ${requestScope.usuario.cidade} - ${requestScope.usuario.estado}</li>
                        </ul>
                        <p><a href="" title="edit profile"><i class="fa fa-pencil" aria-hidden="true"></i> Edit profile</a></p>
                    </div>
                </div>
            </div><!-- end tab Profile -->

            <!-- Start Tab amigo-->
            <div class="tab-pane fade" role="tabpanel" id="amigo" aria-labelledby="amigoTab">
                <div class="container-fluid container-posts">
                    <div class="card-post">
                        <div class="scrollbar-container">
                            <div class="row row-user-list">
                                <div class="col-sm-2 col-xs-3">
                                    <img src="./profile/user2.jpg" alt="User name" class="img-circle img-user">
                                </div>
                                <div class="col-sm-7 col-xs-9">
                                    <p><b>User Name</b> <span class="badge">1</span></p>
                                    <p class="chat-time">An hour ago</p>
                                    <p>Lorem ipsum</p>
                                </div>
                                <div class="col-sm-3 hidden-xs">
                                    <p><a href="" title="Replay"><span class="badge badge-replay">Replay &gt;</span></a></p>
                                </div>
                            </div>
                            <div class="row row-user-list">
                                <div class="col-sm-2 col-xs-3">
                                    <img src="./profile/user3.jpg" alt="User name" class="img-circle img-user">
                                </div>
                                <div class="col-sm-7 col-xs-9">
                                    <p><b>User Name</b></p>
                                    <p class="chat-time">Yesterday</p>
                                    <p>Lorem ipsum</p>
                                </div>
                                <div class="col-sm-3 hidden-xs">
                                    <p><a href="" title="Start chat"><span class="badge badge-message">Start chat &gt;</span></a></p>
                                </div>
                            </div>
                            <div class="row row-user-list">
                                <div class="col-sm-2 col-xs-3">
                                    <img src="./profile/user4.jpg" alt="User name" class="img-circle img-user">
                                </div>
                                <div class="col-sm-7 col-xs-9">
                                    <p><b>User Name</b></p>
                                    <p class="chat-time">2 days ago</p>
                                    <p>Lorem ipsum</p>
                                </div>
                                <div class="col-sm-3 hidden-xs">
                                    <p><a href="" title="Start chat"><span class="badge badge-message">Start chat &gt;</span></a></p>
                                </div>
                            </div>
                            <div class="row row-user-list">
                                <div class="col-sm-2 col-xs-3">
                                    <img src="./profile/user5.jpg" alt="User name" class="img-circle img-user">
                                </div>
                                <div class="col-sm-7 col-xs-9">
                                    <p><b>User Name</b></p>
                                    <p class="chat-time">2 days ago</p>
                                    <p>Lorem ipsum</p>
                                </div>
                                <div class="col-sm-3 hidden-xs">
                                    <p><a href="" title="Start chat"><span class="badge badge-message">Start chat &gt;</span></a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- End Tab amigo-->

            <!-- Start Tab estabelecimentos-->
            <div class="tab-pane fade" role="tabpanel" id="estabelecimento" aria-labelledby="chatTab">
                <div class="container-fluid container-posts">
                    <div class="card-post">
                        <div class="scrollbar-container">
                            <jsp:useBean id="dao2" class="com.ifpb.pw1.sysfood.dao.impl.EstabelecimentoDaoBD"/>
                            <c:forEach var="estabelecimento" items="${dao2.buscarEstabelecimento(requestScope.usuario.email)}">
                                <div class="row row-user-list">
                                    <div class="col-sm-2 col-xs-3">
                                        <img src="<c:out value="${estabelecimento.fotoPerfil}"/>" alt="image establishment" class="img-circle img-establishment">
                                    </div>
                                    <div class="col-sm-4 col-xs-9">
                                        <p>
                                            <br><br>
                                            <b><c:out value="${estabelecimento.nome}"/></b>
                                        </p>
                                        <%--<p><b>Estabelecimento nome</b> <span class="badge">1</span></p>--%>
                                    </div>
                                    <div class="col-sm-3 hidden-xs">
                                        <p>
                                            <a href="/page/profile.jsp?id=<c:out value="${estabelecimento.id}"/>" title="Visualizar">
                                                <span class="badge badge-replay">Ver &gt;</span>
                                            </a>
                                        </p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                </div>
            </div><!-- End Tab estabelecimentos-->

        </div><!-- Close Tab Content-->

    </div><!--Close content posts-->

    <!-- Modal container for settings--->
    <div id="settingsmodal" class="modal fade text-center">
        <div class="modal-dialog">
            <div class="modal-content">
            </div>
        </div>
    </div>
</body>
</html>