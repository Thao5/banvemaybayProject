<%@page import="com.banvemaybay.services.ChuyenBayServices"%>
<%@page import="com.banvemaybay.model.ChuyenBay"%>
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
        <link rel="stylesheet" href="../static/css/chuyenbay.css"/>
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
              <a class="navbar-brand" href="admin.jsp">Admin</a>
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
           
            <table id="table_Chuyen_Bay" >
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Thời gian xuất phát</th>
                    <th>Thời gian đến</th>
                    <th>Số lượng ghế</th>
                    <th>Điểm đi</th>
                    <th>Điểm đến</th>
                    <th>Giá tiền</th>
                    <th>Sân bay di </th>
                    <th>Sân bay đến </th>
                    <th>Check</th>
                  </tr>
                  <%if (request.getAttribute("listcb") != null){
                	  			ChuyenBayServices cbs = new ChuyenBayServices();
								List<ChuyenBay> listcb = (List<ChuyenBay>) request.getAttribute("listcb");	
								if(listcb.size() > 0){
									for(ChuyenBay cb : listcb){
								%>
                <tr> <!-- id="11" -->
				
                  <td> <!-- id="id-chuyenbay" --><%= cb.getId() %></td>
                  <td> <!-- id="name-chuyenbay" --> <%= cb.getName() %></td>
                  <td> <!-- id="time-di" --> <%= cb.getThoi_gian_xuat_phat() %></td>
                  <td> <!-- id="time-den" --> <%= cb.getThoi_gian_den() %></td>
                  <td> <!-- id="soGhe"  --> <%= cb.getGhe_trong() %></td>
                  <td> <!-- id="noiDi" --> <%= cb.getDiem_di() %></td>
                  <td> <!-- id="noiDen" --> <%= cb.getDiem_den() %></td>
                  <td> <!-- id="money" --> <%= cb.getGia_tien() %></td>
                  <td> <%= cbs.getSBNameAdmin(cb.getSanbaydi_id()) %> </td>
                  <td> <%= cbs.getSBNameAdmin(cb.getSanbayden_id()) %> </td>
                  <td> <!-- id="check" --> 
                    <button class="btn btn-primary" onclick="btnXoa()" type="button">Xoá</button>
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
						<div class="form-floating mb-1 mt-3 col-sm-2" >
							<input type="text" class="form-control" id="name_Fly"
								required placeholder="Name*" name="name_Fly"> <label
								for="name_Fly">Name*</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-2" >
							<input type="datetime-local" class="form-control" id="time_di"
								required placeholder="Ngày đi" name="time_di"> <label
								for="time_di">Thời gian đi</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-2" >
							<input type="datetime-local" class="form-control" id="time_den"
								required placeholder="Ngày đến*" name="time_den"> <label
								for="time_den">Thời gian đến</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-1" >
							<input type="number" class="form-control" id="quatity"
								required placeholder="Số lượng*" name="quantity"> <label
								for="quatity">Số lượng ghế</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-1" >
							<input type="text" class="form-control" id="diem_di"
								required placeholder="Điểm đi*" name="diem_di"> <label
								for="diem_di">Điểm đi*</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-1" >
							<input type="text" class="form-control" id="diem_den"
								required placeholder="Điểm đến*" name="diem_den"> <label
								for="diem_den">Điểm đến*</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-1" >
							<input type="number" class="form-control" id="giaTien"
								required placeholder="giaTien*" name="giaTien"> <label
								for="giaTien">Giá tiền*</label>
						</div>
						<div class="form-floating mb-1 mt-3 col-sm-1" >
							<select name="slb_SBDi">
								<option value="" selected>Sân Bay Đi</option>
								<%if(request.getAttribute("listsb") != null){
									List<String> listsb = (List<String>) request.getAttribute("listsb");
									if(listsb.size() > 0){
										for(String s : listsb){
											
									%>
									<option value = "<%=s %>"> <%=s %> </option>
									<%}
										}
										}%>
							</select>
						</div>
						<div>
							<select name="slb_SBDen">
								<option value="" selected>Sân Bay Đến</option>
								<%if(request.getAttribute("listsb") != null){
									List<String> listsb = (List<String>) request.getAttribute("listsb");
									if(listsb.size() > 0){
										for(String s : listsb){
											
									%>
									<option value = "<%=s %>"> <%=s %> </option>
									<%}
										}
										}%>
							</select>
						</div>
					</div>
					<input class="btn btn-primary" id="btn-them" type="submit">
					
				</form>
			</div>
		</div>
	</div>
	</div>

<script>

function btnXoa() {
    var index, table = document.getElementById('table_Chuyen_Bay');
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

    var table =document.getElementById("table_Chuyen_Bay")
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
     id = document.getElementById("id_chuyenbay").value,
     
     name = document.getElementById("name_Fly").value,
     timedi = document.getElementById("time_di").value,
     timeden = document.getElementById("time_den").value,
     soluong = document.getElementById("quatity").value,
     diemdi = document.getElementById("diem_di").value,
     diemden = document.getElementById("diem_den").value,
     giatien = document.getElementById("giaTien").value
     cell1.innerHTML = id
  cell2.innerHTML = name
  cell3.innerHTML = timedi  
  cell4.innerHTML = timeden
  cell5.innerHTML = soluong
  cell6.innerHTML = diemdi
  cell7.innerHTML = diemden
  cell8.innerHTML = giatien
  var cotCheck = `
  <button class="btn btn-primary" onclick="btnXoa()" type="button">Xoá</button>
`;
cell9.innerHTML = cotCheck;
console.log(id)
//   var table = document.getElementById("table_Chuyen_Bay");
//   var a1 = document.getElementById("id-chuyenaby").value;

//   var row = table.insertRow(1);
//   var cell1 = row.insertCell(0);
//   var cell2 = row.insertCell(1);
//   var cell3 = row.insertCell(2);
//   var cell4 = row.insertCell(3);
//   var cell5 = row.insertCell(4);
//   var cell6 = row.insertCell(5);
//   var cell7 = row.insertCell(6);
//   var cell8 = row.insertCell(7);
//   var cell9 = row.insertCell(8);
  
//   // Add nội dung từng cột 
 
 
}
    //chart
</script>
<canvas id="myChart" style="width:100%;max-width:600px"></canvas>


    </body>