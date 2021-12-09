<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            
</head>
<body style="background-image: url('img/Backgrnd.jpg');background-size: cover;background-attachment: fixed;">
	<div class = "container">
	<div class="row">
		<div class = "col m6 offset-m3">
		<div class="card" >
			<div class ="card-content"><b>
			<h3 style = "color:	black solid ; text-align: center"> Register Here !!</h3>
			<h4 id ="msg"> </h4>
				</b>
			<div class = "form">
				<form style= " text-align: center" method = "post" action="./registration" id="myform">
					<input type ="text" name = "user_name" placeholder="User Name"/>
					<input type ="password" name = "user_passwd" placeholder="User Password"/>
					<input type ="email" name = "user_email" placeholder="User Email"/>
					<button class ="btn red" style = "margin-top:15px" type = "submit">
						Submit
					</button>
						<button class ="btn red" style = "margin-top:15px" type = "reset">
						Reset
					</button>
			
				</form>
			</div>
					<div class="loader center" style = "margin-top: 15px; display:none">
					  <div class="preloader-wrapper active">
						    <div class="spinner-layer spinner-blue-only">
						      <div class="circle-clipper left">
						        <div class="circle"></div>
						      </div><div class="gap-patch">
						        <div class="circle"></div>
						      </div><div class="circle-clipper right">
						        <div class="circle"></div>
						      </div>
						    </div>
						  </div>
						<h5>Please Wait....</h5>
					</div>
			</div>
		</div>
		</div>
		</div>
	</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous">
</script>
<script>
$(document).ready(function (){
	$("#myform").on('submit', function(event){
		event.preventDefault();
		var f = $(this).serialize();
		console.log(f);
		$('.loader').show();
		$('.form').hide();
		$.ajax({
			url:"./registration",
			data:f,
			type:'post',
			success: function (data,textStatus,jqXHR){
				console.log(data);
				console.log("success ...")
				$('.loader').hide();
				$('.form').show();
				if(data.trim() === 'done'){
					$('#msg').html("Successfully Registered !!")
					$('#msg').addClass('green-text');
				}else{
					$('#msg').html("Something went Wrong!!")
					$('#msg').addClass('red-text');
				}
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log(data);
				console.log("Error ...")
				$('.loader').hide();
				$('.form').show();
				$('#msg').addClass('red-text');
			}
		})
	})
})

</script>
	
</body>
</html>