package com.spot.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddSpot
 */
@WebServlet("/AddSpot")
public class AddSpot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSpot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String reason = request.getParameter("reason");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String level = request.getParameter("level");
		String city = request.getParameter("city");
		
		String z = null;
		if(level.equals("Level 0"))
		{
			z = "Yellow";
		}
		else if(level.equals("Level 1"))
		{
			z = "Orange";
		}
		else if(level.equals("Level 2"))
		{
			z = "Red";
		}
	
		
		try
		{
			Connection con = ConnectDB.getConnect();
			
			PreparedStatement ps1 = con.prepareStatement("insert into spot values(?,?,?,?,?,?,?,?)");
			ps1.setString(1, name);
			ps1.setString(2, address);
			ps1.setString(3, reason);
			ps1.setString(4, latitude);
			ps1.setString(5, longitude);
			ps1.setString(6, level);
			ps1.setString(7, z);
			ps1.setString(8, city);
		
			
			int i = ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("Spotadd.html");
				//UserData.setCity(city);
			}
			else
			{
				response.sendRedirect("Addspot.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
