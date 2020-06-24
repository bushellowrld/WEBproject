package com.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ProductDaoImpl;
import entity.Products;
import com.po.Cart;
import com.po.StringUtil;
import entity.Users;
import com.po.CartItem;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);//s
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt = request.getParameter("opt");
		//判断操作
		if(opt.equals("buy")){
			buyCart(request, response);//s
		}else if(opt.equals("del")){
			delCart(request, response);
		}else if(opt.equals("clear")){
			clearCart(request, response);
		}else if(opt.equals("show")){
			showCart(request, response);
		}else if(opt.equals("inAmount")){
			inAmount(request, response);
		}else if(opt.equals("deAmount")){
			deAmount(request, response);
		}
//		else{
//			response.sendRedirect("index.jsp");
//		}
	}
	
	/**
	 * 添加商品到购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void buyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart==null){
			cart = new Cart();
		}
		//获取购买数量
		String strNum = request.getParameter("num");
		if(!StringUtil.isNumber(strNum))
			strNum="1";
		
		int num = Integer.parseInt(strNum);
		
		int pid = Integer.parseInt(request.getParameter("pid"));//s
		ProductDaoImpl dao = new ProductDaoImpl();
		Products product = dao.getProductsById(pid);
		//把商品添加到购物车
		cart.add(product, num);
		
		request.getSession().setAttribute("cart",cart);
		//跳转页面
		response.sendRedirect("addcartok.jsp");
	}
	protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart!=null){
			cart.clear();
			request.getSession().setAttribute("cart", cart);
		}
		//页面跳转
		showCart(request, response);
	}
	
	/**
	 * 删除购物车中的商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//判空
		if(cart!=null){
			
			String pname = request.getParameter("pname");
			//删除这个
			if(pname!=null && !pname.equals("")){
				cart.remove(pname);
//				//商品种类减1
				cart.setItemAmount();
//				
//				//计算商品总价
				cart.getTotalReal();
				request.getSession().setAttribute("cart", cart);
//
			}
		}
		showCart(request, response);
	}
	
	/**
	 * 显示购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart!=null){
			Collection<CartItem> silist = cart.getItems();
			request.getSession().setAttribute("silist", silist);
			//计算商品总价
			cart.getTotalReal();
		}else{
			cart = new Cart();
		}
		request.getSession().setAttribute("cart", cart);
		
		Users user = (Users) request.getSession().getAttribute("user");
		response.sendRedirect("cart.jsp");
//		if(user!=null){
//			//页面跳转
//			response.sendRedirect("user/usercart.jsp");
//		}else{
//			//页面跳转
//			response.sendRedirect("cart.jsp");
//		}
	}
	
	/**
	 * 增加购物车商品数量
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void inAmount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session中获取Cart
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart!=null){
			String pid =  request.getParameter("pid");
			//信息完整性校验
			if(pid!=null && !pid.equals("")){
				//获取CartItem
				//pid 是int类型
				CartItem si =  cart.getItem(pid);
				if(si!=null){
					si.inAmount();
				}
				//计算商品总价
				cart.getTotalReal();
				request.getSession().setAttribute("cart", cart);
			}
		}
		
		//页面跳转
		showCart(request, response);
	}
	
	/**
	 * 减少购物车商品数量
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deAmount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session中获取Cart
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart!=null){
			String pid = request.getParameter("pid");
			//信息完整性校验
			if(pid!=null && !pid.equals("")){
				//获取CartItem
				CartItem si =  cart.getItem(pid);
				if(si!=null && si.getAmount()>1)
					si.deAmount();
				//计算商品总价
				cart.getTotalReal();
				request.getSession().setAttribute("cart", cart);
			}
		}
		showCart(request, response);
	}

}
