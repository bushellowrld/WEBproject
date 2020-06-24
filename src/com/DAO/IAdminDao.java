package com.DAO;

import java.util.List;

import entity.Users;

public interface IAdminDao {
	        //根据用户Id获取用户信息
			public Users getUserById(int mid);
	        //管理员登录
			public Users doLoginByAdmin(String saccount,int spwd);
			//获取用户列表
			public List<Users> getUserList();
			//删除用户
			public boolean delUserByUserId(int mid);


}
