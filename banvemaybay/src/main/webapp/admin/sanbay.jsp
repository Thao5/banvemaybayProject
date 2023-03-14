<%@page import="com.banvemaybay.model.SanBay"%>
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
        <script src="../static/css/javascript.js"></script>

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
               <form class="d-flex" method="post">
                  <input name = "key" class="form-control me-2" type="text" placeholder="Search">
                  <input class="btn btn-primary" type="submit">
                </form>
              </div>
            </div>
          </nav>
           <!-- end of navbar -->
           <div>
           
            <table id="table_san_Bay" >
                <tr>
                    <th>ID Sân Bay</th>
                    <th>Tên Sân Bay</th>
                   
                    <th>Địa chỉ </th>
                    <th>Liên lạc</th>
                   
                    <th>Check</th>
                    
                  </tr>
                  <%if (request.getAttribute("listsb") != null){
								List<SanBay> listsb = (List<SanBay>) request.getAttribute("listsb");	
								if(listsb.size() > 0){
									for(SanBay cb : listsb){
								%>
                <tr >
                  <td ><%=cb.getId()%></td>
                  <td ><%=cb.getName()%></td>
                  <td ><%=cb.getDia_chi()%></td>
                  <td ><%=cb.getLien_lac()%></td>
                 
                  <td>
                    <a class="btn btn-primary" href="/banvemaybay/admin/delsb?id=<%=cb.getId()%>">Xoá</a>
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
                        <div class="form-floating mb-1 mt-3 col-sm-3">
							<input type="text" class="form-control form_tenSanBay" id="ten_Sanbay"required
								 placeholder="ten_Sanbay" name="ten_Sanbay">
							<label for="ten_Sanbay">Tên Sân Bay</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-3">
							<input type="text" class="form-control form_add" id="address"required
								 placeholder="address" name="address">
							<label for="address">Địa chỉ</label>
						</div>
                        <div class="form-floating mb-1 mt-3 col-sm-3" >
							<input type="text" class="form-control form_contact"id="contact" required
								 placeholder="contact" name="contact">
							<label for="contact" >Liên lạc</label>
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
    var index, table = document.getElementById('table_san_Bay');
            for(var i = 1; i < table.rows.length; i++)
            {
                
                table.rows[i].cells[4].onclick = function()
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
    var a =document.getElementsByClassName("form_san_Bay").value
    var b =document.getElementsByClassName("form_tenSanBay").value
    var c =document.getElementsByClassName("form_add").value
    var d =document.getElementsByClassName("form_contact").value
   
    var table =document.getElementById("table_san_Bay")
     var newRow = table.insertRow(table.length),
     cell1 = newRow.insertCell(0),
     cell2 = newRow.insertCell(1),
     cell3 = newRow.insertCell(2),
     cell4 = newRow.insertCell(3),
     
    
     
     cell9 = newRow.insertCell(4),
     id_sanbay = document.getElementById("id_sanBay").value,
     
     tenSanBay = document.getElementById("ten_Sanbay").value,

     add = document.getElementById("address").value,

     contact = document.getElementById("contact").value
    
  cell1.innerHTML = id_sanbay
  cell2.innerHTML = tenSanBay
  cell3.innerHTML = add 
  cell4.innerHTML = contact

  var cotCheck = `
  <button class="btn btn-danger" onclick="btnXoa()" type="button">Xoá</button>
`;
cell9.innerHTML = cotCheck;
   

     
}
  
</script>



    </body>