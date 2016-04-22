package com.sachin.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.sachin.model.Stock;

@Repository("stockDao")
public class StockDaoImpl implements StockDao {	
	
	
	@Override
	public ArrayList<Stock> listValues(String id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		ArrayList<Stock> al = new ArrayList<Stock>();
		Connection con = null;
		try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
               .getConnection("jdbc:postgresql://localhost:5432/webapp",
               "postgres", "sachin");             
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"public\".\"Historical\" where \"Name\"=\'" + id +"\' limit 100;" );
            while ( rs.next() ) {                
                String  name = rs.getString("Name");
                float open  = rs.getFloat("Open");
                float high = rs.getFloat("High");
                float low = rs.getFloat("Low");
                float close = rs.getFloat("Close");
                int vol = rs.getInt("Volume");
                String  date = rs.getString("Date");
                Stock s = new Stock(name,open,high,low,close,vol,date);
                al.add(s);                
//                System.out.println( "Name = " + name );
                /*System.out.println( "Open = " + open );
                System.out.println( "High = " + high );
                System.out.println( "Low = " + low );
                System.out.println( "Close = " + close );
                System.out.println( "Volume = " + vol );*/
//                System.out.println();
             }
             rs.close();
             stmt.close();
             con.close();
         } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
         }
		return al;
	}
	
	public ArrayList<String> listNames() {
		ArrayList<String> al = new ArrayList<String>();
		Connection con = null;
		try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
               .getConnection("jdbc:postgresql://localhost:5432/webapp",
               "postgres", "sachin");             
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT DISTINCT \"Name\" FROM \"public\".\"Historical\";" );
            while ( rs.next() ) {                
                String  name = rs.getString("Name");
                //System.out.println(name);
                al.add(name);
             }
             rs.close();
             stmt.close();
             con.close();
         } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
         }
		return al;
	}
	
	@Override
	public Stock listCurrent(String id) {
		Connection con = null;
		Stock s = null;
		try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
               .getConnection("jdbc:postgresql://localhost:5432/webapp",
               "postgres", "sachin");             
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"public\".\"Historical\" where \"Name\"=\'" + id +"\' limit 1;" );
            //while ( rs.next() ) {
            	rs.next();
                String  name = rs.getString("Name");
                float open  = rs.getFloat("Open");
                float high = rs.getFloat("High");
                float low = rs.getFloat("Low");
                float close = rs.getFloat("Close");
                int vol = rs.getInt("Volume");
                String  date = rs.getString("Date");
                s = new Stock(name,open,high,low,close,vol,date);
             rs.close();
             stmt.close();
             con.close();             
         } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
         }
		return s;
	}
	
	@Override
	public Stock listGoogle() {
		Connection con = null;
		Stock s = null;
		try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
               .getConnection("jdbc:postgresql://localhost:5432/webapp",
               "postgres", "sachin");             
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"public\".\"Historical\" where \"Name\"=\'AMZN\' order by \"High\" desc limit 1;" );            
            //while ( rs.next() ) {
            	rs.next();
                String  name = rs.getString("Name");
                float open  = rs.getFloat("Open");
                float high = rs.getFloat("High");
                float low = rs.getFloat("Low");
                float close = rs.getFloat("Close");
                int vol = rs.getInt("Volume");
                String  date = rs.getString("Date");
                s = new Stock(name,open,high,low,close,vol,date);                
//                System.out.println( "Name = " + name );
                /*System.out.println( "Open = " + open );
                System.out.println( "High = " + high );
                System.out.println( "Low = " + low );
                System.out.println( "Close = " + close );
                System.out.println( "Volume = " + vol );*/
//                System.out.println();
             //}
             rs.close();
             stmt.close();
             con.close();             
         } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
         }
		return s;
	}

}
