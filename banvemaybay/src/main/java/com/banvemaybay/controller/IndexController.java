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
import javax.servlet.http.HttpSession;

import com.banvemaybay.model.ChuyenBay;
import com.banvemaybay.services.ChuyenBayServices;
import com.banvemaybay.services.SanBayServices;

/**
 * Servlet implementation class LoadSanBayController
 */
@WebServlet(urlPatterns = {"/index"})
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			SanBayServices sbs = new SanBayServices();
			List<String> listaddresssb = sbs.loadAddressSanBay();
			ChuyenBayServices cbs = new ChuyenBayServices();
			List<ChuyenBay> listsb;
			listsb = cbs.getChuyenBays();
			req.setAttribute("listaddresssb", listaddresssb);
			req.setAttribute("listcb", listsb);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanBayServices sbs = new SanBayServices();
		List<String> listaddresssb = sbs.loadAddressSanBay();
		ChuyenBayServices cbs = new ChuyenBayServices();
		List<ChuyenBay> listsb = cbs.getChuyenBays(request.getParameter("slb_diemDi"), request.getParameter("slb_diemDen"), request.getParameter("txt_ngayDi"));
		request.setAttribute("listaddresssb", listaddresssb);
		request.setAttribute("listcb", listsb);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
