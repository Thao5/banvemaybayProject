package com.banvemaybay.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banvemaybay.model.User;
import com.banvemaybay.services.userServices;

/**
 * Servlet implementation class AdminUserController
 */
@WebServlet(urlPatterns = {"/admin/user"})
public class AdminUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		userServices userserv = new userServices();
		try {
			List<User> listuser = userserv.getUsers();
			request.setAttribute("listuser", listuser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/user.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		userServices userserv = new userServices();
		List<User> listuser;
		if(request.getParameter("last_middle_name") != null || request.getParameter("first_name") != null) {
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			md.update(request.getParameter("pw").getBytes());
			byte[] digest = md.digest();
			String password = Base64.getEncoder().encodeToString(digest);
				userserv.signUpUser(new User(request.getParameter("last_middle_name"), request.getParameter("first_name"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("user_name"), password,Boolean.parseBoolean(request.getParameter("admin_id"))));
		}
		listuser = userserv.getUsers(request.getParameter("key"));
		request.setAttribute("listuser", listuser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/user.jsp");
		dispatcher.forward(request, response);
	}

}
