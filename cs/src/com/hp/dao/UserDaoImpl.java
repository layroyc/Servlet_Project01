package com.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.entity.User;
import com.hp.util.DBHelper;

public class UserDaoImpl implements UserDao{

	//登录
	@Override
	public User selectUP(String name, String pwd) {
		// TODO Auto-generated method stub
		User user=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBHelper.getConn();
			String sql="select * from userinfo where name=? and pwd=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new User(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(rs, ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user;
	}

	//注册
	@Override
	public int zhuCe(String name, String pwd, String phone) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			conn=DBHelper.getConn();
			String sql1 = "insert into userinfo(name,pwd,phone) values (?,?,?)";
			ps=conn.prepareStatement(sql1);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ps.setString(3, phone);
			i=ps.executeUpdate();
			System.out.println(i);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

}
