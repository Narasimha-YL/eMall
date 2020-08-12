package com.emall.booking;
import com.emall.booking.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateSpace
 */
@WebServlet("/CreateSpace")
public class CreateSpace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSpace() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spaceType = request.getParameter("newSpaceType");
		String space = request.getParameter("newSpace");
		NewSpace ns = new NewSpace();
		if(spaceType.equals("shop"))
		{
			String weekdayType = request.getParameter("weekdaySType");
			String weekdayCost = request.getParameter("weekdaySCost");
			String weekendType = request.getParameter("weekendSType");
			String weekendCost = request.getParameter("weekendSCost");
			String holidayType = request.getParameter("holidaySType");
			String holidayCost = request.getParameter("holidaySCost");
			ns.create(spaceType,space,"weekday",weekdayType,weekdayCost);
			ns.create(spaceType,space,"weekend",weekendType,weekendCost);
			ns.create(spaceType,space,"holiday",holidayType,holidayCost);
		}
		else if(spaceType.equals("atrium"))
		{
			String weekdayCost = request.getParameter("weekdayCost");
			String weekendCost = request.getParameter("weekendCost");
			String holidayCost = request.getParameter("holidayCost");
			ns.create(spaceType, space, "weekday", "hour", weekdayCost);
			ns.create(spaceType, space, "weekend", "hour", weekendCost);
			ns.create(spaceType, space, "holiday", "hour", holidayCost);
		}
		else if(spaceType.equals("theatre"))
		{
			String cost = request.getParameter("tCost");
			ns.create(spaceType, space, "all", "week", cost);
		}
		else if(spaceType.equals("banner"))
		{
			String sqrft = request.getParameter("sqrft");
			String weekdayCost = request.getParameter("weekdayCost");
			String weekendCost = request.getParameter("weekendCost");
			String holidayCost = request.getParameter("holidayCost");
			ns.create(spaceType, space, "weekday", "hour", weekdayCost);
			ns.create(spaceType, space, "weekend", "hour", weekendCost);
			ns.create(spaceType, space, "holiday", "hour", holidayCost);
			ns.banner(space,sqrft);
		}
		response.sendRedirect("welcome.jsp");
	}

}
