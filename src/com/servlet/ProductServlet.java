package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ProductDaoImpl;
import entity.Products;
import entity.PageBean;
//需要修改 直接全部输出到页面
/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt = request.getParameter("opt");

		//操作判断
				if(opt.equals("byTitle")){
					queryByName(request, response);
				}else if(opt.equals("byId")){
					buyProduct(request, response);
				}
				
				else {
					response.sendRedirect("order.jsp");
				}
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void queryByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = request.getParameter("value");
		ProductDaoImpl dao = new ProductDaoImpl();
		List<Products> searchPList = new ArrayList<Products>();
		searchPList = dao.getProductsByName(pname);
		//封装成分页对象
		PageBean<Products> Pager = new PageBean<Products>(1,5,searchPList);
		request.getSession().setAttribute("Product", Pager);
		response.sendRedirect("product.jsp");
	}
	
				

				
				/**
				 * 根据图书Id获取,并且跳转到购买页面  改成点击“加入订单”加入，然后在订单页面显示
				 * @param request
				 * @param response
				 * @throws ServletException
				 * @throws IOException
				 */
				protected void buyProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					///获取Id
					int pid =Integer.parseInt(request.getParameter("pid"));
					ProductDaoImpl dao = new ProductDaoImpl();
					Products product = dao.getProductsById(pid);
					
					request.getSession().setAttribute("buyProduct", product);
					response.sendRedirect("buy.jsp");
				}

				
				
	
	
	
}

