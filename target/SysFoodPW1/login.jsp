<%@ page import="com.ifpb.pw1.sysfood.entities.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<!DOCTYPE html>
<html lang="en" >

	<head>
	  <meta charset="UTF-8">
	  <title>Log In</title>
	 
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
	  <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
	  <link rel="stylesheet" href="./assets/pages/css/style-form.css">
	</head>

	<body>
        <%
            Usuario u = (Usuario) session.getAttribute("usuario");

            if  (u != null) {
                response.sendRedirect("home.jsp");
            }

        %>
		<br><br><br><br>
		<div class="container-2">
		<h2>Faça login!</h2>
		  <form method="post" action="/front?action=Login">
		    <div class="row">
		      <h4>Conta</h4>
		      <div class="input-group input-group-icon">
		        <input type="email" name="email" placeholder="Endereço de Email"/>
		        <div class="input-icon"><i class="fa fa-envelope"></i></div>
		      </div>
		      <div class="input-group input-group-icon">
		        <input type="password" name="senha" placeholder="Senha"/>
		        <div class="input-icon"><i class="fa fa-key"></i></div>
		      </div>
		      <input type="submit" value="Login" />
		    </div>
		    <br>
		    <div class="row">
		      <div class="input-group">
		        <label>Não possui uma conta? <a href="register.jsp"> Registre-se!</a></label>
		      </div>
		    </div>
		  </form>
		</div>
		<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script  src="./assets/pages/js/js-form.js"></script>

		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.28.4/dist/sweetalert2.all.min.js"></script>
		<script>
            var value = "${param.value}";

            if (value == 1) {
                const toast = swal.mixin({
                    toast: true,
                    position: 'top-end',
                    showConfirmButton: false,
                    timer: 3000
                });

                toast({
                    type: 'error',
                    title: 'Não possivel autenticar o usuário!'
                })
            }
            if (value == 2) {
                const toast = swal.mixin({
                    toast: true,
                    position: 'top-end',
                    showConfirmButton: false,
                    timer: 3000
                });

                toast({
                    type: 'success',
                    title: 'Deslogado com sucesso!'
                })
            }
		</script>
	</body>
</html>
