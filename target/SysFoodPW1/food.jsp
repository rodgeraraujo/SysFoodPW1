<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 13/10/2018
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title">Cadastrar Comida</h4>
</div>
<div class="modal-body">
    <form method="post" enctype="multipart/form-data"
          action="/front?action=CadastrarComida" class="col l5 offset-l1">
        <div class="row modal-row">
            <div class="col-sm-3">
                <label>Nome: </label>
            </div>
            <div class="col-sm-5">
                <input class="form-control" placeholder="Nome" id="nome" name="nome" type="text" class="validate" required>
            </div>
        </div>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Foto: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <input class="form-control" name="fotoComida" id="fotoComida" type="file" accept="image/*" required>
            </div>
        </div>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Descrição: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <textarea class="form-control" placeholder="Descrição" name="descricao" id="descricao" cols="20" rows="10"></textarea>
            </div>
        </div>
        <div class="row modal-row">
            <div class="col-sm-3">
                <p>
                    <label>Descrição: </label>
                </p>
            </div>
            <div class="col-sm-5">
                <input type="date" class="form-control" name="dataComida" id="dataComida">
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
            <button type="submit" class="btn btn-social">Salvar</button>
        </div>
    </form>
</div>