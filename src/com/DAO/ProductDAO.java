package com.DAO;

import java.util.List;
import entity.Products;

public interface ProductDAO {
	//获取所有的
	public List<Products> getAll();
	//根据名字获取产品
	public Products find(String pname);

}
