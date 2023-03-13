package com.banvemaybay.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banvemaybay.services.DatabaseConnection;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(urlPatterns = {"/admin"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatchar = request.getRequestDispatcher("/admin/admin.jsp");
		dispatchar.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String originPass = request.getParameter("password");
		MessageDigest md = null;
		  try {
		   md = MessageDigest.getInstance("MD5");
		  } catch (NoSuchAlgorithmException e) {
		   e.printStackTrace();
		  }
		  md.update(originPass.getBytes());
		  byte[] digest = md.digest();
		  String finalpass = Base64.getEncoder().encodeToString(digest);
		  try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			  String query = "SELECT username, password, admin FROM banvemaybay.user WHERE username = ? AND password = ?";
				PreparedStatement stm = conn.prepareStatement(query);
				
				stm.setString(1, user);
				stm.setString(2, finalpass);
				ResultSet src = stm.executeQuery();
				if (src.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					session.setAttribute("isadmin", src.getBoolean("admin"));
					response.sendRedirect("/banvemaybay/admin/ChuyenBay");
				}
				else {
						HttpSession session = request.getSession();
						String loiString = String.format("ten: %s, mk: %s", user, originPass);
						session.setAttribute("err", loiString);
						response.sendRedirect("/banvemaybay/admin");
				}
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
