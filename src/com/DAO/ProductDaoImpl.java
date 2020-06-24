package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.IProductDao;
import com.db.Database;
import entity.Products;


public class ProductDaoImpl implements IProductDao {
	
	Database db;
	public ProductDaoImpl(){
		db=new Database();
	}

	//按书名
	@Override
	public List<Products> getProductsByName(String name) {
		List<Products> blist=new ArrayList<Products>();
		//1.得到连接
		Connection con=db.getConnection();
		String sql="select *"+
		" from project.product"+
		" where pname like '%"+name+"%'";
		try {
			//2.创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //3.ִ执行sql语句
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Products b = getProductByResultSet(rs);
				blist.add(b);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blist;
	}
	
	@Override
	public Products getProductsById(int id) {
		//得到数据连接对象
		Connection con=db.getConnection();
		String sql="select *"+
		" from project.product"+
		" where pid=?";
		Products b=null;
		try {
			//创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
            //执行sql
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				b = getProductByResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	
	//封装结果集
	private Products getProductByResultSet(ResultSet rs) throws SQLException{
		Products b = new Products();
		b.setPid(rs.getString(1));
		b.setType(rs.getString(2));
		b.setPname(rs.getString(3));
		b.setPprice(rs.getInt(4));
		b.setDiscount(rs.getInt(5));
		b.setOrigin(rs.getString(6));
		b.setDirector(rs.getString(7));
		b.setAct(rs.getString(8));
		b.setPdate(rs.getString(9));
		b.setExplain(rs.getString(10));
		return b;
	}


	/**
	 * 获取所有图书  ？管理员的
	 */
	//按id降序排列
	@Override
	public List<Products> getProductList() {
		List<Products> blist=new ArrayList<Products>();
		//得到数据连接对象
		Connection con=db.getConnection();
		String sql="SELECT * FROM project.product ORDER BY pid DESC;";
		try {
			//创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //执行sql
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Products b = getProductByResultSet(rs);
				blist.add(b);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blist;
	}

	/**
	 * 删除图书 管理员的
	 */
	@Override
	public boolean delProductPId(String Pid) {
		Connection con=db.getConnection();
		String sql = "DELETE FROM project.product WHERE pid="+Pid;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			int rs = stmt.executeUpdate();
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 更新图书信息  管理员的
	 */
	@Override
	public boolean upProduct(Products b) {
		Connection con = db.getConnection();
		String sql = "UPDATE project.product SET pid=?,type=?,pname=?,pprice=?,discount=?,origin=?,director=?,act=?,pdate=? ,explain=?  WHERE pid=?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			//设置参数值
			stmt.setString(1,b.getPid());
			stmt.setString(2,b.getType());
			stmt.setString(3,b.getPname());
			stmt.setInt(4,b.getPprice());
			stmt.setInt(5,b.getDiscount());
			stmt.setString(6,b.getOrigin());
			stmt.setString(7,b.getDirector());
			stmt.setString(8,b.getAct());
			stmt.setString(9,b.getPdate());
			stmt.setString(10,b.getExplain());
			int rs = stmt.executeUpdate();
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 添加图书 管理员的
	 */
	@Override
	public boolean addProduct(Products b) {
		Connection con = db.getConnection();
		//sql语句
		String sql= "insert into project.product(pid,type,pname,pprice,discount,origin,director,act,padate,explain) value(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			//设置参数
			stmt.setString(1,b.getPid());
			stmt.setString(2,b.getType());
			stmt.setString(3,b.getPname());
			stmt.setInt(4,b.getPprice());
			stmt.setInt(5,b.getDiscount());
			stmt.setString(6,b.getOrigin());
			stmt.setString(7,b.getDirector());
			stmt.setString(8,b.getAct());
			stmt.setString(9,b.getPdate());
			stmt.setString(10,b.getExplain());
			//执行sql语句
			int rs = stmt.executeUpdate();
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
