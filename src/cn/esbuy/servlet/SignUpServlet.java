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
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/sign-up.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		try {
			User user = new User();
			user.setUname(request.getParameter("uname"));
			user.setUpwd(request.getParameter("upwd"));
			user.setUsex(request.getParameter("usex"));
			//传入的字符串格式为"yyyy-MM-dd"
			user.setUbirth(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ubirth")));
			user.setUphone(request.getParameter("uphone"));
			user.setUemail(request.getParameter("uemail"));
			user.setUqq(request.getParameter("uqq"));
			boolean flag = userService.addUser(user);
			request.getSession().setAttribute("flag", flag);
			response.sendRedirect("sign-up");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
