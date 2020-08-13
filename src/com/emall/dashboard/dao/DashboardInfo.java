package com.emall.dashboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DashboardInfo {
	String dbuname = "root";
	String dbpass = "root";
	String url="jdbc:mysql://localhost:3306/propertymgmt"; 
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar c = Calendar.getInstance();
	public String income()
	{
		String s = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String q="select sum(rent) from booking where start_date >= ? and end_date <= ? ;";
			PreparedStatement st = con.prepareStatement(q);	
			Date date=java.util.Calendar.getInstance().getTime();  
			String end_date = sdf.format(date); 
			try{
				   c.setTime(sdf.parse(end_date));
				}catch(ParseException e){
				   e.printStackTrace();
				 }
				c.add(Calendar.DAY_OF_MONTH, -10);
				String start_date = sdf.format(c.getTime());
				st.setString(1, start_date);
				st.setString(2, end_date);
				ResultSet rs = st.executeQuery();
				while(rs.next())
				{
					s += rs.getInt(1);
					s +=", ";
				}			
				
				PreparedStatement stM = con.prepareStatement(q);	
				Date dateM=java.util.Calendar.getInstance().getTime();  
				String end_dateM = sdf.format(dateM); 
				try{
					   c.setTime(sdf.parse(end_dateM));
					}catch(ParseException e){
					   e.printStackTrace();
					 }
					c.add(Calendar.MONTH, -1);
					String start_dateM = sdf.format(c.getTime());
					stM.setString(1, start_dateM);
					stM.setString(2, end_dateM);
					ResultSet rsM = stM.executeQuery();
					while(rsM.next())
					{
						s += rsM.getInt(1);
						s +=", ";
					}
					
					PreparedStatement stY = con.prepareStatement(q);	
					Date dateY=java.util.Calendar.getInstance().getTime();  
					String end_dateY = sdf.format(dateY); 
					try{
						   c.setTime(sdf.parse(end_dateY));
						}catch(ParseException e){
						   e.printStackTrace();
						 }
						c.add(Calendar.YEAR, -1);
						String start_dateY = sdf.format(c.getTime());
						stY.setString(1, start_dateY);
						stY.setString(2, end_dateY);
						ResultSet rsY = stY.executeQuery();
						while(rsY.next())
						{
							s += rsY.getInt(1);
							s +=",";
						}
						
					String tot = "select sum(rent) from booking;";
					PreparedStatement to = con.prepareStatement(tot);
					ResultSet rt = to.executeQuery();
					while(rt.next())
					{
						s += rt.getInt(1);
					}
					con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return s;

	}
	public String info()
	{
		String res="";
		
		ArrayList<String> spaces = new ArrayList<String>();
		ArrayList<String> Aspaces = new ArrayList<String>();
		ArrayList<String> Tspaces = new ArrayList<String>();
		ArrayList<String> Bspaces = new ArrayList<String>();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Date date=java.util.Calendar.getInstance().getTime();  
		String sd = sdf.format(date); 
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String spacesSQL = "select distinct space from spaces where space_type = 'shop';";
			PreparedStatement ps = con.prepareStatement(spacesSQL);
			ResultSet sp = ps.executeQuery();
			while(sp.next())
				spaces.add(sp.getString(1));
			res+="<table class='table table-hover' >";
			for(int i = 0;i<spaces.size();i++)
			{
				res+="<tr>";
				res+="<td>"+spaces.get(i)+"</td>";
				
				try{
					   c.setTime(sdf.parse(sd));
					}catch(ParseException e){
					   e.printStackTrace();
					 }
				
				int count=0;
				String d = "select start_date from booking where space=? and start_date=?;";
				while(true)
				{
					String start_date = sdf.format(c.getTime());
					
					PreparedStatement spDate = con.prepareStatement(d);
					spDate.setString(1, spaces.get(i));
					spDate.setString(2, start_date);
					ResultSet rsDate = spDate.executeQuery();
					if(rsDate.next()) {
						c.add(Calendar.DAY_OF_MONTH, 1);
						continue;
						
					}
					else {
						count++;
						res+="<td>"+start_date+"</td>";
						c.add(Calendar.DAY_OF_MONTH, 1);
						if(count>2)
							break;
					}
				}
				res+="</tr>";
			}		
			
			//Free atrium Atrium
			String atriumSQL = "select distinct space from spaces where space_type = 'atrium';";
			PreparedStatement Aps = con.prepareStatement(atriumSQL);
			ResultSet Asp = Aps.executeQuery();
			while(Asp.next())
				Aspaces.add(Asp.getString(1));
			for(int i = 0;i<Aspaces.size();i++)
			{
				res+="<tr>";
				res+="<td>"+Aspaces.get(i)+"</td>";
				//res+="<td>";
				try{
					   c.setTime(sdf.parse(sd));
					}catch(ParseException e){
					   e.printStackTrace();
					 }
				
				int count=0;
				String d = "select start_date,count(*) as c from booking where space=? and start_date=? group by start_date having c>2;";
				while(true)
				{
					String start_date = sdf.format(c.getTime());
					
					PreparedStatement spDate = con.prepareStatement(d);
					spDate.setString(1, Aspaces.get(i));
					spDate.setString(2, start_date);
					ResultSet rsDate = spDate.executeQuery();
					if(rsDate.next()) {
						c.add(Calendar.DAY_OF_MONTH, 1);
						continue;
						
					}
					else {
						count++;
						res+="<td>"+start_date+"</td>";
						c.add(Calendar.DAY_OF_MONTH, 1);
						if(count>2)
							break;
					}
				}
				res+="</tr>";
			}
			
			//Theatre Free dates
			String theatreSQL = "select distinct space from spaces where space_type = 'theatre';";
			PreparedStatement Tps = con.prepareStatement(theatreSQL);
			ResultSet Tsp = Tps.executeQuery();
			while(Tsp.next())
				Tspaces.add(Tsp.getString(1));
			for(int i = 0;i<Tspaces.size();i++)
			{
				res+="<tr>";
				res+="<td>"+Tspaces.get(i)+"</td>";
				try{
					   c.setTime(sdf.parse(sd));
					}catch(ParseException e){
					   e.printStackTrace();
					 }
				
				int count=0;
				String d = "select * from booking where space=? and ? between start_date and end_date ;";
				while(true)
				{
					String start_date = sdf.format(c.getTime());
					
					PreparedStatement spDate = con.prepareStatement(d);
					spDate.setString(1, Tspaces.get(i));
					spDate.setString(2, start_date);
					ResultSet rsDate = spDate.executeQuery();
					if(rsDate.next()) {
						c.add(Calendar.DAY_OF_MONTH, 1);
						continue;
						
					}
					else {
						count++;
						res+="<td>"+start_date+"</td>";
						c.add(Calendar.DAY_OF_MONTH, 1);
						if(count>2)
							break;
					}
				}
				res+="</tr>";
			}
			
			//Free Banner dates
			String bannerSQL = "select distinct space from spaces where space_type = 'banner';";
			PreparedStatement Bps = con.prepareStatement(bannerSQL);
			ResultSet Bsp = Bps.executeQuery();
			while(Bsp.next())
				Bspaces.add(Bsp.getString(1));
			for(int i = 0;i<Bspaces.size();i++)
			{
				res+="<tr>";
				res+="<td>"+Bspaces.get(i)+"</td>";
				try{
					   c.setTime(sdf.parse(sd));
					}catch(ParseException e){
					   e.printStackTrace();
					 }
				
				int count=0;
				
				String sq_query = "select sqrft from banner where space = ?;";
				PreparedStatement sq = con.prepareStatement(sq_query);
				sq.setString(1, Bspaces.get(i));
				ResultSet sqr = sq.executeQuery();
				sqr.next();
				int sqrft = sqr.getInt(1);
				String d = "select start_date from booking  where space =? and start_date=?  group by start_date having sum(units)=?;";
				while(true)
				{
					String start_date = sdf.format(c.getTime());
					
					PreparedStatement spDate = con.prepareStatement(d);
					spDate.setString(1, Bspaces.get(i));
					spDate.setString(2, start_date);
					spDate.setInt(3, sqrft);
					ResultSet rsDate = spDate.executeQuery();
					if(rsDate.next()) {
						c.add(Calendar.DAY_OF_MONTH, 1);
						continue;
						
					}
					else {
						count++;
						res+="<td>"+start_date+"</td>";
						c.add(Calendar.DAY_OF_MONTH, 1);
						if(count>2)
							break;
					}
				}
				res+="</tr>";
			}
			System.out.println("\n\n");

			con.close();
		}
		catch(Exception e)
		{
			
		}
		res+="</table>";
		return res;
	}
	public String complaints()
	{
		String res="";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String sql = "select user,issue from complaints;";
			res+="<table  class='table table-hover' >";
			res+="<tr><th>Complaint By</th><th>Complaint</th></tr>";
			PreparedStatement st= con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				res+="<tr>";
				res+="<td style='text-align:center'>"+rs.getString(1)+"</td><td style='text-align:center'>"+rs.getString(2)+"</td>";
				res+="</tr>";
			}
			res+="</table>";
			con.close();
		}
		catch(Exception e)
		{
			
		}
		return res;
	}
}
