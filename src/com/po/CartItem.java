package com.po;

import java.io.Serializable;

import entity.Products;

public class CartItem implements Serializable {
private static final long serialVersionUID = 5944270461320472455L;
	
	private  Products item;
	private int amount=0;
	
	public CartItem(Products newProduct,int num){
		super();
		if(num>0){
			item = newProduct;
			amount = num;
		}
	}
	
	public void inAmount(){
		amount++;
	}
	public void inAmount(int num){
		amount+=num;
	}
	public void deAmount(){
		amount--;
	}
	public Products getItem(){
		return item;
	}
	public int getAmount(){
		return amount;
	}

}
