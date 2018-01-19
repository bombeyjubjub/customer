<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Connection connect = null;
	Statement s = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");

		connect =  DriverManager.getConnection("jdbc:mysql://localhost/gosoft" +
				"?user=root&password=12345678");
		
		s = connect.createStatement();
		
		String sql = "SELECT * FROM  customer";
		
		ResultSet rec = s.executeQuery(sql);
		%>
		<table>
		  <tr>
		    <td> CustomerID </td>
		    <td> Name </td>
		    <td> Lastname </td>
		    <td> Username </td>
		    <td> Password </td>
		    <td> Birthday </td>
		  </tr>	
			<%while((rec!=null) && (rec.next())) { %>
				  <tr>
				    <td><%=rec.getInt("cus_id")%></td>
				    <td><%=rec.getString("cus_name")%></td>
				    <td><%=rec.getString("cus_lastname")%></td>
				    <td><%=rec.getString("cus_username")%></td>
				    <td><%=rec.getString("cus_password")%></td>
				    <td><%=rec.getString("cus_birthday")%></td>
				  </tr>
	       	<%}%>
	  	</table>      
	    <%	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	
		try {
			if(s!=null){
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	%>

</body>
</html>