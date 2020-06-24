
package com.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Database {

	private DataSource ds;
	private static Database instance;

	public Database() {
		
	}

	public static Database getInstance(){
		if(instance == null){
			instance = new Database();
		}
		return instance;
	}
	
	//初始化data资源
	public void initDataSource(DataSource ds){
		this.ds = ds;
	}
	
	/**
	 * 获取连接对象
	 * @return
	 */
	public Connection getConnection() {
		try {
			return  Database.getInstance().getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public DataSource getDataSource(){
		return ds;
	}
	

}
