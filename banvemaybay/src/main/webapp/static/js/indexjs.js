$(document).ready(function(){
    $('#datepicker').datepicker();
});

$(document).ready(function() {
  $('#signin').click(function() {
    $('#formContent').fadeIn(2000); 
    document.getElementById('login-form').style.display ='block';
  });
  $('#signup').click(function() {
    $('#formContent2').fadeIn(2000); 
    document.getElementById('login-form2').style.display ='block';
  });
});
$(document).ready(function(){
        $('.dropdown-toggle').dropdown()
});