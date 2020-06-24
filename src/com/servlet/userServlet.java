package com.servlet;

import java.io.IOException;
/*import java.util.List;*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDaoImpl;
import entity.Users;


//import cn.svtcc.edu.mybookshop.entity.PageBean;
import com.po.Cart;
//import cn.svtcc.edu.mybookshop.utils.StringUtil;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt = request.getParameter("opt");
		//String role = request.getParameter("role");	
//		if(role!=null && role.equals("3")){
//			optByAdmin(request, response);
//			return;
//		}
		//登录
				if(opt.equals("login")){
					login(request, response);
					return;
				}
				//注册
				else if(opt.equals("register")){
					register(request, response);//s
					return;
				}
//				//是否登录验证
//				if(request.getSession().getAttribute("user")==null){
//					response.sendRedirect("login.jsp");
//					return;
//				}
				//注销
				if(opt.equals("logout")){
					logout(request, response);
				}
				//修改信息
				else if(opt.equals("updateUser")){
					updateUser(request, response);
				}
				//进入个人中心
				else if(opt.equals("show")){
					show(request, response);
				}
	}
    /**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		改成订单页面 不要购物车页面
		//什么意思
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart==null){
			cart = new Cart();
		}
		//获取参数
		String maccount = request.getParameter("maccount");
		String mpassword = request.getParameter("mpassword");
		//调用登录验证
		UserDaoImpl dao = new UserDaoImpl();
		Users user = dao.doLogin(maccount, mpassword);//s
		 if(user!=null){
			 //将user对象存入session中,便于前台使用
			 request.getSession().setAttribute("user", user);
			 response.sendRedirect("product.jsp");
			 return;
		 }else{
			 response.sendRedirect("Login.jsp");
			 return;
		 }	
		
	}
	/**
	 * 用户注销退出
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session中获取用户信息
		Users user = (Users) request.getSession().getAttribute("user");
		if(user!=null){
			request.getSession().removeAttribute("user");
		}
		response.sendRedirect("Login.jsp");
	}
	
	
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("user/user.jsp");
	}
	
	
	/**
	 * 修改用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取提交的参数
		String mid = (String) request.getParameter("mid");
		if(mid==null || "".equals(mid)){
			response.sendRedirect("Login.jsp");
			return;
		}
		String mname = (String) request.getParameter("mname");
		String msex = (String) request.getParameter("msex");
		String mcity = (String) request.getParameter("mcity");
		String maddress = (String) request.getParameter("maddress");
		String mpostcode = (String) request.getParameter("mpostcode");
		String mphone = (String) request.getParameter("mphone");
		String memail = (String) request.getParameter("memail");
		
		
		//封装成Users对象
		Users user = new Users();
		user.setMid(Integer.parseInt(mid));
		user.setMname(mname);
		user.setMsex(msex);
		user.setMcity(mcity);
		user.setMaddress(maddress);
		user.setMpostcode(mpostcode);
		user.setMphone(mphone);
		user.setMemail(memail);
		
		
		//调用dao层方法
		UserDaoImpl dao = new UserDaoImpl();
		Boolean b = dao.updateUser(user);
		//重置session的user信息
		initUser(request, response, Integer.parseInt(mid));
		
		//设置修改信息结果字符串
		if(b)
			request.getSession().setAttribute("MSG_USER_UPDATE_RESULT", "个人资料修改成功");
		else
			request.getSession().setAttribute("MSG_USER_UPDATE_RESULT", "个人资料修改失败");
			
		response.sendRedirect("Login.jsp");	
	}
	/**
	 * 注册用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取提交的参数
		String maccount = request.getParameter("maccount");
		String mpassword = request.getParameter("mpassword");
		String mname = request.getParameter("mname");
		String msex = request.getParameter("msex");
		String mcity = request.getParameter("mcity");
		String maddress = request.getParameter("maddress");
		String mpostcode = request.getParameter("mpostcode");
		String memail = request.getParameter("memail");
		String mphone = request.getParameter("mphone");
		
		//信息完整性校验
		if(maccount==null 
				|| maccount.equals("") 
				|| mpassword==null 
				|| mpassword.equals("") 
				|| memail==null 
				|| memail.equals("")
				|| maddress==null
				|| maddress.equals("")){
			request.getSession().setAttribute("MSG_USER_REGISTER_RESULT", "注册失败:请检查注册信息是否正确");
			response.sendRedirect("register.jsp");
			return;
		}
		
		//封装用户信息成Users对象
		//?
		Users user = new Users(maccount,mpassword,mname,msex,mcity,maddress,mpostcode,mphone,memail);
		//调用dao层方法
		UserDaoImpl dao = new UserDaoImpl();
		//页面跳转
		if(dao.addUser(user)){//s
			response.sendRedirect("Login.jsp");
		}else{
			request.getSession().setAttribute("MSG_USER_REGISTER_RESULT", "注册失败！");
			response.sendRedirect("register.jsp");
		}
		
	}
	
	/**
	 * 初始化用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void initUser(HttpServletRequest request, HttpServletResponse response,int userId) throws ServletException, IOException {
		UserDaoImpl dao = new UserDaoImpl();
		Users user = dao.getUserById(userId);
		//将user设置到session中
		request.getSession().setAttribute("user", user);
	}

}
