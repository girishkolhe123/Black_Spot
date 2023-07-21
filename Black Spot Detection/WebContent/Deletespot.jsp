
<%@ page import= "com.spot.services.*" %>
<%@ page import= "java.sql.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			
	<%
	
		String location = request.getParameter("name");
		Connection con = ConnectDB.getConnect();
		PreparedStatement ps1 = con.prepareStatement("delete from spot where Location=?");
		ps1.setString(1, location);
		
		int i = ps1.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("ViewSpot.jsp");
		}
		else
		{
			response.sendRedirect("Viewspot.jsp");
		}
				
	
	%>



</body>
</html>