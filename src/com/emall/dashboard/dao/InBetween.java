package com.emall.dashboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InBetween {
	String url="jdbc:mysql://localhost:3306/propertymgmt";
    String dbuname="root";
    String dbpass="root";
	public int income(String start_date, String end_date)
	{
		int res=0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String sum_sql = "Select sum(rent) from booking where start_date between ? and ?;";
			PreparedStatement st = con.prepareStatement(sum_sql);
			st.setString(1, start_date);
			st.setString(2, end_date);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{				
				res=rs.getInt(1);
			}
			return res;	
		}
		catch(Exception e)
		{
			
		}
		
		return res;
	}
	public String info(String start_date, String end_date)
	{
		String res="";
		res+="<table class='table table-hover' >";
		res+="<tr>";
		res+="<th>"+"Date"+"</th>";
		res+="<th>"+"Customer"+"</th>";
		res+="<th>"+"Space"+"</th>";
		res+="<th>"+"Rent"+"</th>";
		res+="</tr>";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String sum_sql = "select start_date,customer,space,rent from booking where start_date between ? and ?;";
			PreparedStatement st = con.prepareStatement(sum_sql);
			st.setString(1, start_date);
			st.setString(2, end_date);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				
				res+="<tr>";
				res+="<td>"+rs.getString(1)+"</td>";
				res+="<td>"+rs.getString(2)+"</td>";
				res+="<td>"+rs.getString(3)+"</td>";
				res+="<td>"+rs.getString(4)+"</td>";
				res+="</tr>";
			}
			res+="</table>";
			return res;
		}
		catch(Exception e)
		{
			
		}
		return res;
	}
}
