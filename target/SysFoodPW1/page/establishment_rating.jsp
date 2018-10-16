<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 14/10/2018
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <br> <br> <br> <br>
    <jsp:useBean id="dao" class="com.ifpb.pw1.sysfood.dao.impl.AvaliarEstabelecimentoDaoBD"/>
    <c:if test="${dao.buscarAvaliacaoUsuario(sessionScope.usuario.id, sessionScope.estabelecimento.id) == false}">
        <a href="/page/avaliaEstabelecimento.jsp" title="Avaliar" data-toggle="modal" data-target="#avaliarEstblModal">
            <span class="badge badge-replay text-center hidden-xs">Avalie +</span>
                <%--<h4 class="text-center hidden-xs">Avalie</h4>--%>
        </a>
    </c:if>

    <c:if test="${dao.buscarAvaliacaoUsuario(sessionScope.usuario.id, sessionScope.estabelecimento.id) == true}">
        <a href="/page/avaliacoesEstabelecimento.jsp" title="Avaliações" data-toggle="modal" data-target="#avaliacoesEstblModal">
            <span class="badge badge-replay text-center hidden-xs">Avaliações</span>
                <%--<h4 class="text-center hidden-xs">Avalie</h4>--%>
        </a>
    </c:if>

    <%--<minhasTags:avaliacaoMotorista viagem="${viagem}" />--%>
    <%--<m:avaliacaoEstabelecimento usuario="${sessionScope.usuario.id}" estabelecimento="${sessionScope.estabelecimento.id}"/>--%>
</div>