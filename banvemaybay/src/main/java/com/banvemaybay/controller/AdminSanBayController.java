package com.banvemaybay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banvemaybay.model.SanBay;
import com.banvemaybay.services.SanBayServices;

/**
 * Servlet implementation class AdminSanBayController
 */
@WebServlet(urlPatterns = {"/admin/sanbay"})
public class AdminSanBayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSanBayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanBayServices sbs = new SanBayServices();
		try {
			List<SanBay> listsb = sbs.getSanBays();
			request.setAttribute("listsb", listsb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/sanbay.jsp");
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
		SanBayServices sbs = new SanBayServices();
		try {
			List<SanBay> listsb = sbs.getSanBays();
			if(request.getParameter("ten_Sanbay") != null)
				sbs.themSB(new SanBay(request.getParameter("ten_Sanbay"), request.getParameter("address"), request.getParameter("contact")));
			request.setAttribute("listsb", listsb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/sanbay.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
