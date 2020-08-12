package com.emall.userinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emall.userinfo.dao.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		UserLogin dao = new UserLogin();
		if(dao.adminCheck(uname, pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);	
			session.setAttribute("role","admin");
			response.sendRedirect("welcome.jsp");
			
		}
		else if(dao.userCheck(uname, pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("role","user");
			response.sendRedirect("welcome.jsp");	
		}
		else 
		{
			response.sendRedirect("home.jsp");
		}
	}

}
