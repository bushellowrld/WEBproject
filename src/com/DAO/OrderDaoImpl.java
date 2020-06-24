package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.IOrderDao;
import com.db.Database;
import entity.Orders;

public class OrderDaoImpl implements IOrderDao {
	Database db;
	public OrderDaoImpl() {
		db = new Database();
	}
	
	/**
	 * 添加订单  改
	 * @param order
	 * @return 订单Id
	 */
	public int addOrder(Orders orders) {
		//得到连接
		Connection con = db.getConnection();
		//创建sql语句(CURRENT_TIMESTAMP()为获取当前时间)
		String sql = "insert into project.order(oid,pid,mid,odate,price,number,senddate,maddress)"
				+ " value(?,?,?,CURRENT_TIMESTAMP(),?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			//封装sql语句
			stmt = con.prepareStatement(sql);
			//设置参数
			stmt.setInt(1, orders.getOid());
			stmt.setString(2, orders.getPid());
			stmt.setInt(3, orders.getMid());
			stmt.setInt(4, orders.getPrice());
			stmt.setInt(5, orders.getNumber());
			stmt.setString(6, orders.getSenddate());
			stmt.setString(7, orders.getMaddress());
//			stmt.setDouble(2, orders.getPrice());
			//执行sql语句(返回影响行数)
			int row = stmt.executeUpdate();
			if(row>0){
				//如果影响行数大于0,说明插入成功,执行下面的sql语句,获取插入的自增长的Id
				ResultSet rs = stmt.executeQuery("select LAST_INSERT_ID()");
				if (rs.next())
					//返回自增长的Id
					return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//返回-1表示插入失败
		return -1;
	}
	
	/**
	 * 添加详细订单    是否能和一起
	 * @param orderBook
	 * @return 
	 */
//	@Override
//	public boolean addOrderBook(OrderBook orderBook) {
//		//得到连接
//		Connection con = db.getConnection();
//		//创建sql语句
//		String sql = "insert into product(oid,pid,number,price)"
//				+ " value(?,?,?,?)";
//		PreparedStatement stmt = null;
//		try {
//			//封装sql语句
//			stmt = con.prepareStatement(sql);
//			//设置参数
//			stmt.setInt(1, orderBook.getOrderId());
//			stmt.setInt(2, orderBook.getBookId());
//			stmt.setInt(3, orderBook.getQuantity());
//			stmt.setDouble(4, orderBook.getUnitPrice());
//			//执行sql语句
//			int rs = stmt.executeUpdate();
//			if(rs>0){
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	
	/**
	 * 根据当前登录用户Id获取对应的订单
	 * @param userId
	 * @return
	 */
	public List<Orders> getOrder(int mid) {
		List<Orders> olist=new ArrayList<Orders>();
		//得到连接
		Connection con=db.getConnection();
		//sql语句
		String sql="SELECT project.order.* FROM order where order.mid="+mid+" ORDER BY Id DESC";
		//"SELECT orderbook.*,orders.OrderDate,books.Title FROM orders,orderbook,books WHERE orderbook.OrderID=orders.Id AND orderbook.BookID=books.Id AND orders.UserId="+userId +" ORDER BY Id DESC";
		try {
			//封装sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //ִ执行sql
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				//提取查询的记录进行封装,并添加到集合中
				Orders obc = new Orders();
				obc.setOid(rs.getInt(1));
				obc.setPid(rs.getString(2));
				obc.setMid(rs.getInt(3));
				obc.setOdate(rs.getString(4));
				obc.setPrice(rs.getInt(5));
				obc.setNumber(rs.getInt(6));
				obc.setSenddate(rs.getString(7));
				obc.setMaddress(rs.getString(8));
				olist.add(obc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olist;
	}


}
