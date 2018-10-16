<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 14/10/2018
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="text-right">
    <form class="text-left search" method="post" action="/front?action=Pesquisa">
        <input name="q" type="text" placeholder="Pesquise...">
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
            <span class="hidden-xs hidden-sm">Notificações</span> <i class="fas fa-bell" aria-hidden="true"></i> <span class="badge">2</span>
                </span>
        <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownNotification">
            <%--<li class="new-not">--%>
                <%--<a href="#link1" title="User name comment"><img src="./profile/user2.jpg" alt="User name" class="img-circle img-user-mini"> User comments your post</a>--%>
            <%--</li>--%>
            <%--<li class="new-not">--%>
                <%--<a href="#link2" title="User name comment"><img src="./profile/user3.jpg" alt="User name" class="img-circle img-user-mini"> User comments your post</a>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="#link3" title="User name comment"><img src="./profile/user4.jpg" alt="User name" class="img-circle img-user-mini"> User comments your post</a>--%>
            <%--</li>--%>
            <li role="separator" class="divider"></li>
            <li><a href="#allnotifications" title="All notifications">Exibit todas as notificações</a></li>
        </ul>
    </div>
    <div class="second-icon menu-icon">
                <span><a href="/profile.jsp?user=${sessionScope.usuario.id}" title="Profile"><span class="hidden-xs hidden-sm">Perfil</span> <i class="fa fa-user" aria-hidden="true"></i></a>
                </span>
    </div>
    <div class="second-icon menu-icon">
                <span><a href="/home.jsp" title="Wall"><span class="hidden-xs hidden-sm">Home</span> <i class="fa fa-database" aria-hidden="true"></i></a>
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