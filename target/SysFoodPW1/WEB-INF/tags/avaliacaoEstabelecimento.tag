<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="usuario" required="true"  type="com.ifpb.pw1.sysfood.entities.Usuario"%>
<%@attribute name="estabelecimeto" required="true"  type="com.ifpb.pw1.sysfood.entities.Estabelecimento"%>

<c:set var="jaAvaliei" value="false" />

<jsp:useBean id="dao" class="com.ifpb.pw1.sysfood.dao.impl.AvaliarEstabelecimentoDaoBD"/>
<c:forEach var="avaliacao" items="${dao.buscarAvaliacaoUsuario(usuario.id, estabelecimeto.id)}">
    <c:if test="${avaliacao.idUsuario != null}">
        <c:set var="jaAvaliei" value="true" />
    </c:if>
</c:forEach>

<c:choose>
    <c:when test="${jaAvaliei eq 'true'}">
        <a href="/page/avaliacoesEstabelecimento.jsp" title="Avaliações" data-toggle="modal" data-target="#avaliacoesEstblModal">
            <span class="badge badge-replay text-center hidden-xs">Avaliações</span>
                <%--<h4 class="text-center hidden-xs">Avalie</h4>--%>
        </a>
    </c:when>
    <c:otherwise>
        <a href="/page/avaliaEstabelecimento.jsp" title="Avaliar" data-toggle="modal" data-target="#avaliarEstblModal">
            <span class="badge badge-replay text-center hidden-xs">Avalie +</span>
                <%--<h4 class="text-center hidden-xs">Avalie</h4>--%>
        </a>
    </c:otherwise>
</c:choose>