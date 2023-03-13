package com.banvemaybay.controller;

import javax.management.RuntimeErrorException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Iterator;
import java.sql.*;

@WebServlet(urlPatterns = { "/signin" })
public class SignInController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String username = req.getUserPrincipal().getName();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String url = "jdbc:mysql://localhost:3306/banvemaybay";
		final String username = "root";
		final String passWord = "123456";
		// bắt thông tin từ web
		String user = req.getParameter("username");
		String originPass = req.getParameter("password");
		String remember = req.getParameter("remember_me");
		Cookie[] cookies = req.getCookies();
		if(remember == null) {
			if (cookies != null) {
		        for (Cookie cookie : cookies) {
		        	if(cookie.getName().equals("username"))
		        		cookie.setMaxAge(0);
		        	resp.addCookie(cookie);
		        }
		        for (Cookie cookie : cookies) {
		        	if(cookie.getName().equals("password"))
		        		cookie.setMaxAge(0);
		        	resp.addCookie(cookie);
		        }
		    }
		}
//		if(cookies != null && remember.equals("on")) {
//			for(Cookie cookie : cookies) {
//				if(cookie.getName().equals("username"))
//					user = cookie.getValue();
//				for(Cookie c : cookies) {
//					if(c.getName().equals("password"))
//						originPass = c.getValue();
//					break;
//				}
//			}
//		}
		MessageDigest md = null;
  try {
   md = MessageDigest.getInstance("MD5");
  } catch (NoSuchAlgorithmException e) {
   e.printStackTrace();
  }
  md.update(originPass.getBytes());
  byte[] digest = md.digest();
  String finalpass = Base64.getEncoder().encodeToString(digest);

		// truy xuất dữ liệu
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, passWord);
			String query = "SELECT username, password, admin FROM banvemaybay.user WHERE username = ? AND password = ?";
			PreparedStatement stm = connection.prepareStatement(query);
			
			stm.setString(1, user);
			stm.setString(2, finalpass);
			ResultSet src = stm.executeQuery();
			if (src.next()) {
				HttpSession session = req.getSession();
				
				if( remember != null && remember.equals("on")) {
					String tempUserString = user;
					String tempPassString = originPass;
					Cookie usernameCookie = new Cookie("username", tempUserString);
					Cookie passwordCookie = new Cookie("password", tempPassString);
					usernameCookie.setMaxAge(30 * 24 * 60 * 60);
					// 30 days * 24 hours * 60 minutes * 60 seconds
					passwordCookie.setMaxAge(30 * 24 * 60 * 60);
					// 30 days * 24 hours * 60 minutes * 60 seconds
					resp.addCookie(usernameCookie);
					resp.addCookie(passwordCookie);
				}
				session.setAttribute("user", user);
				session.setAttribute("isadmin", src.getBoolean("admin"));
				String loiString = String.format("ten: %s", remember);
				String tempString = null;
				if(cookies != null) tempString = "khong null";
				session.setAttribute("err", loiString);
				resp.sendRedirect("/banvemaybay/index");
			} else {
				HttpSession session = req.getSession();
				String loiString = String.format("ten: %s, mk: %s", user, originPass);
				session.setAttribute("err", loiString);
				resp.sendRedirect("signin.jsp");
			}
			connection.close();
			src.close();
			stm.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	}

	}


}
