package com.emall.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ChangeRate {
	public void changeRate(String space, String duration, String cost)
	{
		String url="jdbc:mysql://localhost:3306/propertymgmt"; 
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","root");
			String sql = "update spaces set cost = ? where space = ? and duration = ? ;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cost);
			st.setString(2, space);
			st.setString(3, duration);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
	}
}
