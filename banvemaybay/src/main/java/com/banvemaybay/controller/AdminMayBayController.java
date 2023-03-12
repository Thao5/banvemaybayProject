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

import com.banvemaybay.model.MayBay;
import com.banvemaybay.services.MayBayServices;

/**
 * Servlet implementation class AdminMayBayController
 */
@WebServlet(urlPatterns = {"/admin/maybay"})
public class AdminMayBayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMayBayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MayBayServices mbs = new MayBayServices();
		try {
			List<MayBay> listmb = mbs.getMayBays();
			request.setAttribute("listmb", listmb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/maybay.jsp");
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
		MayBayServices mbs = new MayBayServices();
		try {
			List<MayBay> listmb = mbs.getMayBays();
			if(request.getParameter("tenMayBay") != null){
				mbs.themMB(new MayBay(request.getParameter("tenMayBay"), Integer.parseInt(request.getParameter("soGhe")), Long.parseLong(request.getParameter("namSanXuat")), Integer.parseInt(request.getParameter("id_chuyenbay"))));
			}
			request.setAttribute("listmb", listmb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/maybay.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
