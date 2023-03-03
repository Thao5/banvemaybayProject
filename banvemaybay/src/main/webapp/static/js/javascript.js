


function timeNow(){
  var today = new Date();
  var gio = today.getHours();
  var phut = today.getMinutes();
  var giay = today.setSeconds();
  document.getElementById("time").innerHTML= gio +":"+phut+":"+giay;
  setTimeout("timeNow",1000);
}
$(document).ready(function(){
  $('#datepicker').datepicker();
});


