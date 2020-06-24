package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.Database;

import entity.Users;
import entity.Admin;

public class UserDaoImpl implements IUserDao {
	Database db;
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
		db = new Database();
	}

	//登录验证
	@Override
	public Users doLogin(String maccount, String mpassword) {
		Connection con = db.getConnection();
		String sql = "select * from project.member "
				+ "where maccount=? and mpassword=?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maccount);
			stmt.setString(2, mpassword);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				Users user = getUserByResultSet(rs);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 注册用户
	 */
	@Override
	public boolean addUser(Users u) {
		if(this.isLoginId(u.getMaccount())){//s
			return false;
		}
		Connection con = db.getConnection();
		String sql;
		if(u.getMaddress()!=null){
			sql = "insert into project.member(mid,mname,msex,mcity,maddress,mpostcode,mphone,memail,maccount,mpassword) value(1,?,?,?,?,?,?,?,?,?)";
		}else{
			sql = "insert into project.member(mid,mname,msex,mcity,maddress,mpostcode,mphone,memail,maccount,mpassword) value(?,?,?,?,?,?,?,?,?,?)";
		}
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			/* stmt.setString(1, u.getMid()); */
			stmt.setString(1, u.getMname());
			stmt.setString(2, u.getMsex());
			stmt.setString(3, u.getMcity());
			stmt.setString(4, u.getMaddress());
			stmt.setString(5, u.getMpostcode());
			stmt.setString(6, u.getMphone());
			stmt.setString(7, u.getMemail());
			stmt.setString(8, u.getMaccount());
			stmt.setString(9, u.getMpassword());
			/*
			 * if(u.getMaddress()!=null){ stmt.setString(5, u.getMaddress()); }else{
			 * stmt.setString(5, "空"); stmt.setInt(7, u.getUserRoleId()); stmt.setInt(8,
			 * u.getUserStateId()); }
			 */
			int rs = stmt.executeUpdate();
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean isLoginId(String maccount) {
		Connection con = db.getConnection();
		String sql = "select * from project.member "
				+ "where maccount=?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maccount);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改用户信息
	 */
	@Override
	public boolean updateUser(Users u) {
		Connection con = db.getConnection();
		String sql;
		if(u.getMaccount()==null){
			sql = "UPDATE project.member SET `mname`=?,msex=?,mcity=?,maddress=?,mpostcode=?,mphone=?,memail=? WHERE mid=?";
		}else{
			sql = "UPDATE project.member SET `mname`=?,msex=?,mcity=?,maddress=?,mpostcode=?,mphone=?,memail=? WHERE mid=?";
		}
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			//设置参数值
			stmt.setString(1,u.getMname());
			stmt.setString(2,u.getMsex());
			stmt.setString(3,u.getMcity());
			stmt.setString(4,u.getMpostcode());
			stmt.setString(5,u.getMphone());
			stmt.setString(6,u.getMemail());
			stmt.setString(7,u.getMaddress());
			if(u.getMaccount()==null){
				stmt.setInt(8,u.getMid());
			}else{
				stmt.setString(9,u.getMaccount());
				stmt.setInt(10,u.getMid());
			}
			
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
	 * 根据用户Id获取用户信息 admin
	 */
	@Override
	public Users getUserById(int mid) {
		Connection con = db.getConnection();
		String sql = "select * from project.member "
				+ "where mid=?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, mid);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				Users user = getUserByResultSet(rs);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 后台登录   admin
	 */
	public Admin doLoginByAdmin(String saccount, String spassword) {
		Connection con = db.getConnection();
		String sql = "select * from project.staff "
				+ "where saccount=? and spassword=? ";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, saccount);
			stmt.setString(2, spassword);
			ResultSet ars = stmt.executeQuery();
			if(ars.next()){
				//Users user = getUserByResultSet(rs);
				Admin admin = getAdminByresultSet(ars);
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 获取用户列表  删除 放入管理员功能
	 */
	public List<Users> getUserList() {
		List<Users> ulist=new ArrayList<Users>();
		//得到连接
		Connection con=db.getConnection();
		String sql="select * from project.users order by Id desc";
		try {
			//创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //ִ执行sql语句
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Users u = getUserByResultSet(rs);
				ulist.add(u);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ulist;
	}

	/**
	 * 根据用户Id删除用户  管理员功能
	 */
	public boolean delUserByUserId(int mid) {
		Connection con=db.getConnection();
		String sql = "DELETE FROM project.users WHERE Id="+mid;
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
	 * 封装结果集
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Admin getAdminByresultSet(ResultSet ars) throws SQLException{
		Admin admin = new Admin();
//		user.setMid(rs.getInt(1));
		admin.setSname(ars.getString(1));
		admin.setSaccount(ars.getString(2));
		admin.setSpwd(ars.getString(3));
		
		return admin;
	}
	
	private Users getUserByResultSet(ResultSet rs) throws SQLException{
		Users user = new Users();
//		user.setMid(rs.getInt(1));
		user.setMaccount(rs.getString(1));
		user.setMpassword(rs.getString(2));
		user.setMname(rs.getString(3));
		user.setMsex(rs.getString(4));
		user.setMcity(rs.getString(5));
		user.setMaddress(rs.getString(6));
		user.setMpostcode(rs.getString(7));
		user.setMphone(rs.getString(8));
		user.setMemail(rs.getString(9));
		
		return user;
	}


}

