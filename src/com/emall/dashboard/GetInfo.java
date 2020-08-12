package com.emall.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emall.dashboard.dao.DashboardInfo;

/**
 * Servlet implementation class GetInfo
 */
@WebServlet("/GetInfo")
public class GetInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DashboardInfo di = new DashboardInfo();		
		out.write(di.info());
	}



}
