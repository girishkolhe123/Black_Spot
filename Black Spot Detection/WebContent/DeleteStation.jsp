
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
	
		String stname = request.getParameter("stname");
		Connection con = ConnectDB.getConnect();
		PreparedStatement ps1 = con.prepareStatement("delete from police where stname=?");
		ps1.setString(1, stname);
		
		int i = ps1.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("ViewStation.jsp");
		}
		else
		{
			response.sendRedirect("ViewStation.jsp");
		}
				
	
	%>


</body>
</html>