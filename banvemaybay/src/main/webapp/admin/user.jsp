<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.List"%>
	<%@page import="com.banvemaybay.model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
      />
   
      <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
        <meta charset="UTF-8">
        <title>Home</title>
        <link rel='shortcut icon' href='' />
        <link rel="stylesheet" href="../static/css/user.css"/>
        <script src="../static/js/javascript.js"></script>

      <link rel='shortcut icon' href='https://findicons.com/files/icons/2792/hex_icons/128/anomaly_korea.png' />
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

      <script src="../static/js/jquery-3.6.0.min.js"></script>
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>
         <!-- start of navbar -->
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="/banvemaybay/admin">Admin</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                   <li class="nav-item">
                    <a class="nav-link" href="/banvemaybay/admin/ChuyenBay">Chuyến bay</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/banvemaybay/admin/ve">Vé</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/banvemaybay/admin/booking">Booking</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/banvemaybay/admin/maybay">Máy bay</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/banvemaybay/admin/sanbay">Sân bay</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/banvemaybay/admin/user">User</a>
                  </li>
<li class="nav-item">
                    <a class="nav-link" href="/banvemaybay/admin/thongke">Thống kê</a>
                  </li>
                 <li class="nav-item">
                    <a class="nav-link" href="/banvemaybay/admin/signoutadmin">Sign out</a>
                  </li>
                </ul>
               <form class="d-flex" method="post">
                  <input name = "key" class="form-control me-2" type="text" placeholder="Search">
                  <input class="btn btn-primary" type="submit">
                </form>
              </div>
            </div>
          </nav>
           <!-- end of navbar -->
           <div>
           
            <table id="table_user" >
                <tr>
                    <th>ID</th>
                    <th>Last&Middle Name</th>
                    <th>First Name</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Admin</th>
                    <th>Check</th>
                  </tr>
                 <% if(request.getAttribute("listuser") != null){
						List<User> listuser = (List<User>) request.getAttribute("listuser");
						if(listuser.size() > 0){
							for(User u : listuser){

				 %>
                <tr >
                  <td ><%= u.getId() %></td>
                  <td ><%= u.getLastname() %></td>
                  <td ><%= u.getName() %></td>
                  <td ><%= u.getSdt() %></td>
                  <td ><%= u.getEmail() %> </td>
                  <td ><%= u.getUsername() %></td>
                  <td ><%= u.getPassword() %></td>
                  <td><%= u.isAdmin() %></td>
                  <td>
                    <a class="btn btn-primary" href="/banvemaybay/admin/deluser?id=<%=u.getId()%>">Xoá</a>
                  </td>
                </tr>
                <%}
					}
					}%>
               
              </table>

           </div>
        
           <div class="col-sm-12">
			
			<div>
				<form action="" method="post">
					<div class="row">
                        <div class="form-floating mb-1 mt-3 col-sm-2">
							<input type="text" class="form-control form_name_lastmid" id="last_middle_name"
								 placeholder="Last&Middle Name" name="last_middle_name">
							<label for="last_middle_name">Last&Middle Name</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-2">
							<input type="text" class="form-control form_name_first" id="first_name"
								 placeholder="First Name" name="first_name">
							<label for="first_name">First Name</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-2">
							<input type="number" class="form-control form_phone_number"id="phone"
								 placeholder="Phone" name="phone">
							<label for="phone">Phone</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-2">
							<input type="email" class="form-control form_email"id="email"
								 placeholder="email" name="email">
							<label for="email">Email</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-2">
							<input type="text" class="form-control form_username" id="user_name"
								 placeholder="user_name" name="user_name">
							<label for="user_name">User Name</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-1">
							<input type="password" class="form-control form_pass" id="pw"
								 placeholder="PassWord" name="pw">
							<label for="pw">PassWord</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-1">
							<input type="text" class="form-control form_for_admin" id="admin_id"
								 placeholder="Admin" name="admin_id">
							<label for="admin_id">Admin</label>
						</div>

					</div>
					
					<input class="btn btn-success" id="btn-them" onclick="btnThem()" type="submit">
				</form>
			</div>
		</div>
	</div>
	</div>

<script>

function btnXoa() {
    var index, table = document.getElementById('table_user');
            for(var i = 1; i < table.rows.length; i++)
            {
                
                table.rows[i].cells[8].onclick = function()
                {
                    var c = confirm("do you want to delete this row");
                    if(c === true)
                    {
                        index = this.parentElement.rowIndex;
                        table.deleteRow(index);
                    }
                    
                    
                };
                
            }

}

function btnThem() {

var table =document.getElementById("table_user")
 var newRow = table.insertRow(table.length),
 cell1 = newRow.insertCell(0),
 cell2 = newRow.insertCell(1),
 cell3 = newRow.insertCell(2),
 cell4 = newRow.insertCell(3),
 cell5 = newRow.insertCell(4),
 cell6 = newRow.insertCell(5),
 cell7 = newRow.insertCell(6),
 cell8 = newRow.insertCell(7),
 cell9 = newRow.insertCell(8),
 id = document.getElementById("id_user").value,
 
 name = document.getElementById("last_middle_name").value,
 timedi = document.getElementById("first_name").value,
 timeden = document.getElementById("phone").value,
 soluong = document.getElementById("email").value,
 diemdi = document.getElementById("user_name").value,
 diemden = document.getElementById("pw").value,
 giatien = document.getElementById("admin_id").value
 cell1.innerHTML = id
cell2.innerHTML = name
cell3.innerHTML = timedi  
cell4.innerHTML = timeden
cell5.innerHTML = soluong
cell6.innerHTML = diemdi
cell7.innerHTML = diemden
cell8.innerHTML = giatien
var cotCheck = `
<button class="btn btn-danger" onclick="btnXoa()" type="button">Xoá</button>
`;
cell9.innerHTML = cotCheck;

 
 
}
  
</script>



    </body>