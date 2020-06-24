package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ProductDaoImpl;

import com.po.StringUtil;
import entity.Products;
import entity.PageBean;

/**
 * Servlet implementation class p_adminServlet
 */
@WebServlet("/p_adminServlet")
public class p_adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public p_adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt = request.getParameter("opt");
		
		if(opt.equals("productlist")){
			productListByAdmin(request, response);
		}
		else if(opt.equals("del")){
			delProductByAdmin(request, response);
		}
		else if(opt.equals("show")){
			showProductByAdmin(request, response);
		}
		else if(opt.equals("edit")){
			editProductByAdmin(request, response);
		}
		else if(opt.equals("add")){
			addProductByAdmin(request, response);
		}

	}
	
	/**
	 * 获取商品列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void productListByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDaoImpl dao = new ProductDaoImpl();
		List<Products> blist = dao.getProductList();
		//获取分页
		Integer page=1;
		String strPage = request.getParameter("page");
		if(StringUtil.isNumber(strPage)==false){
		}else{
			page =Integer.parseInt(strPage);
		}
		//封装成分页对象
		PageBean<Products> Pager = new PageBean<Products>(page,20,blist);
		request.getSession().setAttribute("blist", Pager);
		response.sendRedirect("p_admin.jsp");
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delProductByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(StringUtil.isNumber(request.getParameter("pid"))==false){
			response.sendRedirect("p_admin.jsp");
			return;
		}
		String pid = request.getParameter("pid");
		ProductDaoImpl dao = new ProductDaoImpl();
		boolean b = dao.delProductPId(pid);
		//存入操作信息
		if(b==true){
			request.getSession().setAttribute("ADMIN_MSG_BOOK","删除成功");
		}else{
			request.getSession().setAttribute("ADMIN_MSG_BOOK","删除失败");
		}
		productListByAdmin(request, response);
	}
	
	/**
	 * 进入编辑图书页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showProductByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(StringUtil.isNumber(request.getParameter("pid"))==false){
			response.sendRedirect("p_admin.jsp");
			return;
		}
		int bookId = Integer.parseInt(request.getParameter("pid"));
		ProductDaoImpl dao = new ProductDaoImpl();
		Products b = dao.getProductsById(bookId);
		if(b!=null){
			//存入需要编辑用户
			request.getSession().setAttribute("editBook",b);
			response.sendRedirect("p_admin.jsp");
		}
//		else{
//			response.sendRedirect("p.jsp");
//		}
		
	}
	
	/**
	 * 编辑图书
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editProductByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(StringUtil.isNumber(request.getParameter("pid"))==false){
			response.sendRedirect("p_admin.jsp");
			return;
		}
		String pid = request.getParameter("pid");
		//提取参数
		String type = request.getParameter("type");
		String pname =  request.getParameter("pname");
		int pprice =  Integer.parseInt(request.getParameter("pprice"));
		int discount =  Integer.parseInt(request.getParameter("discount"));
		String origin = request.getParameter("origin");
		String director =  request.getParameter("director");
		String act =  request.getParameter("act");
		String pdate =  request.getParameter("pdate");
		String explain =  request.getParameter("explain");
		//封装对象
		Products product = new Products();
		product.setPid(pid);
		product.setType(type);
		product.setPname(pname);
		product.setPprice(pprice);
		product.setDiscount(discount);
		product.setOrigin(origin);
		product.setDirector(director);
		product.setAct(act);
		product.setPdate(pdate);
		product.setExplain(explain);
		//调用dao层方法
		ProductDaoImpl dao = new ProductDaoImpl();
		Boolean b = dao.upProduct(product);
		//设置修改信息结果字符串
		if(b)
			request.getSession().setAttribute("ADMIN_MSG_BOOK", "信息编辑成功,PID:"+pid);
		else
			request.getSession().setAttribute("ADMIN_MSG_BOOK", "信息编辑失败,PID:"+pid);
			
		showProductByAdmin(request, response);
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addProductByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取提交的参数
		
		String type = request.getParameter("type");
		String pname =  request.getParameter("pname");
		int pprice =  Integer.parseInt(request.getParameter("pprice"));
		int discount =  Integer.parseInt(request.getParameter("discount"));
		String origin = request.getParameter("origin");
		String director =  request.getParameter("director");
		String act =  request.getParameter("act");
		String pdate =  request.getParameter("pdate");
		String explain =  request.getParameter("explain");
		
		//信息完整性校验
		if(pname==null 
				|| pname.equals("") 
//				|| pprice == null 
				|| pprice<0){
			request.getSession().setAttribute("ADMIN_MSG_BOOK", "添加失败,请检查图书信息是否正确");
			response.sendRedirect("useredit.jsp");
			return;
		}
		//封装对象
		Products product = new Products();
		product.setType(type);
		product.setPname(pname);
		product.setPprice(pprice);
		product.setDiscount(discount);
		product.setOrigin(origin);
		product.setDirector(director);
		product.setAct(act);
		product.setPdate(pdate);
		product.setExplain(explain);
		//调用dao层方法
		ProductDaoImpl dao = new ProductDaoImpl();
		//页面跳转
		if(dao.addProduct(product)){
			request.getSession().setAttribute("ADMIN_MSG_BOOK", "添加成功,图书:"+pname);
			productListByAdmin(request, response);
		}else{
			request.getSession().setAttribute("ADMIN_MSG_BOOK", "添加失败！");
			response.sendRedirect("p_admin.jsp");
		}
		
	}

}
