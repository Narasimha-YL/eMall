package com.emall.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Rates {
	String dbuname = "root";
	String dbpass = "root";
	String url="jdbc:mysql://localhost:3306/propertymgmt"; 
	public String getRates(String space)
	{
		
		String res="";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String sql = "select cost from spaces where space = ? and duration = ?";
			String duration[] = {"weekday","weekend","holiday"};
			for(int i=0;i<3;i++)
			{
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, space);
				st.setString(2, duration[i]);
				ResultSet rs = st.executeQuery();
				rs.next();
				res+=rs.getString(1);
				if(i<2)
					res+=", ";
			}
		}
		catch(Exception e)
		{
			
		}
		return res;
	}
	public String getTRates(String space)
	{
		String res="";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String sql = "select cost from spaces where space = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, space);
			ResultSet rs = st.executeQuery();
			rs.next();
			res+=rs.getString(1);
			con.close();
		}
		catch(Exception e)
		{
			
		}
		return res;
	}
}
