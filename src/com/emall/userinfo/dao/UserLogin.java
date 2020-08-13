package com.emall.userinfo.dao;
import java.sql.*;
public class UserLogin {
	public int adminCheck(String uname,String pass)
	{
		String dbuname = "root";
		String dbpass = "root";
		int i = 0;
		String url="jdbc:mysql://localhost:3306/propertymgmt"; 
		String sql = "select uid from admint where email=? and password=?";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setNString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				i = rs.getInt(1);
				return i;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public int userCheck(String uname,String pass)
	{
		String dbuname = "root";
		String dbpass = "root";
		int i =0;
		String url="jdbc:mysql://localhost:3306/propertymgmt"; 
		String sql = "select uid from userdata where email=? and password=?";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setNString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				i = rs.getInt(1);
				
				return i;
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}
}
