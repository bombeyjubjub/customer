<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Result</title>
</head>
<body>
	<h3> รายละเอียดลูกค้า </h3>
	<form>
		<table>	
  			<tr><td>Name : </td><td> ${name}</td></tr>
  			<tr><td>Lastname : </td><td> ${lastname}</td></tr>
  			<tr><td>Username : </td><td> ${username}</td></tr>
  			<tr><td>Birthday : </td><td> ${birthday}</td></tr>
  		</table>
  		<h4> ${complete} </h4>
  		
	</form>
</body>
</html>