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
 * Servlet implementation class Police
 */
@WebServlet("/Police")
public class Police extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Police() {
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
		
		String station_name = request.getParameter("name");
		String station_address = request.getParameter("add");
		String station_contact = request.getParameter("mbl");
		String station_email = request.getParameter("email");
		String station_password = request.getParameter("password");
		
		try
		{
			Connection con = ConnectDB.getConnect();
			
			PreparedStatement ps1 = con.prepareStatement("insert into police values(?,?,?,?,?)");
			ps1.setString(1, station_name);
			ps1.setString(2, station_address);
			ps1.setString(3, station_contact);
			ps1.setString(4, station_email);
			ps1.setString(5, station_password);
		
			
			int i = ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("Policereg.html");
			}
			else
			{
				response.sendRedirect("Addpolice.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
