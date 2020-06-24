package com.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.OrderDaoImpl;
import entity.Orders;
import entity.Users;
import com.po.Cart;
import com.po.CartItem;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		//判断是否登录
//				if(request.getSession().getAttribute("user")==null){
//					//跳转页面
//					response.sendRedirect("login.jsp");
//					return;
//				}
				//判断操作
				String opt = request.getParameter("opt");
				if(opt.equals("add")){
					addOrder(request, response);
				}
				if(opt.equals("show")){
					showOrder(request, response);
				}
	}
	
	/**
	 * 添加订单   需要封装
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session中的cart(购物车)对象
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//获取从jsp页面传过来的userId
		Users user = (Users) request.getSession().getAttribute("user");
		//将获取的数据封装成Orders对象
		Orders order = new Orders();
//		order.setOid(.getid());
//		order.setPid(user.getMid());
		order.setMid(user.getMid());
		order.setPrice(cart.getTotal());
//		order.setNumber(user.getMid());
		order.setMaddress(user.getMaddress());
		
		//调用dao的添加订单方法
		OrderDaoImpl dao = new OrderDaoImpl();
		int oid = dao.addOrder(order);
		String pid = request.getParameter("pid");
		int mid = Integer.parseInt(request.getParameter("mid"));
		//odate
		String odate = request.getParameter("odate");
		//price 总价
		//int price = Integer.parseInt(request.getParameter("price"));
		//number
		String senddate = request.getParameter("senddate");
		String maddress = request.getParameter("maddress");
		
		//如果返回的订单Id不为-1,则表示添加订单成功
		if(oid!=-1){
			//获取购物车中的所有商品种类
			Collection<CartItem> silist = cart.getItems();
			//遍历每一项商品
			for(CartItem item:silist){
				//需要再封装到order里了
				
				Orders ob = new Orders();
				ob.setOid(oid);
				ob.setPid(item.getItem().getPid());
				ob.setPid(pid);
				ob.setMid(mid);
				ob.setPrice(item.getItem().getPprice());
				ob.setNumber(item.getAmount());
				ob.setSenddate(senddate);
				
				dao.addOrder(ob);
			}
			//清空购物车
			 request.getSession().removeAttribute("cart");
			
			 //改成了不发生跳转
//			//页面跳转
//			response.sendRedirect("payok.jsp");
//		}else{
//			//页面跳转
//			response.sendRedirect("order.jsp");
		}
		
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session中的user对象
		Users user = (Users) request.getSession().getAttribute("user");
		//调用dao层的获取订单方法
		OrderDaoImpl dao = new OrderDaoImpl();
		List<Orders> olist = dao.getOrder(user.getMid());
		//添加到session中
		request.getSession().setAttribute("olist",olist);
		//页面跳转
		response.sendRedirect("order.jsp");
	}
	

}
