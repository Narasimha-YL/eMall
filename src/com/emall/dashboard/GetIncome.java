package com.emall.dashboard;
import com.emall.dashboard.dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetInfo
 */
@WebServlet("/GetIncome")
public class GetIncome extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetIncome() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DashboardInfo di = new DashboardInfo();		
		out.write(di.income());
	}
}
