package com.emall.booking.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

public class BookingOperations {
	String url="jdbc:mysql://localhost:3306/propertymgmt";
    String dbuname="root";
    String dbpass="root";
	
	public int bannerValue(String type,String date)
	{
		int total=0,max=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String sql = "select sum(units) from booking where space=? and start_date = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, type);
			st.setString(2, date);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				total = rs.getInt(1);
			}
			String val = "select sqrft from banner where space = ?";
			PreparedStatement ps = con.prepareStatement(val);
			ps.setString(1,type);
			ResultSet sr = ps.executeQuery();
			while(sr.next())
				max = sr.getInt(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return max-total;
	}
	
	public String atriumValue(String type, String date)
	{
		String s="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String slots[]= {"Morning","Afternoon","Evening"};
			ArrayList<String> list = new ArrayList<>();
			String q="select units from booking where space=? and start_date = ?";
			PreparedStatement st = con.prepareStatement(q);
			st.setString(1, type);
			st.setString(2, date);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				String temp = rs.getString(1);
				list.add(temp);
			}	
			for(int i=0;i<slots.length;i++) {
			if(list.contains(slots[i])) ;
			else
				s+="<option value='"+slots[i]+"'>"+slots[i]+ "</option>";						
			}
	}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
	public String spaces(String type)
	{
		String s="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String q="select distinct space from spaces where space_type = ?;";
			PreparedStatement st = con.prepareStatement(q);
			st.setString(1, type);
			ResultSet rs = st.executeQuery();
			s+="<option value='' disabled selected>Select Type</option>;";
			while(rs.next())
			{
				String temp = rs.getString(1);
				s+="<option value='"+temp+"'>"+temp+"</option>";
			}	
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
	
	public String dates(String spaceType,String space)
	{
		String s="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ad = Calendar.getInstance();
		Calendar sub = Calendar.getInstance();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			if(spaceType.equals("shop"))
			{
				String q="select start_date from booking where space = ?;";
				PreparedStatement st = con.prepareStatement(q);
				st.setString(1, space);
				ResultSet rs = st.executeQuery();
				while(rs.next())
				{
					String temp = rs.getString(1);
					s+=temp;
					s+=",";
				}
			}
			else if(spaceType.equals("atrium"))
			{
				String q="select distinct start_date from booking where space = ?;";
				PreparedStatement st = con.prepareStatement(q);
				st.setString(1, space);
				ResultSet rsA = st.executeQuery();
				while(rsA.next())
				{
					String dd = rsA.getString(1);
					String slots = "select units from booking where space = ? and start_date = ?;";
					PreparedStatement slot = con.prepareStatement(slots);
					slot.setString(1,space);
					slot.setString(2, dd);
					ResultSet rs = slot.executeQuery();
					int size = 0;
					while(rs.next()) {
						size++;
					}
					if(size > 2) {
						String temp = rsA.getString(1);
					s+=temp;
					s+=",";
					}
				}
			}
			else if (spaceType.equals("banner"))
			{
				String sq_query = "select sqrft from banner where space = ?;";
				PreparedStatement sq = con.prepareStatement(sq_query);
				sq.setString(1, space);
				ResultSet sqr = sq.executeQuery();
				sqr.next();
				int sqrft = sqr.getInt(1);
				String q = "select start_date from booking  where space = ? group by start_date having sum(units)=?;";
				PreparedStatement st = con.prepareStatement(q);
				st.setString(1, space);
				st.setInt(2, sqrft);
				ResultSet rs = st.executeQuery();
				while(rs.next())
				{
					String temp = rs.getString(1);
					s+=temp;
					s+=",";
				}
			}
			else if(spaceType.equals("theatre"))
			{
				String q = "select start_date from booking where space = ?";
				PreparedStatement st = con.prepareStatement(q);
				st.setString(1, space);
				ResultSet rest = st.executeQuery();
				while(rest.next()){
					String bd = rest.getString(1);
					s += rest.getString(1);
					s+=',';
					try {
						ad.setTime(sdf.parse(bd));
						sub.setTime(sdf.parse(bd));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					for(int i=0;i<6;i++) {
					ad.add(Calendar.DAY_OF_MONTH, 1);
					String dt = sdf.format(ad.getTime());
					s+=dt;
					s+=',';
					}
					for(int i=0;i<6;i++) {
						sub.add(Calendar.DAY_OF_MONTH, -1);
						String dt = sdf.format(sub.getTime());
						s+=dt;
						s+=',';
						}
				}
			}
		}
			
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
	public int endDate(String dt,String type)
	{
		String s="";
		int daysBetween = 0;
		System.out.println(dt);
		System.out.println(type);
		if(dt.equals(null))
			return 30;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			String q="select start_date from booking where space = ? and start_date > ? order by start_date asc;";
			PreparedStatement st = con.prepareStatement(q);
			st.setNString(1, type);
			st.setString(2, dt);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				String temp = rs.getString(1);
				s+=temp;
				break;
			}
			if(s == "")
				return 30;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar sd = Calendar.getInstance();
			Calendar ed = Calendar.getInstance();
			try{
				ed.setTime(sdf.parse(s));
				sd.setTime(sdf.parse(dt));
				
			}catch(ParseException e){
				e.printStackTrace();
			}
			
			daysBetween = (int) ChronoUnit.DAYS.between(sd.toInstant(), ed.toInstant());
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		if(daysBetween>30)
			return 30;
		return daysBetween;
	}
}
