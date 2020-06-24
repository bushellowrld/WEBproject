package com.listener;

import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import com.db.Database;

public class ContextListener implements ServletContextListener {
	//连接池销毁时
		@Override
		public void contextDestroyed(ServletContextEvent arg0) {
			DataSource ds = Database.getInstance().getDataSource();
			try {
				ds.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//连接池启动时
		@Override
		public void contextInitialized(ServletContextEvent arg0) {
			try {
				InitialContext ctx = new InitialContext();
				DataSource ds =  (DataSource) ctx.lookup("java:comp/env/jdbc/mysqlds");
				Database.getInstance().initDataSource(ds);
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			System.out.println("数据库连接池初始化完毕！");
		}

}
