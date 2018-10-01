<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="user" required="true"  type="com.ifpb.pw1.sysfood.entities.Usuario"%>

<c:choose>

    <c:when test="${user.foto2 != null}">

        <img src="front?command=FotoUsuario" class="circle">

    </c:when>

    <c:otherwise>

        <img src="profile/user.jpg" class="circle">

    </c:otherwise>

</c:choose>

<label id="nome">${user.nome}</label><br><br>



<label>É ${user.profissao}</label>

<br><label>${user.nascimento}</label>

<br><label>${user.cidade}</label>

<br><br>

<%--<h5>Nota como motorista: ${user.nota_motorista}</h5>--%>

<%--<h5>Nota como passageiro: ${user.nota_passageiro}</h5>--%>