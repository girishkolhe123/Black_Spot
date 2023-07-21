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
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
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
		
		
		
		
		String user_name = request.getParameter("name");
		String user_email = request.getParameter("email");
		String user_contact = request.getParameter("mobile");
		String user_password = request.getParameter("password");
		String user_address = request.getParameter("address");
		
		try
		{
			Connection con = ConnectDB.getConnect();
			
			PreparedStatement ps1 = con.prepareStatement("insert into user values(?,?,?,?,?)");
			ps1.setString(1, user_name);
			ps1.setString(2, user_email);
			ps1.setString(3, user_contact);
			ps1.setString(4, user_password);
			ps1.setString(5, user_address);
		
			
			int i = ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("Uregsuccess.html");
			}
			else
			{
				response.sendRedirect("Userreg.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
