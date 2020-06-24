package com.DAO;

import java.util.List;

import entity.Orders;

public interface IOrderDao {
	/**
	 * 添加订单
	 * @param order
	 * @return 订单Id
	 */
	public int addOrder(Orders order);
	
	/**
	 * 根据当前登录用户Id获取对应的订单
	 * @param userId
	 * @return
	 */
	public List<Orders> getOrder(int mid);
	
	

}
