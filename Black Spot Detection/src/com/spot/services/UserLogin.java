package com.spot.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
	

		String em = request.getParameter("email");
		
		String pass = request.getParameter("password");
		
		try
		{
			Connection con = ConnectDB.getConnect();
			String City=null;
			PreparedStatement ps1 = con.prepareStatement("select * from user where Email=? and Password=?");
			
			ps1.setString(1, em);
			ps1.setString(2, pass);
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next())
			{
				UserData.setCity(rs1.getString(5));
				response.sendRedirect("Uloginsuccess.html");
			
			
				
			}
			else
			{
				response.sendRedirect("Userlogin.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	
	}

}
