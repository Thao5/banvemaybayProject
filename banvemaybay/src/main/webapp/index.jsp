<%@page import="com.banvemaybay.model.ChuyenBay"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<script src="static/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script src="static/js/javascript.js"></script>
<script src="static/js/indexjs.js"></script>

<meta charset="UTF-8">
<title>Home</title>
<link rel='shortcut icon' href='' />
<link rel="stylesheet" href="static/css/style.css" />
<link rel="stylesheet" href="static/css/styles.css" />

<link rel='shortcut icon'
	href='https://findicons.com/files/icons/2792/hex_icons/128/anomaly_korea.png' />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


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
<body onload="startTime()">
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
	<div class="search">
		<div class="Main" id="main">
			<div class="Holders">
				<form action="/banvemaybay/index" method="post">
					<div class="Ins">
						<select id="tp" name="slb_diemDi">
							<option value="" selected>Chọn điểm đi(tất cả)</option>
							<%
							if (request.getAttribute("listaddresssb") != null) {
								List<String> listaddress = (List<String>) request.getAttribute("listaddresssb");
								if (listaddress.size() > 0) {
									for (String address : listaddress) {
							%>
							<option value="<%=address%>"><%=address%></option>
							<%
							}
							}
							}
							%>
						</select> <select id="tp" name="slb_diemDen">
							<option value="" selected>Chọn điểm đến(tất cả)</option>
							<%
							if (request.getAttribute("listaddresssb") != null) {
								List<String> listaddress = (List<String>) request.getAttribute("listaddresssb");
								if (listaddress.size() > 0) {
									for (String address : listaddress) {
							%>
							<option value="<%=address%>"><%=address%></option>
							<%
							}
							}
							}
							%>
						</select> <input type="text" aria-label="Last name"
							class="form-control txt-NgayDi" id="datepicker" name="txt_ngayDi"
							placeholder="Chọn ngày khởi điểm" font-weight:bold> <input
							type="submit" value="Search">
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<form id="login-form" method="post">
				<input type="text" id="login" class="fadeIn second" name="login"
					placeholder="name"> <input type="text" id="password"
					class="fadeIn third" name="login" placeholder="password"> <input
					type="submit" class="fadeIn fourth" value="Log In">
			</form>
		</div>
	</div>
	<p class="line">
		Choose a <a href="">deprating</a> fly
	</p>


	<div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<div class="table-choose">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Giờ khởi hành</th>
								<th>Tên chuyến bay</th>
								<th>điểm đi</th>
								<th>điểm đến</th>
								<th>Giá vé</th>
							</tr>
						</thead>
						<tbody>
						<%if (request.getAttribute("listcb") != null){
								List<ChuyenBay> listcb = (List<ChuyenBay>) request.getAttribute("listcb");	
								if(listcb.size() > 0){
									for(ChuyenBay cb : listcb){
								%>
							<tr>
								<td><%=cb.getThoi_gian_xuat_phat() %> </td>
								<td><%=cb.getName() %></td>
								<td><%=cb.getDiem_di() %></td>
								<td><%=cb.getDiem_den() %></td>
								<td><%=cb.getGia_tien() %></td>
							</tr>
						<%}
									}
									}%>

						</tbody>

					</table>

				</div>

			</div>
		</div>
	</div>

	<form class="d-flex">

		<button class="btn btn-primary show-fly" type="button">Show
			All Flights</button>
	</form>
	<div class="content">
		<div class="check-photo">
			<img class="img"
				src="https://1.bp.blogspot.com/-cnqvDDnG_-c/W5HVURkNRYI/AAAAAAAAIXU/l42nCk73EowoOwqB-sIAsKn4ZS88tZnCwCLcBGAs/w1200-h630-p-k-no-nu/hinh%2Banh%2Bmay%2Bbay%2B%25281%2529.jpg"
				alt="">
		</div>





		<div class="price-rating">
			<p class="open">
				Price rating <small class="buy-soon">Buy soon</small>
			</p>
			<div>We recommend booking soon. The average cost of this
				Flightsis $750, but could rise 19% to $885 in two weeks</div>
			<div>
				<p class="time-content ">Thời gian hiện tại</p>
				<p id="cooldown"></p>
			</div>


			<script>
				function startTime() {
					const date = new Date();
					document.getElementById("cooldown").innerHTML = date
							.toLocaleTimeString();
					setTimeout(function() {
						startTime()
					}, 1000);
				}
			</script>
		</div>





		<!-- <div onload="hienthithoigian">
    <h2>Thời gian hiện tại là:<span id="thoigian">
  
    </span></h2>
  
  </div>
  
  <script>
    
    let today = new Date()
    var gio = today.getHours()
    var phut = today.getMinutes()
    let giay = today.setSeconds()
    document.getElementById("thoigian").innerHTML= gio +":"+phut+":"+giay
    setTimeout("hienthithoigian",1000) -->
</body>




</html>

