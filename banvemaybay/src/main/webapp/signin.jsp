<%@ page import="com.banvemaybay.controller.SignInController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<meta charset="UTF-8">
<link rel="stylesheet" href="static/css/signin.css">
<title>Sign In</title>
<link rel="stylesheet" href="static/css/style.css" />
<script src="static/js/javascript.js"></script>

<link rel='shortcut icon'
	href='https://findicons.com/files/icons/2792/hex_icons/128/anomaly_korea.png' />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/signin.css">

<script src="jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<!-- <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"> -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
	function see_pass() {
		const temp = document.getElementById("password").getAttribute('type');
		document.getElementById("password").setAttribute('type',
				temp === 'password' ? 'text' : 'password');
	}

	function hidden_ex() {
		document.getElementById("ex").innerHTML = null;
	}
</script>

</head>

<body
	style="background-image: url('https://images.pexels.com/photos/91217/pexels-photo-91217.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'); background-repeat: no-repeat; background-size: cover;">
	<div class="header">
		<div class="title">
			<h1>Airline</h1>
		</div>
		<%
		String name = (String) session.getAttribute("user");
		if (name == null) {
		%>
		<nav style="text-align: center;">
			<a href="index.jsp"
				style="background-color: rgba(255, 255, 255, 0.9); text-align: center;">Flights</a>
			<a href="#" id="signin"
				style="background-color: rgba(255, 255, 255, 0.9);">Sign in</a> <a
				href="signup.jsp" id="signup">Sign up</a>
		</nav>
		<%
		} else {
		%>
		<div>
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-bs-toggle="dropdown">User name</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="#">lock out</a></li>
			</ul>
		</div>

		<%
		}
		%>
	</div>
	<br>
	<br>
	<div id="login" class="col-md-7 signin" style="margin: auto">
		<br>
		<form method="post" action="signin" style="padding: 1rem;">
			<!-- nhập tên đăng nhập -->
			<div class="form-floating mb-3 mt-3">
				<input type="text" class="form-control" id="username"
					name="username" placeholder="Nhập Tên Đăng nhập" required
					onclick="hidden_ex()"
					value="<%
					String user = null;
					Cookie[] cookies = request.getCookies();
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if (cookie.getName().equals("username")) {
								user = cookie.getValue();
								break;
							}
						}
						if(user != null)
							out.print(user);
					}%>">
				<label for="username">User Name <pr class="text-danger">*</pr>
				</label>
				<!--            <p class="text-danger" id="ex"></p>-->
			</div>
			<div class="form-floating mb-3 mt-3" style="display: flex;">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="password" required
					onclick="hidden_ex()" style="border-radius: 0;"
					value="<%
					String passwordString = null;
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if (cookie.getName().equals("password")) {
								passwordString = cookie.getValue();
								break;
							}
						}
						if(passwordString != null)
							out.print(passwordString);
					}%>"> <label
					for="password">password <pr class="text-danger">*</pr>
				</label>
				<button class="btn btn-light" type="button" onclick="see_pass()"
					style="border-radius: 0;">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                    <path
							d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z" />
                    <path
							d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z" />
                </svg>
				</button>

				<!--            <p class="text-danger" id="ex"></p>-->
			</div>
			<div>
				<p class="text-warning">
					có lỗi:
					<%
				String ex = (String) session.getAttribute("loiString");
				out.print(ex);
				%>
				</p>
			</div>
			<!--        <div>-->
			<!--            <p id="warning" class="text-danger">-->
			<!--                mật khẩu không chính xác </p>-->
			<!--        </div>-->
			<!-- 2 column grid layout for inline styling -->
			<div class="" style="display: flex;">
				<div class="" style="margin-right: 4rem;">
					<!-- Checkbox -->
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="remember_me"
							name="remember_me" checked /> <label class="form-check-label"
							for="remember_me" style="color: white;"> Remember me </label>
					</div>
				</div>

				<div class="col">
					<!-- Simple link -->
					<a href="#">Forgot password?</a>
				</div>
			</div>
			<br>
			<div>
				<p style="color: white;">
					You don't have an account yet? <a href="signup.jsp">Sign Up</a>
				</p>
			</div>

			<!-- Submit button -->
			<div style="text-align: center;">
				<input type="submit" value="Sign in"
					class="btn btn-primary btn-block" style="padding: 0.5rem 4rem" />
			</div>
		</form>
	</div>
	<!-- Nav tabs -->
</body>
</html>

