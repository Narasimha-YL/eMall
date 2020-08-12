package com.emall.booking;
import com.emall.booking.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeRates
 */
@WebServlet("/ChangeRates")
public class ChangeRates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeRates() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spaceType=request.getParameter("rateSpaceType").toString();
		ChangeRate cr = new ChangeRate();
		if(spaceType.equals("theatre"))
		{
			String rate = request.getParameter("new_theatre");
			String space = request.getParameter("rateSpace");
			cr.changeRate(space, "all", rate);
		}
		else
		{
			String space = request.getParameter("rateSpace");
			String weekday = request.getParameter("new_weekday");
			String weekend = request.getParameter("new_weekend");
			String holiday = request.getParameter("new_holiday");
			
			cr.changeRate(space, "weekday", weekday);
			cr.changeRate(space, "weekend", weekend);
			cr.changeRate(space, "holiday", holiday);
		}
		response.sendRedirect("welcome.jsp");
	}

}
