package com.banvemaybay.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import com.banvemaybay.model.Booking;
import com.banvemaybay.model.ChuyenBay;
import com.banvemaybay.model.Ve;
import com.banvemaybay.services.BookingServices;
import com.banvemaybay.services.ChuyenBayServices;
import com.banvemaybay.services.SendMailServices;
import com.banvemaybay.services.VeServices;
import com.mysql.cj.Session;

/**
 * Servlet implementation class ThongTinCBController
 */
@WebServlet(urlPatterns = {"/thongtinchuyenbay"})
public class ThongTinCBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinCBController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		ChuyenBayServices cbs = new ChuyenBayServices();
		BookingServices book = new BookingServices();
		VeServices ve = new VeServices();
		ChuyenBay cb = cbs.timTheoID(id);
		Booking b = new Booking(LocalDateTime.now(), true, Integer.parseInt(request.getParameter("iduser")), Integer.parseInt(request.getParameter("id")));
		book.themBooking(b);
		ve.themVe(new Ve(Double.parseDouble(request.getParameter("giatien")), LocalDateTime.now(), true, Integer.parseInt(request.getParameter("id")),book.findLast()));
		SendMailServices.sendMail((String) request.getParameter("email"), "Thanks", "Cảm ơn đã đặt vé");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/thongtinchuyenbay.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
	}
}
