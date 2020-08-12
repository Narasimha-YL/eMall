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
 * Servlet implementation class GetD
 */
@WebServlet("/GetD")
public class GetD extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetD() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingOperations bo = new BookingOperations();
		PrintWriter out= response.getWriter();
		String spaceType = request.getParameter("spaceType");
		String space=request.getParameter("space");
		String s = bo.dates(spaceType,space);	
		out.print(s);
	}


}
