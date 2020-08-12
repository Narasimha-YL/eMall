package com.emall.booking;
import com.emall.booking.dao.*;
import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Atrium
 */
@WebServlet("/Atrium")
public class Atrium extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url="jdbc:mysql://localhost:3306/propertymgmt";
    String dbuname="root";
    String dbpass="root";
    
    public Atrium() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			BookingOperations bo = new BookingOperations();;
			PrintWriter out= response.getWriter();
			String type=request.getParameter("type");
			String date=request.getParameter("date");			String s = bo.atriumValue(type, date);	
			out.print(s); 
	}

}
