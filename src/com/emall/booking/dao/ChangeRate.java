package com.emall.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ChangeRate {
	public void changeRate(String space, String duration, String cost)
	{
		String dbuname = "emall";
		String dbpass = "propertymanagement";
		String url="jdbc:mysql://emall.cesxmljyteso.us-east-2.rds.amazonaws.com:3306/propertymgmt"; 
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String sql = "update spaces set cost = ? where space = ? and duration = ? ;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cost);
			st.setString(2, space);
			st.setString(3, duration);
			st.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			
		}
	}
}
