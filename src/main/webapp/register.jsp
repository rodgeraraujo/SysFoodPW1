<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 10/10/2018
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.ifpb.pw1.sysfood.entities.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<!DOCTYPE html>
<html lang="en" >
	<head>
	  	<meta charset="UTF-8">
	  	<title>Inscreva-se na SysFood!</title>
	 
	  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
		<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
		<link rel="stylesheet" href="./assets/pages/css/style-form.css">

        <script>
            function formatar(mascara, documento){
                var i = documento.value.length;
                var saida = mascara.substring(0,1);
                var texto = mascara.substring(i)

                if (texto.substring(0,1) != saida){
                    documento.value += texto.substring(0,1);
                }

            }
        </script>
	</head>

	<body>
        <%
            Usuario u = (Usuario) session.getAttribute("usuario");

            if  (u != null) {
                response.sendRedirect("home.jsp");
            }

        %>
		<div class="container">
		<h2>Inscreva-se agora na SysFood!</h2>
		  <form method="post" enctype="multipart/form-data" action="/front?action=CadastrarUsuario" >
		    <div class="row">
		      <h4>Conta</h4>
		      <div class="input-group input-group-icon">
		        <input type="text" name="nome" placeholder="Nome Completo" required/>
		        <div class="input-icon"><i class="fa fa-user"></i></div>
		      </div>
		      <div class="input-group input-group-icon">
		        <input type="email" name="email" placeholder="Endereço de Email" required/>
		        <div class="input-icon"><i class="fa fa-envelope"></i></div>
		      </div>
		      <div class="input-group input-group-icon">
		        <input type="password" name="senha" placeholder="Senha" required/>
		        <div class="input-icon"><i class="fa fa-key"></i></div>
		      </div>
		    </div>

		    <div class="row">
		      <div class="col-half">
                  <%--NÃO IMPLEMENTADO NO BANCO - DATA DE ANIVERSÁRIO--%>
		        <h4>Data de Aniversário</h4>
		        <div class="input-group">
		          <div class="col-third">
		            <input type="text" name="dia" placeholder="DD" OnKeyPress="formatar('##', this)" required/>
		          </div>
		          <div class="col-third">
		            <input type="text" name="mes" placeholder="MM" OnKeyPress="formatar('##', this)" required/>
		          </div>
		          <div class="col-third">
		            <input type="text" name="ano" placeholder="AAAA" OnKeyPress="formatar('####', this)" required/>
		          </div>
		        </div>
		      </div>
		      <div class="col-half">
		        <h4>Gênero</h4>
		        <div class="input-group">
		          <input type="radio" name="sexo" value="M" id="gender-male" required/>
		          <label for="gender-male">Masculino</label>
		          <input type="radio" name="sexo" value="F" id="gender-female" required/>
		          <label for="gender-female">Feminino</label>
		        </div>
		      </div>
		    </div>

		    <div class="row">
		      <h4>Informações Pessoais</h4>
		      <div class="input-group input-group-icon">
		        <input type="text" name="descricao" placeholder="Descrição"/>
		        <div class="input-icon"><i class="fa fa-comment"></i></div>
		      </div>
		      <div class="input-group input-group-icon">
		        <input type="text" name="profissao" placeholder="Profissão" required/>
		        <div class="input-icon"><i class="fa fa-bookmark"></i></div>
		      </div>
		      <div class="input-group input-group-icon">
		      	<span class="control-fileupload">	
		          <label for="file" class="custom-file-label">Escolha uma imagem: </label>
		          <input type="file" name="fotoPerfil" id="file" accept="image/*" required>
                  <input class="form-control" class="file-path validate" type="text" disabled>
		        </span>
		        <!-- <div class="input-icon"><i class="fa fa-picture-o"></i></div> -->
		      </div>

		      <div class="input-group input-group-icon">
		      	<input type="text" name="telefone" placeholder="Telefone" required/>
		        <div class="input-icon"><i class="fa fa-phone-square "></i></div>
		      </div>
		 
		    </div>

		    <div class="row">
		      <h4>Endereço</h4>
		    
		      <div class="col-half">
		        <div class="input-group input-group-icon">
		          <input type="text" name="rua" placeholder="Rua" required/>
		          <div class="input-icon"><i class="fa fa-file-photo-o"></i></div>
		        </div>
		      </div>
		      <div class="col-half-1">
		        <div class="input-group">
		          <input type="text" name="numero" placeholder="Número" required/>
		        </div>
		      </div>
		      <div class="col-half-2">
		        <div class="input-group">
		          <input type="text" name="cep" placeholder="CEP"  maxlength="9"
                         OnKeyPress="formatar('#####-###', this)" required/>
		        </div>
		      </div>
		    </div>

		    <div class="row">
		     <div class="col-half">
		        <div class="input-group input-group-icon">
		          <input type="text" name="cidade" placeholder="Cidade" required/>
		          <div class="input-icon"><i class="fa fa-file-photo-o"></i></div>
		        </div>
		      </div>
		      <div class="col-half">
		        <div class="input-group">
		          <select name="estado" required>
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
		      </div>
		    </div>

		    <div class="row">
		      <h4>Termos e Condições</h4>
		      <div class="input-group">
		        <input type="checkbox" id="terms" required/>
		        <label for="terms">Eu aceito os termos e condições para se inscrever neste serviço e confirmo que li a
                    política de privacidade.</label>
		      </div>
		    </div>
		    <input type="submit" name="inscrever" value="Inscrever-se" name="action">
			
		    <div class="input-group">
		      	<br>
		        <label>Já possui uma conta? <a href="login.jsp">Fazer Login!</a></label>
		    </div>
		  </form>

		</div>
		<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script  src="./assets/pages/js/js-form.js"></script>
		<script type="application/javascript">
		    $('input[type="file"]').change(function(e){
		        var fileName = e.target.files[0].name;
		        $('.custom-file-label').html(fileName);
		    });

            var erro = "${param.erro}";
            if (erro == 1) {
                swal("Erro!", "Usuário não encontrado!", "error");
            }
            var mensagem = "${param.mensagem}";
            if(mensagem == "1"){
                swal("OK!","A conta foi excluida.","success");
            }
		</script>
	</body>
</html>
