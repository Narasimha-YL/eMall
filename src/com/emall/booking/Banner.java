package com.emall.booking;

import java.io.IOException;
import java.io.PrintWriter;
import com.emall.booking.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Banner")
public class Banner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url="jdbc:mysql://localhost:3306/propertymgmt";
    String dbuname="root";
    String dbpass="root";
    
    public Banner() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			BookingOperations bo = new BookingOperations();
			PrintWriter out=response.getWriter();
			String type=request.getParameter("type");
			String date=request.getParameter("date");
			int res = bo.bannerValue(type,date);
			out.print(res);
	}
}
