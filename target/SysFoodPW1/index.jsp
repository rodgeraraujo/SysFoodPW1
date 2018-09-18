<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 28/08/2018
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<!DOCTYPE html>
<html>
<head>
  <title>Sysfood - Usuários</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">--%>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
  <h4>Usuários</h4>
  <div class="row">
    <div class="col l6">
      <div class="row">

    <form method="post" enctype="multipart/form-data"
          action="/front?action=CadastrarUsuario" class="col l5 offset-l1">
      <h5>Cadastro</h5>
      <div class="row">
        <div class="input-field col l6">
          <label for="nome">Nome</label>
          <input placeholder="Nome" id="nome" name="nome" type="text" class="validate" required>
        </div>

        <div class="input-field col l6">
          <label for="email">E-mail</label>
          <input placeholder="E-mail" id="email" name="email" type="email" class="validate" required>
        </div>

        <div class="input-field col l6">
          <label for="profissao">Pofissão</label>
          <input placeholder="Profissao" id="profissao" name="profissao" type="text" class="validate" required>
        </div>

        <div class="input-field col l6">
          <label for="rua">Rua</label>
          <input placeholder="Rua" id="rua" name="rua" type="text" class="validate" required>
        </div>

        <div class="input-field col l6">
          <label for="numero">Número</label>
          <input placeholder="Numero" id="numero" name="numero" type="text" class="validate" required>
        </div>

        <div class="input-field col l6">
          <label for="cidade">Cidade</label>
          <input placeholder="Cidade" id="cidade" name="cidade" type="text" class="validate" required>
        </div>

        <div class="input-field col l6">
          <label for="estado">Estado</label>
          <input placeholder="Estado" id="estado" name="estado" type="text" class="validate" required>
        </div>

        <div class="input-field col l6">
          <label for="cep">CEP</label>
          <input placeholder="CEP" id="cep" name="cep" type="text" class="validate" required>
        </div>

        <div class="input-field col l6">
          <label for="radio-1">Masculino</label>
          <input class="mdc-radio__native-control" id="radio-1" name="sexo" value="M" type="radio" class="validate" required>
          <br>
          <label for="radio-2">Feminino</label>
          <input class="mdc-radio__native-control" id="radio-2" name="sexo" value="F" type="radio" class="validate" required>
        </div>

      </div>
      <div class="row">
        <div class="file-field input-field col l12">
          <div class="btn">
            <span>Foto</span>
            <input name="fotoPerfil" id="fotoPerfil" type="file" accept="image/*" required>
            <input class="file-path validate" type="text" disabled>
          </div>
          <div class="file-path-wrapper">

          </div>
        </div>
      </div>
      <div class="row">
        <div class="input-field col l6">
          <label for="descricao">Descrição</label>
          <input placeholder="Descrição" id="descricao" name="descricao" type="text" class="validate" required>
        </div>
        <div class="input-field col l6">
          <label for="telefone">Telefone</label>
          <input placeholder="Telefone" id="telefone" name="telefone" type="text" class="validate" required>
        </div>
        <div class="input-field col l6">
          <label for="Senha">Senha</label>
          <input placeholder="Senha" id="senha" name="senha" type="password" class="validate" required>
        </div>
      </div>

      <button class="btn-large waves-effect waves-light" type="submit" name="action">CADASTRAR
        <i class="material-icons right">send</i>
      </button>
    </form>
  </div>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<%--<jsp:include page="errorToast.jsp"/>--%>
</body>
</html>