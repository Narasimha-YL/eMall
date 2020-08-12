package com.emall.userinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emall.userinfo.dao.*;;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String mail=request.getParameter("mailid");
		String userType=request.getParameter("userType");
		String pass=request.getParameter("pass");
		String phone=request.getParameter("phone");
		String city = request.getParameter("question_city");
		String pet = request.getParameter("question_pet");
		UserRegistration dao = new UserRegistration();
		if(userType.equals("admin"))
		dao.adminRegister(name, mail, pass, phone, pet, city);
		else
		dao.userRegister(name, mail, pass, phone, pet, city);
		response.sendRedirect("welcome.jsp");
	}

}
