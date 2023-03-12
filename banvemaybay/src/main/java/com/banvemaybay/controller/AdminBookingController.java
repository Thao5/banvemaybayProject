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

import com.banvemaybay.model.Booking;
import com.banvemaybay.services.BookingServices;

/**
 * Servlet implementation class AdminBookingController
 */
@WebServlet(urlPatterns = {"/admin/booking"})
public class AdminBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingServices bookserv = new BookingServices();
		try {
			List<Booking> listbook = bookserv.getBookings();
			request.setAttribute("listbook", listbook);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/book.jsp");
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
		BookingServices bookserv = new BookingServices();
		try {
			List<Booking> listbook = bookserv.getBookings();
			if(request.getParameter("idUser") != null)
				bookserv.themBooking(new Booking(LocalDateTime.now(), Boolean.parseBoolean(request.getParameter("status")), Integer.parseInt(request.getParameter("idUser")), Integer.parseInt(request.getParameter("id_chuyenbay"))));
			request.setAttribute("listbook", listbook);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/book.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
