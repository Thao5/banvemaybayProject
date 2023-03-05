<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />


<meta charset="UTF-8">
<title>Home</title>
<link rel='shortcut icon' href='' />
<link rel="stylesheet" href="static/css/style.css" />
<script src="static/js/javascript.js"></script>

<link rel='shortcut icon'
	href='https://findicons.com/files/icons/2792/hex_icons/128/anomaly_korea.png' />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<script src="jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div class="header">
		<div class="title">
			<h1>Airline</h1>
		</div>
		<nav>
			<a href="index.jsp">Flights</a> <a href="#" id="signin">Sign in</a> <a
				href="signup.jsp" id="signup">Sign up</a>
		</nav>
	</div>
	<!-- end of navbar -->
	<div class="row Chinh">
		<div class="col-sm-7">
			<h3>Sign Up</h3>
			<div>
				<form action="/banvemaybay/signup" method="post">
					<div class="row">
						<div class="form-floating mb-3 mt-3 col-sm-3">
							<input type="text" class="form-control" id="txt-firstName"
								required placeholder="First name*" name="txt-firstName">
							<label for="txt-firstName">First name*</label>
						</div>
						<div class="form-floating mb-3 mt-3 col-sm-3">
							<input type="text" class="form-control" id="txt-lastName"
								required placeholder="Last name*" name="txt-lastName"> <label
								for="txt-lastName">Last name*</label>
						</div>
					</div>
					<div class="row">
						<div class="form-floating mt-3 mb-3 col-sm-4">
							<input type="email" class="form-control" id="txt-email" required
								placeholder="Email Address*" name="txt-email"> <label
								for="txt-email">Email Address*</label>
						</div>
						<div class="form-floating mb-3 mt-3 col-sm-4">
							<input type="number" class="form-control" id="number-phone"
								required placeholder="Phone number*" name="number-phone">
							<label for="number-phone">Phone number*</label>
						</div>
					</div>
					<div class="row">
						<div class="form-floating mb-3 mt-3 col-sm-4">
							<input type="text" class="form-control" id="username" required
								placeholder="Username*" name="username"> <label
								for="username">Username</label>
						</div>
						<div class="form-floating mt-3 mb-3 col-sm-4">
							<input type="password" class="form-control" id="pw" required
								placeholder="Password*" name="pw"> <label for="pw">Password</label>
						</div>
					</div>
					<div class="row">
						<div class="form-floating mt-3 mb-3 col-sm-4">
							<input type="password" class="form-control" id="pw_confirm"
								required placeholder="Password confirm*" name="pw_confirm">
							<label for="pw_confrim">Password confirm</label>
						</div>
					</div>
					<div class="row">
						<div class="form-floating mb-3 mt-3 col-sm-4">
							<input type="submit" class="btn btn-info" value="Sign up" onclick = "lengthOfPassword();validate()">
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>



	</div>
	</div>

	<script>
            let amountElement = document.getElementById('amount')
            let amount = amountElement.value
            console.log(amount)
            let render = (amount)=>{
              amountElement.value = amount
            }
            let handlePlus = () =>{
              amount++
              render(amount);
            
            let handleMinus = () =>{
                if(amount > 1)
                amount--;
                render(amount);
            }}
            amountElement.addEventListener('input',() => {
  amount = amountElement.value;
  amount = parseInt(amount);
  amount = (isNaN(amount)||amount == 0)?1:amount;
  render(amount);
});
          </script>
	<script>
    function validate() {
    var x= document.getElementById("pw");
    var y= document.getElementById("pw_confirm");
    if(x.value==y.value) return;
    else alert("password not same");
    
    }
    
    </script>
	<script>
      function lengthOfPassword(){
        var password = document.getElementById("pw");
        var length = password.value.length;
        if (length <6 || length >20){
          alert('Please enter password from 6 to 20 letters');

        }
      }
    </script>
</body>
</html>