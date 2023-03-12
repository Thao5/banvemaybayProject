package com.banvemaybay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banvemaybay.model.Ve;
import com.banvemaybay.services.VeServices;



/**
 * Servlet implementation class AdminVeController
 */
@WebServlet(urlPatterns = {"/admin/ve"})
public class AdminVeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminVeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VeServices veser= new VeServices();
		try {
			List<Ve> listve = veser.getVes();
			request.setAttribute("listve", listve);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/ve.jsp");
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
		VeServices veser= new VeServices();
		try {
			List<Ve> listve = veser.getVes();
			request.setAttribute("listve", listve);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/ve.jsp");
			dispatcher.forward(request, response);
			if(request.getParameter("money_ve") != null) {
				veser.themVe(new Ve(Double.parseDouble(request.getParameter("money_ve")),LocalDateTime.now() , Boolean.parseBoolean(request.getParameter("trangThai")),Integer.parseInt(request.getParameter("fly")),Integer.parseInt(request.getParameter("book_id"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
