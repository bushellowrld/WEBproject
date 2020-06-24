package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Cart;
import com.DAO.UserDaoImpl;
import entity.Admin;
import entity.PageBean;
import entity.Users;
import com.po.StringUtil;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminServlet() {
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
		
		if(opt.equals("login")){
			loginByAdmin(request, response);
			return;
		}

		//获取用户列表
		if(opt.equals("userlist")){
			userListByAdmin(request, response);
		}

		//删除用户
		else if(opt.equals("del")){
			delUserByAdmin(request, response);
		}

		//获取用户信息
		else if(opt.equals("show")){
			showUserByAdmin(request, response);
		}
		//编辑用户
		else if(opt.equals("edit")){
			editUserByAdmin(request, response);
		}
		
	}
		
	/**
	 * 管理员登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void loginByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart==null){
			cart = new Cart();
		}
		//获取参数
		String saccount = request.getParameter("saccount");
		String spassword = request.getParameter("spassword");
		//调用登录验证
		UserDaoImpl dao = new UserDaoImpl();
		//AdminDaoImpl dao = new AdminDaoImpl();
		Admin admin = dao.doLoginByAdmin(saccount, spassword);
		 if(admin!=null){
			 //将user对象存入session中,便于前台使用
			 request.getSession().setAttribute("admin", admin);
			 response.sendRedirect("admin.jsp");
			 return;
		 }else{
			 response.sendRedirect("login_admin.jsp");
			 return;
		 }	
		
	}
	
	/**
	 * 获取用户列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void userListByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDaoImpl dao = new UserDaoImpl();
		//AdminDaoImpl dao = new AdminDaoImpl();
		List<Users> ulist = dao.getUserList();
		//获取分页
		Integer page=1;
		String strPage = request.getParameter("page");
		if(StringUtil.isNumber(strPage)==false){
		}else{
			page =Integer.parseInt(strPage);
		}
		//封装成分页对象
		PageBean<Users> Pager = new PageBean<Users>(page,10,ulist);
		request.getSession().setAttribute("ulist", Pager);
		response.sendRedirect("m_admin.jsp");
	}
	
	/**
	 * 删除用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delUserByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(StringUtil.isNumber(request.getParameter("mid"))==false){
			response.sendRedirect("m_admin.jsp");
			return;
		}
		int mid = Integer.parseInt(request.getParameter("mid"));
		UserDaoImpl dao = new UserDaoImpl();
		//AdminDaoImpl dao = new AdminDaoImpl();
		boolean b = dao.delUserByUserId(mid);
		//存入操作信息
		if(b==true){
			request.getSession().setAttribute("ADMIN_MSG_USER","删除成功");
		}else{
			request.getSession().setAttribute("ADMIN_MSG_USER","删除失败");
		}
		userListByAdmin(request, response);
	}
	
	
	/**
	 * 进入编辑用户页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showUserByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(StringUtil.isNumber(request.getParameter("mid"))==false){
			response.sendRedirect("m_admin.jsp");
			return;
		}
		int mid = Integer.parseInt(request.getParameter("mid"));
		UserDaoImpl dao = new UserDaoImpl();
		Users u = dao.getUserById(mid);
		if(u!=null){
			//存入需要编辑用户
			request.getSession().setAttribute("editUser",u);
			response.sendRedirect("useredit.jsp");
		}else{
			response.sendRedirect("m_admin.jsp");
		}
		
	}
	
	
	/**
	 * 编辑用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editUserByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(StringUtil.isNumber(request.getParameter("mid"))==false){
			response.sendRedirect("m_admin.jsp");
			return;
		}
		int mid = Integer.parseInt(request.getParameter("mid"));
		//提取参数
		String maccount = (String) request.getParameter("maccount");
		String mname = (String) request.getParameter("mname");
		String msex = (String) request.getParameter("msex");
		String maddress = (String) request.getParameter("maddress");
		String mphone = (String) request.getParameter("mphone");
		String memail = (String) request.getParameter("memail");
		
		//封装成Users对象
		Users user = new Users();
		user.setMid(mid);
		user.setMaccount(maccount);
		user.setMname(mname);
		user.setMsex(msex);
		user.setMaddress(maddress);
		user.setMphone(mphone);
		user.setMemail(memail);
		
		//调用dao层方法
		UserDaoImpl dao = new UserDaoImpl();
		//AdminDaoImpl dao = new AdminDaoImpl();
		Boolean b = dao.updateUser(user);
		//设置修改信息结果字符串
		if(b)
			request.getSession().setAttribute("ADMIN_MSG_USER", "信息编辑成功,UID:"+mid);
		else
			request.getSession().setAttribute("ADMIN_MSG_USER", "信息编辑失败,UID:"+mid);
			
		userListByAdmin(request, response);
	}

}
