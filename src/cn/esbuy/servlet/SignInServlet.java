package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.User;
import cn.esbuy.service.UserService;
import cn.esbuy.service.impl.UserServiceImpl;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/sign-in.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        // 调用业务层方法判断密码是否一致
            boolean flag = userService.isLogin(uname, upwd);
            if (flag) {// 密码正确，跳转到index页面
            		
                User user = userService.getUser(uname);
                request.getSession().setAttribute("user", user);
                response.sendRedirect("index");;
            } else {
            		// 给出提示密码错误
                request.setAttribute("error", "用户名密码错误");
                // 重新跳转到管理员登录界面
                request.getRequestDispatcher("sign-in.jsp").forward(request, response);
            }
	}

}
