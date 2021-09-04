package com.hp.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	  private static Properties prop = new Properties();
			static{
			InputStream in=null;
			try {
				in = DBHelper.class.getResourceAsStream("/jdbc.properties");
				prop.load(in);
		Class.forName(prop.getProperty("driver"));
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		public static Connection getConn() throws SQLException{
					Connection conn= DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
					return conn;
				}
		
	  public static void close(ResultSet rs,PreparedStatement ps,Connection conn) throws SQLException{
					if(rs!=null) rs.close();
					if(ps!=null) ps.close();
					if(conn!=null) conn.close();
				}
				
	 public static void close(PreparedStatement ps,Connection conn) throws SQLException{
					if(ps!=null) ps.close();
					if(conn!=null) conn.close();
	}
	 public static void main(String[] args) throws SQLException {
		System.out.println(DBHelper.getConn());
	}
}
