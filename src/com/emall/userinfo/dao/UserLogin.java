package com.emall.userinfo.dao;
import java.sql.*;
public class UserLogin {
	public int adminCheck(String uname,String pass)
	{
		String dbuname = "kyztebkoskojkq";
		String dbpass = "d5841e88508bf89bd231220c78544748b8e1e4d6573dd65e4b41c04d958fdf22";
		int i = 0;
		String url="jdbc:postgresql://ec2-54-158-122-162.compute-1.amazonaws.com:5432/dcvra2j2juraen"; 
		String sql = "select uid from admint where email=? and password=?";
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2, pass);
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
		String dbuname = "kyztebkoskojkq";
		String dbpass = "d5841e88508bf89bd231220c78544748b8e1e4d6573dd65e4b41c04d958fdf22";
		String url="jdbc:postgresql://ec2-54-158-122-162.compute-1.amazonaws.com:5432/dcvra2j2juraen";
		int i = 0;
		String sql = "select uid from userdata where email=? and password=?";
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2, pass);
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
