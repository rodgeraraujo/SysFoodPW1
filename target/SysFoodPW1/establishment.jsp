<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 25/09/2018
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title">Cadastrar novo Estabelecimento</h4>
</div>
<div class="modal-body">
    <form method="post" enctype="multipart/form-data"
          action="/front?action=CadastrarEstabelecimento" class="col l5 offset-l1">
        <div class="row modal-row">
            <div class="col-sm-3">
                <label>Nome: </label>
            </div>
            <div class="col-sm-5">
                <input class="form-control" placeholder="Nome" id="nome" name="nome" type="text" class="validate" required>
            </div>
            <%--<div class="col-sm-3">--%>
                <%--<a href="#" title="Edit Username"><i class="fas fa-pencil-alt" aria-hidden="true"></i> <i>Edit</i></a>--%>
            <%--</div>--%>
        </div>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Foto: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <%--<p>--%>
                    <%--example@email.com--%>
                <%--</p>--%>
                <input class="form-control" name="fotoPerfil" id="fotoPerfil" type="file" accept="image/*" required>
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
                <textarea class="form-control" placeholder="Descrição" name="descricao" id="descricap" cols="20" rows="10"></textarea>
            </div>
            <%--<div class="col-sm-3">--%>
                <%--<a href="#" title="Edit Password"><i class="fas fa-pencil-alt" aria-hidden="true"></i> <i>Edit</i></a>--%>
            <%--</div>--%>
        </div>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Rua: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <input class="form-control" placeholder="Rua" id="rua" name="rua" type="text" class="validate" required>
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
                    <input class="form-control" placeholder="Cidade" id="cidade" name="cidade" type="text" class="validate" required>
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
                    <option value="estado">Selecione o Estado</option>
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
                    <label>Tipo: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <select class="form-control" name="tipo">
                    <option value="tipo">Selecione o Tipo</option>
                    <option value="restaurante">Restaurante</option>
                    <option value="cafeteria">Cafeteria</option>
                    <option value="outro">Outro</option>
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
                <input class="form-control" placeholder="CEP" id="cep" name="cep" type="text" class="validate" required>
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
                    <input class="form-control" placeholder="Numero" id="numero" name="numero" type="text" class="validate" required>
                </p>
            </div>
        </div>
        <%--<div class="row modal-row">--%>
            <%--<div class="col-sm-3">--%>
                <%--<p>--%>
                    <%--<label>Status: </label>--%>
                <%--</p>--%>
            <%--</div>--%>
            <%--<div class="col-sm-5">--%>
                <%--<p>--%>
                    <%--<input class="form-control" id="status" name="status" type="checkbox" value="1" class="validate" required>--%>
                <%--</p>--%>
            <%--</div>--%>
            <%--&lt;%&ndash;<div class="col-sm-3">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a href="#" title="Edit Language"><i class="fas fa-pencil-alt" aria-hidden="true"></i> <i>Edit</i></a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--</div>--%>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Funcionamento: </label>
                </p>
            </div>
            <div class="col-sm-3">
                <div class="input-group bootstrap-timepicker timepicker">
                    <input name="funcionamento" id="timepicker1" type="time" class="form-control input-small">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
                </div>

                <script type="text/javascript">
                    $('#timepicker1').timepicker();
                </script>
            </div>
            <%--<div class="col-sm-3">--%>
            <%--<a href="#" title="Edit Language"><i class="fas fa-pencil-alt" aria-hidden="true"></i> <i>Edit</i></a>--%>
            <%--</div>--%>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
            <button type="submit" class="btn btn-social">Salvar</button>
        </div>
    </form>
</div>

