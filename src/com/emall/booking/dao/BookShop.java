package com.emall.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookShop {
	String dbuname = "root";
	String dbpass = "root";
	String url="jdbc:mysql://localhost:3306/propertymgmt"; 
	String sql = "insert into booking(customer,space_type,space,start_date,end_date,rent,units,uid) values(?,?,?,?,?,?,?,?);" ;
	public void shop(String customer, String spaceType, String space,String date,String days,int uid) {
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			int da = Integer.parseInt(days);  
			

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();

			try{
			   c.setTime(sdf.parse(date));
			}catch(ParseException e){
			   e.printStackTrace();
			 }
			for(int i=0;i<da;i++) {
			int d = c.get(Calendar.DAY_OF_WEEK);
			String day="";
			//check if holiday
			String holi = "select * from holidays where days = ?";
			PreparedStatement holiday = con.prepareStatement(holi);
			holiday.setString(1,date);
			ResultSet rs = holiday.executeQuery();
			int size = 0;
			while(rs.next()) {
				size++;
			}
			if(size>0)
				day="holiday";
			//checking if weekend
			else if(d == 0 || d == 7)
				day="weekend";
			else
				day="weekday";
			//getting shop amount respected to date
			String rate_query = "select cost,rent_type from spaces where space = ? and duration = ? ";
			PreparedStatement rate_stmt = con.prepareStatement(rate_query);
			rate_stmt.setString(1,space);
			rate_stmt.setString(2, day);
			ResultSet rate_rs = rate_stmt.executeQuery();
			int cost = 0;
			String rent = "";
			while(rate_rs.next())
			{
				cost=rate_rs.getInt(1);
				rent = rate_rs.getString(2);
				break;
			}
			if(rent.equals("hour"))
				cost*=12;
			String start_date = sdf.format(c.getTime()); 
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, customer);
			st.setString(2, spaceType);
			st.setString(3,space);
			st.setString(4,start_date);
			st.setString(5,start_date) ;
			st.setInt(6,cost);
			st.setString(7, day);
			st.setInt(8, uid);
			st.executeUpdate();
			c.add(Calendar.DAY_OF_MONTH, 1);
			}
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void bookTheatre(String customer, String spaceType, String space,String date,String days,int uid)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try{
				c.setTime(sdf.parse(date));
			}catch(ParseException e){
				e.printStackTrace();
			}
		//Incrementing the date by 1 day
			c.add(Calendar.DAY_OF_MONTH, 6);
			String end_date = sdf.format(c.getTime()); 
			String rate_query = "select cost from spaces where space = ? and Duration = 'all' ";
			PreparedStatement rate_stmt = con.prepareStatement(rate_query);
			rate_stmt.setString(1,space);
			ResultSet rate_rs = rate_stmt.executeQuery();
			int cost = 0;
			while(rate_rs.next())
			{
				cost=rate_rs.getInt(1);
				break;
			}			
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, customer);
			st.setString(2, spaceType);
			st.setString(3,space);
			st.setString(4,date);
			st.setString(5,end_date) ;
			st.setInt(6,cost);
			st.setString(7, days);
			st.setInt(8, uid);
			st.executeUpdate();
			
			con.close();
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	public void bookBanner(String customer, String spaceType, String space,String date,int sqrft,int uid)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try{
			   c.setTime(sdf.parse(date));
			}catch(ParseException e){
			   e.printStackTrace();
			 }
			int d = c.get(Calendar.DAY_OF_WEEK);
			
			String day="";
			String holi = "select * from holidays where days = ?";
			PreparedStatement holiday = con.prepareStatement(holi);
			holiday.setString(1,date);
			ResultSet rs = holiday.executeQuery();
			int size = 0;
			while(rs.next()) {
				size++;
			}
			if(size>0)
				day="holiday";
			//checking if weekend
			else if(d == 0 || d == 7)
				day="weekend";
			else
				day="weekday";
			int cost=0;
			String rate_query = "select cost from spaces where space = ? and Duration = ? ";
			PreparedStatement rt = con.prepareStatement(rate_query);
			rt.setString(1, space);
			rt.setString(2,day);
			ResultSet res = rt.executeQuery();
			res.next();
			cost = res.getInt(1);
			cost = cost * sqrft;
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, customer);
			st.setString(2, spaceType);
			st.setString(3,space);
			st.setString(4,date);
			st.setString(5,date) ;
			st.setInt(6,cost);
			st.setInt(7,sqrft);
			st.setInt(8, uid);
			st.executeUpdate();
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	public void bookAtrium(String customer, String spaceType, String space,String date,String slot,int uid)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbuname,dbpass);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try{
			   c.setTime(sdf.parse(date));
			}catch(ParseException e){
			   e.printStackTrace();
			 }
			int d = c.get(Calendar.DAY_OF_WEEK);
			
			String day="";
			String holi = "select * from holidays where days = ?";
			PreparedStatement holiday = con.prepareStatement(holi);
			holiday.setString(1,date);
			ResultSet rs = holiday.executeQuery();
			int size = 0;
			while(rs.next()) {
				size++;
			}
			if(size>0)
				day="holiday";
			//checking if weekend
			else if(d == 0 || d == 7)
				day="weekend";
			else
				day="weekday";
			int rate=0;
			String rate_query = "select cost from spaces where space = ? and Duration = ?";
			PreparedStatement rt = con.prepareStatement(rate_query);
			rt.setString(1,space);
			rt.setString(2,day);
			ResultSet res = rt.executeQuery();
			res.next();
			rate = res.getInt(1);
			rate = rate * 4;
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, customer);
			st.setString(2, spaceType);
			st.setString(3,space);
			st.setString(4,date);
			st.setString(5,date) ;
			st.setInt(6,rate);
			st.setString(7, slot);
			st.setInt(8, uid);
			st.executeUpdate();			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}
