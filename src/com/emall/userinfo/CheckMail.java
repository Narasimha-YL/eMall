package com.emall.userinfo;
import com.emall.userinfo.dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckMail
 */
@WebServlet("/CheckMail")
public class CheckMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserRegistration r = new UserRegistration();
		String mail = request.getParameter("mail");
		String res = r.checkMail(mail);
		System.out.println(res);
	}


}
