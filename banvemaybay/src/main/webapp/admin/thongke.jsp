<%@page import="com.banvemaybay.model.ThongKe"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
           <!-- table -->

          <h3 class="thongke">THỐNG KÊ </h3>
          
          <div class="container-fluid">
            <div class="row">
              <div class="col-8">
                <div class="content">
                    <table id="table_thong_ke" >
                      <tr>
                          <th>Chuyến bay</th>
                          <th>Số lượng vé</th>
                          
                        </tr>
                        <%if(request.getAttribute("thongke") != null){
                        	List<ThongKe> thongke = (List<ThongKe>) request.getAttribute("thongke");
                        	if(thongke.size() > 0){
                        		for(ThongKe tk: thongke){
                        	%>
                      <tr >
                        <td><%=tk.getName() %></td>
                        <td><%=tk.getSoLuongVe() %></td>
                        
                      </tr>
                      <%}}} %>
                    </table>
                    </div>
              
              </div>  
              
              <div class="col-4">
                <canvas id="myChart"  class="bar_chart" style="width:50%;max-width:400px"></canvas>
            </div>
          </div>
			
         
          </div>
          <div class="container-fluid next_content">
            <div class="row">
              <div class="col-8">
                <div class="content">
                    <table id="table_thong_ke" >
                      <tr>
                          <th>Chuyến bay</th>
                          <th>Doanh thu</th>
                          
                        </tr>
                        <%if(request.getAttribute("thongke") != null){
                        	List<ThongKe> thongke = (List<ThongKe>) request.getAttribute("thongke");
                        	if(thongke.size() > 0){
                        		for(ThongKe tk: thongke){
                        	%>
                      <tr >
                        <td><%=tk.getName() %></td>
                        <td><%=tk.getDoanhThu() %></td>
                        
                      </tr>
                      <%}}} %>
                    </table>
                    </div>
              
              </div>  
              
              <div class="col-4">
                <canvas id="mychart"  class="bar_chart" style="width:50%;max-width:400px"></canvas>
            </div>
          </div>
			
         
          </div>
          <!-- end table -->
<!-- chart -->

<div class="col-sm-7">
			
<canvas id="myChart"  class="bar_chart" style="width:50%;max-width:400px"></canvas>
</div>

<script>
	
	var xValues = []; // truyền tên dữ liệu cần thống kê
	var yValues = []; // truyền số liệu
	<%if(request.getAttribute("thongke") != null){
		List<ThongKe> thongke = (List<ThongKe>) request.getAttribute("thongke");
		List<String> name = new ArrayList<>();
		List<Integer> soluongve = new ArrayList<>();
		if(thongke.size() > 0){
			for(ThongKe tk: thongke){
				name.add(tk.getName());
				soluongve.add(tk.getSoLuongVe());
			}
		}
		for(String s: name){%>
		xValues.push('<%=s%>');
		<%}%>
		<%for(int i: soluongve){
		%>
		yValues.push('<%=i%>');
		<%}
		}%>
var barColors = ["red", "green","blue ","orange","brown"]; // màu

new Chart("myChart", {
  type: "bar",
  data: {
    labels: xValues,
    datasets: [{
      backgroundColor: barColors,
      data: yValues
    }]
  },
  options: {
    legend: {display: false},
    title: {
      display: true,
      text: "Thống kê hãng máy bay "
    }
  }
});
</script>
<script>
var xValues = [];// truyền tên dữ liệu cần thống kê
var yValues = [];// truyền số liệu
<%if(request.getAttribute("thongke") != null){
	List<ThongKe> thongke = (List<ThongKe>) request.getAttribute("thongke");
	List<String> name = new ArrayList<>();
	List<Double> doanhthu = new ArrayList<>();
	if(thongke.size() > 0){
		for(ThongKe tk: thongke){
			name.add(tk.getName());
			doanhthu.add(tk.getDoanhThu());
		}
	}
for(String s: name){%>
xValues.push('<%=s%>');
<%}%>
<%for(double i: doanhthu){
%>
yValues.push('<%=i%>');
<%}
}%>

    var barColors = ["red", "green","blue ","orange","brown"]; // màu
    
    new Chart("mychart", {
      type: "bar",
      data: {
        labels: xValues,
        datasets: [{
          backgroundColor: barColors,
          data: yValues
        }]
      },
      options: {
        legend: {display: false},
        title: {
          display: true,
          text: "Thống kê doanh thu từng hãng "
        }
      }
    });
    </script>
    
    </body>