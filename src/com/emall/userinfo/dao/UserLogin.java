package com.emall.userinfo.dao;
import java.sql.*;
public class UserLogin {
	public boolean adminCheck(String uname,String pass)
	{
		String dbuname = "emall";
		String dbpass = "propertymanagement";
		String url="jdbc:mysql://emall.cesxmljyteso.us-east-2.rds.amazonaws.com:3306/propertymgmt"; 
		String sql = "select * from admint where email=? and password=?";
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
		String dbuname = "emall";
		String dbpass = "propertymanagement";
		String url="jdbc:mysql://emall.cesxmljyteso.us-east-2.rds.amazonaws.com:3306/propertymgmt"; 
		String sql = "select * from userdata where email=? and password=?";
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
				return true;
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
