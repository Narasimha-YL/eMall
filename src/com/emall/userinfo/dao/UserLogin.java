package com.emall.userinfo.dao;
import java.sql.*;
public class UserLogin {
	public boolean adminCheck(String uname,String pass)
	{
		String url="jdbc:mysql://localhost:3306/propertymgmt"; 
		String sql = "select * from admint where email=? and pass=?";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","root");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setNString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean userCheck(String uname,String pass)
	{
		String url="jdbc:mysql://localhost:3306/propertymgmt"; 
		String sql = "select * from userdata where email=? and password=?";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","root");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setNString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
