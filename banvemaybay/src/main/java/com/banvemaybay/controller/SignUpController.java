package com.banvemaybay.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.banvemaybay.model.User;
import com.banvemaybay.services.DatabaseConnection;
import com.banvemaybay.services.userServices;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet(urlPatterns = {"/signup"})
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lastname = request.getParameter("txt-lastName");
		String name = request.getParameter("txt-firstName");
		String email = request.getParameter("txt-email");
		String phone = request.getParameter("number-phone");
		String username = request.getParameter("username");
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
		md.update(request.getParameter("pw_confirm").getBytes());
		digest = md.digest();
		String pw_conf = Base64.getEncoder().encodeToString(digest);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/signup.jsp");
		dispatcher.forward(request, response);
		if(!password.equals(pw_conf) || password.length() > 20 || password.length() < 6) return;
		User u = new User(lastname, name, phone, email, username, password, false);
		userServices us = new userServices();
		us.signUpUser(u);
	}
}
