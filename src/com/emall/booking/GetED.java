package com.emall.booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emall.booking.dao.BookingOperations;

/**
 * Servlet implementation class GetED
 */
@WebServlet("/GetED")
public class GetED extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetED() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String d = request.getParameter("dt");
		String type = request.getParameter("type");
		PrintWriter out= response.getWriter();
		BookingOperations bo = new BookingOperations();

		long res = bo.endDate(d,type);
		out.print(res);
	}


}
