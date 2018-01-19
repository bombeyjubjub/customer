<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert here</title>
<link href ="./bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src = "./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src = "./bootstrap/js/bootstrap.min.js"></script>
</head>
<%@ page import="java.sql.*"%>  
<script type="text/javascript">
	$( document ).ready(function() {
		datacustomer();
		initialDepartment();
	});
	
	function initialDepartment(){
		$.ajax({
			type: "GET",
			url: "/CustomerRegisterWeb/DepartmentServlet",
			dataType: "json",
			success: function (data) {
				$.each(data, function(i, option){
				$('#department').append($('<option/>').attr("value", option.department_id).text(option.department_name));		
				})	
			}
		});	
	}
	function datacustomer(){
		$.ajax({
			type: "GET",
			url: "/CustomerRegisterWeb/DataCustomerServlet",
			dataType: "json",
			success: function (data) {
		        console.log(data);
		        var trHTML = '';

		        $.each(data, function (i, item)
		        {   
		            trHTML += 
		            '<tr><td>' + item.name + 
		            '</td><td>' + item.lastname + 
		            '</td><td>' + item.username + 
		            '</td><td>' + item.birthday + 
		            '</td><td>' + item.age + 
		            '</td><td>' + item.departmentName + 
		            '</td></tr>';            
		        });
		        $('#datacustomer').append(trHTML);
		    }
		});	
	}
	function saveUser(){
		var obj = new Object();
		obj.name = $("#name").val();
		obj.lastname = $("#lastname").val();
		obj.password = $("#password").val();
		obj.username = $("#username").val();
		obj.birthday = $("#birthday").val();
		obj.departmentId = $("#department").val();
		$("#success").html("Register Success");
		$.ajax({
		type: "POST",
		contentType : 'application/json',
		url: "/CustomerRegisterWeb/RegisterServlet",
		data: JSON.stringify(obj),
		success: function(result){
			alert("Register Success");
			$("#name").val("");
			$("#lastname").val("");
			$("#username").val("");
			$("#password").val("");
			$("#confirm").val("");
			$("#birthday").val("");
			window.location.reload();
		}
		});	
	}
</script>
<body>
	<div class="container">
	  <h2> ลงทะเบียนลูกค้า </h2>
	  <form class="form-horizontal" action="RegisterServlet" method="POST">
	  	<div class="form-group">
	    	<label class="control-label col-sm-2" for="name"> Name : </label>
	      	<div class="col-sm-10">
	        	<input type="text" style="width: 200px" class="form-control" id="name" name="name" width = "150px">
	      	</div>
	    </div>
	    <div class="form-group">
	    	<label class="control-label col-sm-2" for="lastname"> Lastname : </label>
	      	<div class="col-sm-10">          
	        	<input type="text" style="width: 200px" class="form-control" id="lastname" name="lastname">
	      	</div>
	    </div>
	    <div class="form-group">
	    	<label class="control-label col-sm-2" for="username"> Username : </label>
	      	<div class="col-sm-10">          
	        	<input type="text" style="width: 200px" class="form-control" id="username" name="username">
	      	</div>
	    </div>
	    <div class="form-group">
	      	<label class="control-label col-sm-2" for="password"> Password : </label>
	      	<div class="col-sm-10">          
	        	<input type="password" style="width: 200px" class="form-control" id="password" name="password">
	      	</div>
	    </div>
	    <div class="form-group">
	    	<label class="control-label col-sm-2" for="confirm"> Confirm Password : </label>
	      	<div class="col-sm-10">          
	        	<input type="password" style="width: 200px" class="form-control" id="confirm" name="confirm">
	      	</div>
	    </div>
	    <div class="form-group">
	      	<label class="control-label col-sm-2" for="birthday"> Birthday : </label>
	      	<div class="col-sm-10">          
	        	<input type="text" style="width: 200px" class="form-control" id="birthday" name="birthday">
	      </div>
	    </div>
	    <div class="form-group">
	      	<label class="control-label col-sm-2" for="department"> Department : </label>
	      	<div class="col-sm-10">          
	        	<select id="department" class="btn btn-primary dropdown-toggle" ></select>
	      	</div>
	    </div>
	    <div class="form-group">        
	      	<div class="col-sm-offset-2 col-sm-10">
	        	<input type="button" onclick = "saveUser()" value="Submit" class="btn btn-default">
	      	</div>
	    </div>
	  </form>
	</div>    
    
	<div class="container">        
	  <table id="datacustomer" class="table table-hover">
	    <thead>
	      <tr>
	        <th> Name </th>
	        <th> Lastname </th>
	        <th> Username </th>
	        <th> Birthday </th>
	        <th> Age </th>
	        <th> Department </th>
	      </tr>
	    </thead>
	  </table>
	</div>
</body>
</html>