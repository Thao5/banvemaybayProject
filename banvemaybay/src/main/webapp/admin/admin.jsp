<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
      />
   

        <meta charset="UTF-8">
        <title>Home</title>
        <link rel='shortcut icon' href='' />
        <link rel="stylesheet" href="../static/css/admin.css"/>
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
                    <a class="nav-link" href="/banvemaybay/admin/thongke.jsp">Thống kê</a>
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

            <!-- form sign in -->
          <div class="form-login">
            <h3 class="signin">Login</h3>
            <form action="/action_page.php">
                <label for="fname">Email</label>
                <input type="text" id="fname" class="login-email" name="login-email" placeholder="Enter your email...">
            
                <label for="lname">Password</label>
                <input type="text" id="lname" class="login-password" name="login-password" placeholder="Enter your password...">
            
            
                <input type="submit" value="Submit">
            </div>
      
             <!-- end form-->
        
    </body>