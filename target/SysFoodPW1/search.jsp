<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 13/10/2018
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="dao" class="com.ifpb.pw1.sysfood.dao.impl.PesquisaDaoBD"/>
<c:forEach var="usuario" items="${dao.Pesquisa(nome)}">
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
</body>
</html>
