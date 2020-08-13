package com.emall.dashboard;
import com.emall.dashboard.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Complaint
 */
@WebServlet("/Complaint")
public class Complaint extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Complaint() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comp = request.getParameter("complaint");
		String name=request.getSession().getAttribute("email").toString();
	
		DashboardOperations dO = new DashboardOperations();
		dO.complaint(name, comp);
		response.sendRedirect("welcome.jsp");
	}

}
