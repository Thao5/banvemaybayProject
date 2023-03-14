<%@page import="com.banvemaybay.model.MayBay"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="../static/css/ve.css"/>
        <script src="../static/js/javascript.js"></script>

      <link rel='shortcut icon' href='https://findicons.com/files/icons/2792/hex_icons/128/anomaly_korea.png' />
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

      <script src="jquery-3.6.0.min.js"></script>
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
                <form class="d-flex">
                  <input class="form-control me-2" type="text" placeholder="Search">
                  <button class="btn btn-primary" type="button">Search</button>
                </form>
              </div>
            </div>
          </nav>
           <!-- end of navbar -->
           <div>
           
            <table id="table_maybay" >
                <tr>
                    <th>ID Máy bay</th>
                    <th>Tên máy bay</th>
                   
                    <th>Số ghế</th>
                    <th>Năm sản xuất</th>
                    <th>ID Chuyến bay</th>
                    <th>Check</th>
                    
                  </tr>
                  <%if (request.getAttribute("listmb") != null){
								List<MayBay> listmb = (List<MayBay>) request.getAttribute("listmb");	
								if(listmb.size() > 0){
									for(MayBay cb : listmb){
								%>
                <tr >
                  <td ><%= cb.getId() %></td>
                  <td ><%= cb.getName() %></td>
                  <td ><%= cb.getSo_ghe() %></td>
                  <td ><%= cb.getNam_san_xuat() %></td>
                  <td ><%= cb.getChuyenbay_id() %></td>
                 
                  <td>
                    <a class="btn btn-primary" href="/banvemaybay/admin/delmb?id=<%=cb.getId()%>">Xoá</a>
                  </td>
                </tr>
               <%}}}%>
              </table>

           </div>

        
           <div class="col-sm-12">
			
			<div>
				<form action="" method="post">
					<div class="row">
                        <div class="form-floating mb-1 mt-3 col-sm-3">
							<input type="text" class="form-control form_tenMB" id="tenMayBay"
								 placeholder="date_Dat" name="tenMayBay">
							<label for="tenMayBay">Tên máy bay</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-3">
							<input type="number" class="form-control form_so_ghe" id="soGhe"
								 placeholder="soGhe" name="soGhe">
							<label for="soGhe">Số ghế</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-3">
							<input type="number" class="form-control form_nam_san_xuat"id="namSanXuat"
								 placeholder="namSanXuat" name="namSanXuat">
							<label for="namSanXuat">Năm sản xuất</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-2">
							<input type="text" class="form-control form_Chuyen_Bay" id="id_chuyenbay"
								 placeholder="ID" name="id_chuyenbay">
							<label for="id_chuyenbay">ID chuyến bay</label>
						</div>
					</div>
					
					<input class="btn btn-primary" id="btn-them" onclick="btnThem()" type="submit">
				</form>
			</div>
		</div>
	</div>
	</div>

<script>

function btnXoa() {
    var index, table = document.getElementById('table_maybay');
            for(var i = 1; i < table.rows.length; i++)
            {
                
                table.rows[i].cells[5].onclick = function()
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

    var table =document.getElementById("table_maybay")
     var newRow = table.insertRow(table.length),
     cell1 = newRow.insertCell(0),
     cell2 = newRow.insertCell(1),
     cell3 = newRow.insertCell(2),
     cell4 = newRow.insertCell(3),
     cell5 = newRow.insertCell(4),
    
     
     cell9 = newRow.insertCell(5),
     id = document.getElementById("id_maybay").value,
     
     nameMB = document.getElementById("tenMayBay").value,
   
     soluong = document.getElementById("soGhe").value,
     year = document.getElementById("namSanXuat").value,
     idchuyenbay = document.getElementById("id_chuyenbay").value
    
  cell1.innerHTML = id
  cell2.innerHTML = nameMB
  cell3.innerHTML = soluong 
  cell4.innerHTML = year
  cell5.innerHTML = idchuyenbay

  var cotCheck = `
  <button class="btn btn-danger" onclick="btnXoa()" type="button">Xoá</button>
`;
cell9.innerHTML = cotCheck;
console.log(id)

 
 
}
  
</script>



    </body>