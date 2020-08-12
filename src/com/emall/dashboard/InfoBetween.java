package com.emall.dashboard;
import com.emall.dashboard.dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InfoBetween")
public class InfoBetween extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InfoBetween() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		String start_date=request.getParameter("start_date");
		String end_date=request.getParameter("end_date");
		InBetween in = new InBetween();
		PrintWriter out = response.getWriter();
		int n = in.income(start_date, end_date);
		if(type.equals("income"))
			out.print(n);
		else
			out.print(in.info(start_date, end_date));
	}
}
