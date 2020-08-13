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
		int a = 0,u=0;
		UserLogin dao = new UserLogin();
		a = dao.adminCheck(uname, pass);
		u = dao.userCheck(uname, pass);
		
		if( a != 0 )
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", uname);	
			session.setAttribute("role","admin");
			session.setAttribute("uid",a);
			response.sendRedirect("welcome.jsp");
			
		}
		else if(u != 0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", uname);
			session.setAttribute("role","user");
			session.setAttribute("uid",u);
			response.sendRedirect("welcome.jsp");	
		}
		else 
		{
			response.sendRedirect("home.jsp");
		}
	}

}
