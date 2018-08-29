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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
  <h4>Funcionários</h4>
  <div class="row">
    <div class="col l6">
      <div class="row">

    <form method="post" enctype="multipart/form-data"
          action="/front?action=CadastraruUsuario" class="col l5 offset-l1">
      <h5>Cadastro</h5>
      <div class="row">
        <div class="input-field col l6">
          <input placeholder="Nome" id="nome" name="nome" type="text" class="validate" required>
          <label for="nome">Nome</label>
        </div>
        <div class="input-field col l6">
          <input placeholder="E-mail" id="email" name="email" type="email" class="validate" required>
          <label for="email">E-mail</label>
        </div>
      </div>
      <div class="row">
        <div class="file-field input-field col l12">
          <div class="btn">
            <span>Foto</span>
            <input name="foto" id="foto" type="file" accept="image/*" required>
          </div>
          <div class="file-path-wrapper">
            <input class="file-path validate" type="text">
          </div>
        </div>
      </div>
      <div class="row">
        <div class="input-field col l6">
          <input placeholder="Telefone 1" id="telefone1" name="telefone1" type="text" class="validate" required>
          <label for="telefone1">Telefone 1</label>
        </div>
        <div class="input-field col l6">
          <input placeholder="Telefone 2" id="telefone2" name="telefone2" type="text" class="validate" required>
          <label for="telefone2">Telefone 2</label>
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