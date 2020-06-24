package com.DAO;

import java.util.List;

import entity.Products;

public interface IProductDao {
	//根据书名获取图书
		public List<Products> getProductsByName(String name);
		
		public Products getProductsById(int id);
		//获取所有图书
		public List<Products> getProductList();
		//删除图书
		public boolean delProductPId(String pid);
		//修改图书信息
		public boolean upProduct(Products b);
		//添加图书
		public boolean addProduct(Products product);

		
}
