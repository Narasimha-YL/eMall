package com.emall.dashboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DashboardOperations {
	String dbuname = "emall";
	String dbpass = "propertymanagement";
	String url="jdbc:mysql://emall.cesxmljyteso.us-east-2.rds.amazonaws.com:3306/propertymgmt"; 
    
	public String complaint(String name,String complaint)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String sql="insert into complaints values(?,?);";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, complaint);
			st.executeLargeUpdate();
			con.close();
		}
		catch(Exception E)
		{
			
		}
		return "";
	}

}
