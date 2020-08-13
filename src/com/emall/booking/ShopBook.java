package com.emall.booking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emall.booking.dao.*;

/**
 * Servlet implementation class ShopBook
 */
@WebServlet("/ShopBook")
public class ShopBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String dt;
	BookShop bs = new BookShop();
    public ShopBook() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String spaceType=request.getParameter("spaceType").toString();
			String customer = request.getParameter("customer");
			int uid=Integer.parseInt(request.getSession().getAttribute("uid").toString());
			
			//If the requested type is shop:
			if (spaceType.equals("shop"))
			{
				//To get type of shop
				String space = request.getParameter("space");
				String date = request.getParameter("sdp");
				String days=request.getParameter("days");
				bs.shop(customer,spaceType,space,date,days,uid);
			}
			
			if(spaceType.equals("theatre"))
			{
				String date = request.getParameter("sdp");
				String space = request.getParameter("space");
				String days = "week";
				bs.bookTheatre(customer,spaceType,space,date,days,uid);
			}
			if(spaceType.equals("banner"))
			{
				String space = request.getParameter("space");
				String date = request.getParameter("sdp");
				int sq = Integer.parseInt(request.getParameter("sqrft"));
				bs.bookBanner(customer,spaceType,space,date,sq,uid);
				
			}
			if(spaceType.contentEquals("atrium"))
			{
				String space = request.getParameter("space");
				String date = request.getParameter("sdp");
				String slot = request.getParameter("slot");
				bs.bookAtrium(customer,spaceType,space,date,slot,uid);
				
			}

		response.sendRedirect("welcome.jsp");
	}
}
