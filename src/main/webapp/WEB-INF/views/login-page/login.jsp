<html xmlns:th="http://www.thymeleaf.org"
	xmlns:tiles="http://www.thymeleaf.org"><!--<![endif]--><head>
<meta charset="utf-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="common-css/login.css">
</head>
<body>
	<div id="stylized" class="myform forms">
		<form action="<c:url value='/login' />" method="post">
			<h1>Login</h1>
			<p>Service Introduction Tracker</p>
			
			<label for="username">Username / Email</label>
			<input type="text" placeholder="Username / Email" required="required" class="inputLarge" id="username" name="username" value="admin">						
			<div class="spacer"></div>
			<label for="password">Password</label>			
			<input type="password" placeholder="Password" required="required" class="inputLarge" id="password" name="password" value="admin">
			<div class="divider"></div>
			<h2 id="uname_err">
				
			</h2>
			<p></p>
			<div style="float: right;">			
				<button type="submit" id="button_save" class="button_save">Login</button>
			</div>	
			<div class="spacer"></div>					
		</form>	
	</div>			

</body></html>