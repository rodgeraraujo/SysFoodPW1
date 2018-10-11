<!DOCTYPE html>
<html lang="en" >

	<head>
		<meta charset="UTF-8">
		<title>SysFood | Login page!</title>
		<link rel="stylesheet" href="assets/css/style-login.css">
	</head>

	<body>

		  <div class="wrapper">
			<div class="container">
				<h1>Faça login na SysFood!</h1>

				<form method="post" class="form" action="/front?action=Login">
					<input type="text" placeholder="Email" name="email" required>
					<input type="password" placeholder="Senha" name="senha" required>
					<input type="submit" id="login-button" value="Login">
					<%--<button type="submit" id="login-button">Login</button>--%>
					<p>Não tem uma conta? <span><a href="register.jsp">clique aqui</a></span></p>
				</form>
			</div>

			<ul class="bg-bubbles">
				<li><img width="300px" src="http://www.pngpix.com/wp-content/uploads/2016/08/PNGPIX-COM-Food-Plate-PNG-Transparent-Image.png"></li>
				<li><img width="300px" src="http://pngimg.com/uploads/bacon/bacon_PNG10906.png"></li>
				<li><img width="300px" src="http://pluspng.com/img-png/food-png-hd-food-on-flipboard-png-plate-of-food-1043.png"></li>
				<li><img width="300px" src="http://pluspng.com/img-png/food-png-snack-bowl-png-transparent-image-1530.png"></li>
				<li><img width="300px" src="http://images6.fanpop.com/image/photos/33400000/YUMMY-FAST-FOOD-fast-food-33414966-1134-757.png"></li>
				<li><img width="300px" src="https://www.koconutgrove.co.uk/images/food1.png"></li>
				<li><img width="300px" src="https://goldfoodsusa.com/wp-content/uploads/2015/12/Quinoa_hero-e1450219308588.png"></li>
				<li><img width="300px" src="http://www.pngmart.com/files/3/Grilled-Food-PNG-Transparent-Image.png"></li>
				<li><img width="300px" src="https://www.yourmomhatesthis.com/images/2016/12/Pizza-Free-PNG-Image.png"></li>
				<li><img width="300px" src="https://images-na.ssl-images-amazon.com/images/G/01/aplusautomation/vendorimages/1f39bb26-8476-4f5d-bb51-f7283a360643.png._CB306772219_.png"></li>
			</ul>
		</div>
		<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<%--<script  src="assets/js/login.js"></script>--%>
	</body>
</html>
