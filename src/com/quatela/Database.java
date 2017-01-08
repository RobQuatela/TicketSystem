package com.quatela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

	private static Connection conn;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	private static String connString = "jdbc:mysql://localhost:3306/ticketsystem?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String pass = "tturtles4";
	
	public static List<Object> selectStatement(Object selectParam, String table, int colIndex) {
		String sql = String.format("SELECT %s FROM %s", selectParam, table);
		List<Object> obj = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(connString, user, pass);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				obj.add(rs.getObject(colIndex));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null && !rs.isClosed())
					rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return obj;
	}
	
	public static Object selectStatement(Object selectParam, String table, int colIndex, String whereClause, Object whereValue) {
		String sql = String.format("SELECT %s FROM %s WHERE %s = ?", selectParam, table, whereClause);
		Object obj = null;
		
		try {
			conn = DriverManager.getConnection(connString, user, pass);
			stmt = conn.prepareStatement(sql);
			stmt.setObject(1, whereValue);
			rs = stmt.executeQuery();
			
			if(rs.next())
				obj = rs.getObject(1);
			else
				System.out.println("No values to pull");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null && !rs.isClosed())
					rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return obj;
	}
	
	public static void insertStatement(String desc, String status, java.sql.Date start) {
		String sql = "INSERT INTO tbticket (ticket_description, ticket_status, ticket_date_start) " +
					"(?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(connString, user, pass);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, desc);
			stmt.setString(2, status);
			stmt.setDate(3, start);
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
