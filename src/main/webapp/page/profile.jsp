<%@ page import="com.ifpb.pw1.sysfood.entities.Usuario" %>
<%@ page import="com.ifpb.pw1.sysfood.entities.Estabelecimento" %>
<%@ page import="com.ifpb.pw1.sysfood.managers.GerenciadorEstabelecimento" %><%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 25/09/2018
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<%
    GerenciadorEstabelecimento gerencia = new GerenciadorEstabelecimento();
    Usuario u = (Usuario) session.getAttribute("usuario");

//    if  (id !=null){
//        Usuario usuarioAtual = gerencia.buscarId(Integer.valueOf(id));
//        session.setAttribute("usuario", usuarioAtual);
//
//    } else{
//        response.sendRedirect("login.jsp");
//    }


//    byte bytearray[] = u.getFotoPerfil();
//    Part part = new Part(u.getFotoPerfil());


%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${sessionScope.estabelecimento.nome} | Profile!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../assets/css/bootstrap.min.css" type="text/css">
    <script src="../assets/js/jquery-3.2.0.min.js.download"></script>
    <script src="../assets/js/bootstrap.min.js.download"></script>
    <link href="https://socialyte.codeplus.it/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/bootstrap-switch.min.css">
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
    <div class="sidebar-nav">
        <a href="profile.jsp" title="Profile">
            <img src="${sessionScope.estabelecimento.fotoPerfil}" alt="User name" class="img-circle img-user">
        </a>
        <h2 class="text-center hidden-xs"><a href="./page/profile.jsp?id=${sessionScope.estabelecimento.id}" title="Profile">${sessionScope.estabelecimento.nome}</a></h2>
        <p class="text-center user-description hidden-xs">
            <i>${sessionScope.estabelecimento.descricao}</i>
        </p>
        <div id="extwaiimpotscp" style="display:none" v="{b384" f="ZTJJek9EUmlOelZqTFdNNU56Z3ROR00wWkMxaU0yTm1MVFl5WVRneVpEaG1PR1l4TW4wPQ==" q="be61240b" c="2.501" i="6.549" u="1.627" s="8d4e4c40" w="false" vn="0yotr"></div></div>

    <div class="content-posts profile-content">
        <div class="banner-profile">
        </div>
        <!-- Tab Panel -->
        <ul class="nav nav-tabs" role="tablist">
            <li class="active"><a href="#posts" role="tab" id="postsTab" data-toggle="tab" aria-controls="posts" aria-expanded="true">Publicações</a></li>
            <li><a href="#profile" role="tab" id="profileTab" data-toggle="tab" aria-controls="profile" aria-expanded="true">Informações</a></li>
            <li><a href="#comida" role="tab" id="comidaTab" data-toggle="tab" aria-controls="chat" aria-expanded="true">Cardápio</a></li>
        </ul>

        <!--Start Tab Content-->
        <div class="tab-content">

            <!-- Tab Posts -->
            <div class="tab-pane fade active in" role="tabpanel" id="posts" aria-labelledby="postsTab">
                <div id="posts-container" class="container-fluid container-posts">

                    <div class="card-post">
                        <div class="row">
                            <div class="col-xs-3 col-sm-2">
                                <a href="profile.jsp" title="Profile">
                                    <img src="${sessionScope.foto}" alt="User name" class="img-circle img-user-post">
                                </a>
                            </div>
                            <div class="col-xs-9 col-sm-10 info-user">
                                <h3><a href="https://socialyte.codeplus.it/personal-profile.html" title="Profile">My User</a></h3>
                                <p><i>2h</i></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-8 col-sm-offset-2 data-post">
                                <p>Lorem Ipsum Dolor si amet</p>
                                <div class="reaction">
                                    <img draggable="false" class="emoji" alt="❤" src="Personal%20Profile%20Template_arquivos/2764.png"> 156 <img draggable="false" class="emoji" alt="😃" src="Personal%20Profile%20Template_arquivos/1f603.png"> 54
                                </div>
                                <div class="comments">
                                    <div class="more-comments">View more comments</div>
                                    <ul>
                                        <li><b>User1</b> Lorem Ipsum Dolor si amet</li>
                                        <li><b>User2</b> Lorem Ipsum Dolor si amet <img draggable="false" class="emoji" alt="😂" src="Personal%20Profile%20Template_arquivos/1f602.png"></li>
                                    </ul>
                                    <form>
                                        <input class="form-control" placeholder="Add a comment" type="text">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card-post">
                        <div class="row">
                            <div class="col-xs-3 col-sm-2">
                                <a href="https://socialyte.codeplus.it/personal-profile.html" title="Profile">
                                    <img src="Personal%20Profile%20Template_arquivos/user.jpg" alt="My User" class="img-circle img-user">
                                </a>
                            </div>
                            <div class="col-xs-9 col-sm-10 info-user">
                                <h3><a href="https://socialyte.codeplus.it/personal-profile.html" title="Profile">My User</a></h3>
                                <p><i>2h</i></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class=" col-sm-8 col-sm-offset-2 data-post">
                                <p>Lorem Ipsum Dolor si amet</p>
                                <img src="Personal%20Profile%20Template_arquivos/post.jpg" alt="image post" class="img-post">
                                <div class="reaction">
                                    <img draggable="false" class="emoji" alt="❤" src="Personal%20Profile%20Template_arquivos/2764.png"> 1234 <img draggable="false" class="emoji" alt="😃" src="Personal%20Profile%20Template_arquivos/1f603.png"> 54
                                </div>
                                <div class="comments">
                                    <div class="more-comments">View more comments</div>
                                    <ul>
                                        <li><b>User1</b> Lorem Ipsum Dolor si amet</li>
                                        <li><b>User2</b> Lorem Ipsum Dolor si amet <img draggable="false" class="emoji" alt="😂" src="Personal%20Profile%20Template_arquivos/1f602.png"></li>
                                    </ul>
                                    <form>
                                        <input class="form-control" placeholder="Add a comment" type="text">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- end Tab Posts -->

            <!--Start Tab Profile-->
            <div class="tab-pane fade" role="tabpanel" id="profile" aria-labelledby="profileTab">
                <div class="container-fluid container-posts">
                    <div class="card-post">
                        <ul class="profile-data">
                            <li><b>Nome:</b> ${sessionScope.estabelecimento.nome}</li>
                            <li><b>Funcionamento:</b>  ${sessionScope.estabelecimento.dataHoraFuncionamento}</li>
                            <li><b>Tipo:</b> ${sessionScope.estabelecimento.tipo}</li>
                            <li><b>Endereco:</b> ${sessionScope.estabelecimento.rua}, ${sessionScope.estabelecimento.numero},
                                ${sessionScope.estabelecimento.cep}, ${sessionScope.estabelecimento.cidade} - ${sessionScope.estabelecimento.estado}</li>
                            <li><b>Email dono::</b> ${sessionScope.estabelecimento.usuarioEmail}</li>
                            <li><b>ID da página:</b> ${sessionScope.estabelecimento.id}</li>
                        </ul>
                        <p><a href="" title="edit profile"><i class="fa fa-pencil" aria-hidden="true"></i> Edit profile</a></p>
                    </div>
                </div>
            </div><!-- end tab Profile -->

            <!-- Start Tab comida-->
            <div class="tab-pane fade" role="tabpanel" id="comida" aria-labelledby="comidaTab">
                <div class="container-fluid container-posts">
                    <div class="card-post">
                        <div class="scrollbar-container">
                            <div class="row row-user-list">
                                <div class="col-sm-2 col-xs-3">
                                    <img src="../assets/img/menu.png" alt="Logo food" class="img-circle img-user">
                                </div>
                                <div class="col-sm-4 col-xs-9">
                                    <p style="text-align: justify"><b>Cadastre um novo item:</b></p>
                                    <p>Abaixo uma lista com todos os itens do cardápio do estabelecimento.</p>
                                </div>
                                <div class="col-sm-3 hidden-xs">
                                    <a href="food.jsp" title="Cadastrar" data-toggle="modal" data-target="#foodmodal">
                                        <span class="badge badge-replay">Cadastrar +</span>
                                    </a>
                                </div>
                            </div>
                            <%--FOR EACH COMIDAS - INICIO--%>
                            <div class="row row-user-list">
                                <div class="col-sm-2 col-xs-3">
                                    <img src="./profile/user2.jpg" alt="Comida nome" class="img-circle img-user">
                                </div>
                                <div class="col-sm-4 col-xs-9">
                                    <p><b>Comida nome</b> <span class="badge">1</span></p>
                                    <p class="chat-time">data</p>
                                    <p>descrição</p>
                                </div>
                                <div class="col-sm-3 hidden-xs">
                                    <p><a href="#cadastrarItem" title="Avaliar"><span class="badge badge-replay">Avaliar &gt;</span></a></p>
                                </div>
                            </div>
                            <%--FOR EACH COMIDAS - FINAL--%>
                        </div>
                    </div>
                </div>
            </div><!-- End Tab comida-->
        </div><!-- Close Tab Content-->

    </div><!--Close content posts-->

    <!-- Modal container for settings--->
    <div id="settingsmodal" class="modal fade text-center">
        <div class="modal-dialog">
            <div class="modal-content">
            </div>
        </div>
    </div>
    <div id="foodmodal" class="modal fade text-center">
        <div class="modal-dialog">
            <div class="modal-content">
            </div>
        </div>
    </div>
</body>
</html>