package cn.esbuy.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.User;
import cn.esbuy.service.UserService;
import cn.esbuy.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AdminUserEditServlet
 */
public class AdminUserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("id"));
			User user = userService.getUser(uid);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/admin/user-edit.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		int uid = Integer.parseInt(request.getParameter("uid"));
		User user = new User();
		user.setUname(request.getParameter("uname"));
		user.setUsex(request.getParameter("usex"));
		user.setUphone(request.getParameter("uphone"));
		user.setUemail(request.getParameter("uemail"));
		user.setUqq(request.getParameter("uqq"));
		user.setUid(uid);
		try {
			user.setUbirth(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ubirth")));
			boolean flag = userService.editUser(user);
			request.getSession().setAttribute("flag", flag);
            response.sendRedirect("list");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
