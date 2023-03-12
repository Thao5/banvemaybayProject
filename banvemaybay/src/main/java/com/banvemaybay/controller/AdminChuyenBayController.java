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

import com.banvemaybay.model.ChuyenBay;
import com.banvemaybay.model.SanBay;
import com.banvemaybay.services.ChuyenBayServices;
import com.banvemaybay.services.SanBayServices;

/**
 * Servlet implementation class AdminChuyenBayController
 */
@WebServlet(urlPatterns = {"/admin/ChuyenBay"})
public class AdminChuyenBayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChuyenBayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ChuyenBayServices cbs = new ChuyenBayServices();
			SanBayServices sbs = new SanBayServices();
			List<String> listsb;
			List<ChuyenBay> listcb;
			listsb = sbs.loadNameSB();
			listcb = cbs.getChuyenBays();
			request.setAttribute("listsb", listsb);
			request.setAttribute("listcb", listcb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/chuyenbay.jsp");
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
		ChuyenBayServices cbs = new ChuyenBayServices();
		List<ChuyenBay> listcb;
		listcb = cbs.getChuyenBays(request.getParameter("key"));
		String test = request.getParameter("slb_SBDi");
		boolean check = cbs.themCB(request.getParameter("name_Fly"), request.getParameter("time_di"), request.getParameter("time_den"), request.getParameter("quantity"), request.getParameter("diem_di"), request.getParameter("diem_den"), request.getParameter("giaTien"), request.getParameter("slb_SBDi"), request.getParameter("slb_SBDen"));
		request.setAttribute("listcb", listcb);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/chuyenbay.jsp");
		dispatcher.forward(request, response);
	}

}
