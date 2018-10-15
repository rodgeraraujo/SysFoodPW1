<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 13/10/2018
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title">Avalie o estabelecimento ${sessionScope.estabelecimento.nome}</h4>
</div>
<div class="modal-body">
    <div style="margin-top: 0px; margin-right: 0px" class="row modal-row">
        <div class="container-rating">
            <div class="inner">
                <div class="rating-modal">
                    <span class="rating-num">4.0</span>
                    <div class="rating-stars">
                        <span><i class="active icon-star"></i></span>
                        <span><i class="active icon-star"></i></span>
                        <span><i class="active icon-star"></i></span>
                        <span><i class="active icon-star"></i></span>
                        <span><i class="icon-star"></i></span>
                    </div>
                    <div class="rating-users">
                        <i class="icon-user"></i> 1,014,004 total
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div style="height: 260px" scrollbar-container">
        <%--modelo inicio--%>
        <div>
            <div class="col-sm-3">
                <p>
                    <label>ID Usuário: 1</label>
                </p>
                <p><b>Nota: </b> <span class="badge">4.4</span></p>
                <p class="chat-time">2018-10-15 02:02:40.662</p>
                <p></p>
            </div>
        </div>
        <br>
        <%--fim--%>
        <jsp:useBean id="dao" class="com.ifpb.pw1.sysfood.dao.impl.AvaliarEstabelecimentoDaoBD"/>
        <c:forEach var="avaliacao" items="${dao.buscar(sessionScope.estabelecimento.id)}">
            <div>
                <div class="col-sm-3">
                    <p>
                        <label>ID Usuário: <c:out value="${avaliacao.idUsuario}"/></label>
                    </p>
                    <p><b>Nota: </b> <span class="badge"><c:out value="${avaliacao.avaliacao}"/></span></p>
                    <p class="chat-time"><c:out value="${avaliacao.dataAvaliacao}"/></p>
                    <p><c:out value="${avaliacao.comentario}"/></p>
                </div>
            </div>
        </c:forEach>
    </div>
    <br>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
    </div>
</div>