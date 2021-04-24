package cn.esbuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.User;
import cn.esbuy.service.UserService;
import cn.esbuy.service.impl.UserServiceImpl;

/**
 * Servlet implementation class SelectUserServlet
 */

/**
 * 
 * Description: 查询用户信息--手机号或者用户名<br/>
 * date: 2020年2月15日 下午11:12:36 <br/>
 *
 * @author liYan
 * @version
 */
public class AdminUserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keywords = request.getParameter("keywords");
			List<User> list = userService.getList(keywords);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/admin/user.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
