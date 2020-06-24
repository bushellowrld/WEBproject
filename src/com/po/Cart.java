package com.po;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import entity.Products;

public class Cart implements Serializable {
	private static final long serialVersionUID = -6120449923757970784L;
	
	private HashMap<String, CartItem>items;
	private int itemAmount;
	private int total;
	
	public Cart(){
		super();
		items = new HashMap<String, CartItem>();
		itemAmount=0;
	}
	
	/**
	 * 添加商品到购物车
	 */
	public synchronized  void add(Products product,int num){
		if(items.containsKey(product.getPname())){
			//获取添加之前的商品数量
			CartItem b =  items.get(product.getPid());
			int amount = b.getAmount();
			num = num + amount;		
			items.remove(product.getPid());
			CartItem newItem = new CartItem(product,num);
			items.put(product.getPname(), newItem);
			
		}else{
			CartItem newItem = new CartItem(product,num);
			items.put(product.getPname(), newItem);
			itemAmount++;
		}
		
	}
	
	/**
	 * 删除购物车中的商品
	 */
	public synchronized void remove(String pid) {
		if(items.containsKey(pid)){
			items.remove(pid);
		}
	}
	
	/**
	 * 获取购物车中的商品列表
	 * @return
	 */
	public synchronized Collection<CartItem> getItems(){
		return items.values();
	}
	
	/**
	 * 根据id获取购物车中对应的CartItem
	 * @param isbn
	 * @return
	 */
	public synchronized CartItem getItem(String pid){
		return items.get(pid);
	}
	
	protected void finalize(){
		items.clear();
	}
	
	/**
	 * 获取购物车中商品数量
	 * @return 
	 */
	public synchronized int getItemAmount(){
		return itemAmount;
	}
	
	/**
	 * 计算商品总价
	 * @return  商品总价
	 */
	public synchronized double getTotalReal(){
		int total = 0;
		Iterator<CartItem> it = getItems().iterator();
		while(it.hasNext()){
			CartItem si = it.next();
			Products product= si.getItem();
			
			//gai
			total+=product.getPprice()*si.getAmount();
		}
		this.total = total;
		return total;
	}
	
	/**
	 * 清空购物车
	 */
	public void clear(){
		items.clear();
		itemAmount=0;
	}

	public double getTotalPrice() {
		return total;
	}

	public void setItemAmount() {
		this.itemAmount--;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}
