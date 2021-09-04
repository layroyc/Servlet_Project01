package com.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hp.entity.Goods;
import com.hp.util.DBHelper;

public class GoodsDaoImpl implements GoodsDao{

	//全查
	@Override
	public ArrayList<Goods> selectAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ArrayList<Goods> list = new ArrayList<Goods>();
		try {
			conn=DBHelper.getConn();
			String sql="select * from goodsinfo";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery(); 
			Goods g=null;
			while(rs.next()){
				g=new Goods(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8)
						); 
				list.add(g);
			}

		} catch (SQLException e) {
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
		return list;
	}

	//修改
	@Override
	public int update(Goods goods) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		int u=0;
		try {
			conn=DBHelper.getConn();
			String sql="update goodsinfo set goodsType=?,goodsName=?,goodsRent=?,goodsCount=?,supplier=?,telphone=?,goodsState=? where goodsId=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,goods.getGoodsType());
			ps.setString(2,goods.getGoodsName());
			ps.setFloat(3, goods.getGoodsRent());
			ps.setInt(4, goods.getGoodsCount());
			ps.setString(5, goods.getSupplier());
			ps.setString(6, goods.getTelphone());
			ps.setInt(7, goods.getGoodsState());
			ps.setInt(8, goods.getGoodsId());
			
			u=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}
		return u;		
	}

	@Override
	public Goods selectById(int goodsId) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Goods goods=null;
		try {
			conn=DBHelper.getConn();
			String sql="select * from goodsinfo where goodsId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, goodsId);
			rs=ps.executeQuery();
			while(rs.next()){
				goods=new Goods(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8)
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
		return goods;
	}
	
	//添加
	@Override
	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			//书写sql语句
			conn=DBHelper.getConn();
			String sql = "insert into goodsinfo(goodsType,goodsName,goodsRent,goodsCount,supplier,telphone,goodsState) values (?,?,?,?,?,?,?)";
			//执行sql
			ps=conn.prepareStatement(sql);
			ps.setString(1,goods.getGoodsType());
			ps.setString(2,goods.getGoodsName());
			ps.setFloat(3, goods.getGoodsRent());
			ps.setInt(4, goods.getGoodsCount());
			ps.setString(5, goods.getSupplier());
			ps.setString(6, goods.getTelphone());
			ps.setInt(7, goods.getGoodsState());
			i=ps.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}
		return i;
	}

	//删除
	@Override
	public int delete(int goodsId) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		try {
			conn=DBHelper.getConn();
			String sql="delete from goodsinfo where goodsId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, goodsId);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}
		return i;
	}

	//单查
	@Override
	public Goods selectone(String goodsName) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Goods goods =null;
		try {
			conn=DBHelper.getConn();
			String sql="select * from goodsinfo where goodsName=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, goodsName);
			rs=ps.executeQuery(); 

			while(rs.next()){
			  goods=new Goods(
					  rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8)
					  );
			}
		} catch (SQLException e) {
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
		return goods;	
	}

	@Override
	public int selectName(String goodsType,String goodsName,String supplier,String telphone) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		try {
			conn=DBHelper.getConn();
			StringBuffer sql= new StringBuffer();
//			String sql2="select * from goodsinfo where goodsName like ?";
			sql.append("select count(goodsId) from goodsinfo where goodsName like ?");
			 ps = conn.prepareStatement(sql.toString());
			if(goodsType != null){
				sql.append("and goodsType = "+goodsType);
			}
			if(goodsName != null){
				sql.append("and goodsName = "+goodsName);
			}
			if(supplier != null){
				sql.append("and supplier = "+supplier);
			}
			if(telphone != null){
				sql.append("and telphone = "+telphone);
			}
			
			ps.setString(1, "%"+goodsName+"%");
			rs=ps.executeQuery(); 

			while(rs.next()){
				 count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}
		return count;	

	}


}
