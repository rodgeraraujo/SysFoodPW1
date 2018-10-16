<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 25/09/2018
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title">General Settings</h4>
</div>
<div class="modal-body">
    <form method="post" enctype="multipart/form-data"
          action="/front?action=CadastrarUsuario" class="col l5 offset-l1">
        <div class="row modal-row">
            <div class="col-sm-3">
                <label>Nome: </label>
            </div>
            <div class="col-sm-5">
                <input class="form-control" placeholder="Nome" id="nome" name="nome" value="${sessionScope.usuario.nome}" type="text" class="validate">
            </div>
        </div>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Foto: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <input class="form-control" name="fotoPerfil" id="fotoPerfil" type="file" value="${sessionScope.usuario.fotoPerfil}" accept="image/*" >
            </div>
            <%--<div class="col-sm-3">--%>
            <%--<p>--%>
            <%--<a href="#" title="Edit Email"><i class="fas fa-pencil-alt" aria-hidden="true"></i> <i>Edit</i></a>--%>
            <%--</p>--%>
            <%--</div>--%>
        </div>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Descrição: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <textarea class="form-control" placeholder="Descrição" name="descricao" id="descricap" cols="20" rows="10">${sessionScope.usuario.descricao}</textarea>
            </div>
            <%--<div class="col-sm-3">--%>
            <%--<a href="#" title="Edit Password"><i class="fas fa-pencil-alt" aria-hidden="true"></i> <i>Edit</i></a>--%>
            <%--</div>--%>
        </div>

        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Profissão: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <p>
                    <input class="form-control" placeholder="Profissão" id="profissao" name="profissao" value="${sessionScope.usuario.profissao}" type="text" class="validate">
                </p>
            </div>
            <%--<div class="col-sm-3">--%>
            <%--<a href="#" title="Edit Language"><i class="fas fa-pencil-alt" aria-hidden="true"></i> <i>Edit</i></a>--%>
            <%--</div>--%>
        </div>

        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Rua: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <input class="form-control" placeholder="Rua" id="rua" name="rua" type="text" value="${sessionScope.usuario.rua}" class="validate" >
            </div>
        <%--<div class="col-sm-3">--%>
        <%--<a href="#" title="Edit Language"><i class="fas fa-pencil-alt" aria-hidden="true"></i> <i>Edit</i></a>--%>
        <%--</div>--%>
        </div>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Cidade: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <p>
                    <input class="form-control" placeholder="Cidade" id="cidade" name="cidade" value="${sessionScope.usuario.cidade}" type="text" class="validate">
                </p>
            </div>
        </div>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Estado: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <select class="form-control" name="estado">
                    <option value="${sessionScope.usuario.estado}">Selecione o Estado</option>
                    <option value="ac">Acre</option>
                    <option value="al">Alagoas</option>
                    <option value="am">Amazonas</option>
                    <option value="ap">Amapá</option>
                    <option value="ba">Bahia</option>
                    <option value="ce">Ceará</option>
                    <option value="df">Distrito Federal</option>
                    <option value="es">Espírito Santo</option>
                    <option value="go">Goiás</option>
                    <option value="ma">Maranhão</option>
                    <option value="mt">Mato Grosso</option>
                    <option value="ms">Mato Grosso do Sul</option>
                    <option value="mg">Minas Gerais</option>
                    <option value="pa">Pará</option>
                    <option value="pb">Paraíba</option>
                    <option value="pr">Paraná</option>
                    <option value="pe">Pernambuco</option>
                    <option value="pi">Piauí</option>
                    <option value="rj">Rio de Janeiro</option>
                    <option value="rn">Rio Grande do Norte</option>
                    <option value="ro">Rondônia</option>
                    <option value="rs">Rio Grande do Sul</option>
                    <option value="rr">Roraima</option>
                    <option value="sc">Santa Catarina</option>
                    <option value="se">Sergipe</option>
                    <option value="sp">São Paulo</option>
                    <option value="to">Tocantins</option>
                </select>
            </div>
        <%--<div class="col-sm-3">--%>
        <%--<a href="#" title="Edit Language"><i class="fas fa-pencil-alt" aria-hidden="true"></i> <i>Edit</i></a>--%>
        <%--</div>--%>
        </div>

        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>CEP: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <input class="form-control" placeholder="CEP" id="cep" name="cep" type="text" value="${sessionScope.usuario.cep}" class="validate" >
            </div>
            <%--<div class="col-sm-3">--%>
            <%--<a href="#" title="Edit Language"><i class="fas fa-pencil-alt" aria-hidden="true"></i> <i>Edit</i></a>--%>
            <%--</div>--%>
        </div>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Numero: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <p>
                    <input class="form-control" placeholder="Numero" id="numero" name="numero" type="text" value="${sessionScope.usuario.numero}" class="validate" >
                </p>
            </div>
        </div>

        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Senha: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <p>
                    <input class="form-control" placeholder="Senha" id="senha" name="senha" type="password" value="${sessionScope.usuario.senha}" class="validate">
                </p>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
            <button type="submit" class="btn btn-social">Salvar</button>
        </div>
    </form>
</div>