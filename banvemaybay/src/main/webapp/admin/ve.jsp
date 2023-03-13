<%@page import="java.util.List"%>
<%@page import="com.banvemaybay.model.Ve"%>
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
           
            <table id="table_ve" >
                <tr>
                    <th>ID</th>
                    <th>Giá tiền</th>
                    <th>Ngày xuất vé</th>
                    <th>Trạng thái</th>
                    <th>Mã chuyến bay</th>
                    <th>Booking_ID</th>
                    <th>Check</th>
                    
                  </tr>
                  <%if(request.getAttribute("listve") != null){
						List<Ve> listve = (List<Ve>) request.getAttribute("listve");
						if(listve.size() > 0){
							for(Ve v : listve){
						
					 %>
                <tr >
                  <td ><%= v.getId() %></td>
                  <td ><%= v.getGia_tien() %></td>
                  <td ><%= v.getNgay_xuat_ve()%></td>
                  <td ><%= v.isTrang_thai_ve() %></td>
                  <td ><%= v.getChuyenbay_id() %></td>
                  <td ><%= v.getBooking_id() %></td>
                  <td>
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
                        <div class="form-floating mb-1 mt-3 col-sm-1">
							<input type="number" class="form-control form_money" id="money_ve"
								 placeholder="Money" name="money_ve">
							<label for="money_ve">Money</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-2">
							<input type="text" class="form-control form_tt"id="trangThai"
								 placeholder="Trạng Thái" name="trangThai">
							<label for="trangThai">Trạng thái</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-2">
							<input type="text" class="form-control form_Fly"id="fly"
								 placeholder="Trạng Thái" name="fly">
							<label for="fly">Mã Chuyến bay</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-2">
							<input type="text" class="form-control form_bookId" id="book_id"
								 placeholder="Trạng Thái" name="book_id">
							<label for="book_id">Booking ID</label>
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
    var index, table = document.getElementById('table_ve');
            for(var i = 1; i < table.rows.length; i++)
            {
                
                table.rows[i].cells[6].onclick = function()
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

    var table =document.getElementById("table_ve")
     var newRow = table.insertRow(table.length),
     cell1 = newRow.insertCell(0),
     cell2 = newRow.insertCell(1),
     cell3 = newRow.insertCell(2),
     cell4 = newRow.insertCell(3),
     cell5 = newRow.insertCell(4),
     cell6 = newRow.insertCell(5),
     
     cell9 = newRow.insertCell(6),
     id = document.getElementById("id_ve").value,
     
     moneyVe = document.getElementById("money_ve").value,
   
     ngayIn = document.getElementById("date_print").value,
     trangThai = document.getElementById("trangThai").value,
     fly = document.getElementById("fly").value,
     idbook = document.getElementById("book_id").value
  cell1.innerHTML = id
  cell2.innerHTML = moneyVe
  cell3.innerHTML = ngayIn 
  cell4.innerHTML = trangThai
  cell5.innerHTML = fly
  cell6.innerHTML = idbook

  var cotCheck = `
  <button class="btn btn-primary" onclick="btnXoa()" type="button">Xoá</button>
`;
cell9.innerHTML = cotCheck;
console.log(id)

 
 
}
  
</script>



    </body>