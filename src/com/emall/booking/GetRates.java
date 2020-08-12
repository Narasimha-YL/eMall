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
 * Servlet implementation class GetRates
 */
@WebServlet("/GetRates")
public class GetRates extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetRates() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String space=request.getParameter("space");
		String spaceType = request.getParameter("type");
		Rates r = new Rates();
		if(spaceType.equals("theatre"))
		{
			String res = r.getTRates(space);
			out.print(res);
		}
		else
		{			
			String res = r.getRates(space);
			out.print(res);
		}
	}
}