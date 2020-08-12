package com.emall.userinfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRegistration {
	public void userRegister(String name, String mailid, String pass, String phone,String pet, String city)
	{
		String dbuname = "emall";
		String dbpass = "propertymanagement";
		String url="jdbc:mysql://emall.cesxmljyteso.us-east-2.rds.amazonaws.com:3306/propertymgmt"; 
		String sql = "insert into userdata(name,email,password,phone,pet,city) values(?,?,?,?,?,?)";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, mailid);
			st.setString(3, pass);
			st.setString(4, phone);
			st.setString(5, pet);
			st.setString(6, city);
			st.executeUpdate();	
			con.close();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void adminRegister(String name, String mailid, String pass, String phone,String pet, String city)
	{
		String dbuname = "emall";
		String dbpass = "propertymanagement";
		String url="jdbc:mysql://emall.cesxmljyteso.us-east-2.rds.amazonaws.com:3306/propertymgmt"; 
		String sql = "insert into admint(name,email,password,phone,pet,city) values(?,?,?,?,?,?)";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, mailid);
			st.setString(3, pass);
			st.setString(4, phone);
			st.setString(5, pet);
			st.setString(6, city);
			st.executeUpdate();	
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String checkMail(String mail)
	{
		String dbuname = "emall";
		String dbpass = "propertymanagement";
		String url="jdbc:mysql://emall.cesxmljyteso.us-east-2.rds.amazonaws.com:3306/propertymgmt"; 
		String sql = "select * from userdata where email = ?";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, mail);
			ResultSet rs = st.executeQuery();
			if(rs.next())
				return "true";
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}

}
