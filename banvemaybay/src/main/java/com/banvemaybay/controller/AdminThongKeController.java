package com.banvemaybay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banvemaybay.model.ThongKe;
import com.banvemaybay.services.ChuyenBayServices;

/**
 * Servlet implementation class AdminThongKeController
 */
@WebServlet(urlPatterns = {"/admin/thongke"})
public class AdminThongKeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminThongKeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChuyenBayServices cbs = new ChuyenBayServices();
		List<ThongKe> thongke = cbs.thongKe();
		request.setAttribute("thongke", thongke);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/thongke.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
