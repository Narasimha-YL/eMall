package com.emall.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NewSpace {
	String dbuname = "root";
	String dbpass = "root";
	String url="jdbc:mysql://localhost:3306/propertymgmt"; 
	String sql = "insert into spaces values(?,?,?,?,?);";
	public void create(String spaceType,String space,String duration,String rent_type,String cost)
	{
		try
		{
			System.out.print(spaceType+" "+space+" "+duration+" "+rent_type+" "+cost);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, spaceType);
			st.setString(2, space);
			st.setString(3, duration);
			st.setString(4, rent_type);
			st.setString(5, cost);
			st.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void banner(String space, String sqrft)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","root");
			String s = "insert into banner values(?,?)";
			PreparedStatement st = con.prepareStatement(s);
			st.setString(1, space);
			st.setString(2, sqrft);
			st.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
