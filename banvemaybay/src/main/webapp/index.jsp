<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,700&display=swap">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">    
  <link rel="stylesheet" href="static/css/styles.css">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
  <title>Page Title</title>
</head>

  <body> 
    <div class="header">
      <div class="title">
        <h1>Airline</h1>
      </div>
      <nav>
        <a href="#">Flights</a>
        <a href="#">Sign in</a>
        <a href="#" id="signup">Sign up</a>
      </nav>
    </div>
    <!-- end of navbar -->

    <div class="Main">
      <div class="Holders">
        <div class="Ins">
          <select id="tp">
            <option value="" disabled selected>Chọn điểm đi</option>
            <option value="1">TP.HCM</option>
            <option value="2">Hanoi</option>
            <option value="3">Vinh</option>
            <option value="4">Da Nang</option>
          </select> 

          <select id="tp">
            <option value="" disabled selected>Chọn điểm đến</option>
            <option value="1">TP.HCM</option>
            <option value="2">Hanoi</option>
            <option value="3">Vinh</option>
            <option value="4">Da Nang</option>
          </select> 

          <input type="text" aria-label="Last name" class="form-control" id="datepicker" placeholder="Chọn ngày khởi điểm"">
          <button type="button">Search</button>
        </div>
      </div>
    </div>
\
    

    <script>
        $(document).ready(function(){
            $('#datepicker').datepicker();
        });
    </script>
  </body>

  </html>