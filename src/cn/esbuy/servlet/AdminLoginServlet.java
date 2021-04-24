package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.Admin;
import cn.esbuy.service.AdminService;
import cn.esbuy.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminLoginServlet
 * Description: 后台登录<br/>
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * 1.创建AdminService对象
     */
    private AdminService adminservice = new AdminServiceImpl();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		request.getRequestDispatcher("adlogin.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 	String aname = request.getParameter("aname");
         String apwd = request.getParameter("apwd");
         // 调用业务层方法判断密码是否一致

             boolean flag = adminservice.isLogin(aname, apwd);
             if (flag) {// 密码正确，跳转到index页面
                 Admin admin = adminservice.getAdmin(aname);
                 request.getSession().setAttribute("admin", admin);
                 response.sendRedirect("admin/goodtype/list");
             } else {
                 // 给出提示密码错误
                 request.setAttribute("error", "密码错误");
                 // 重新跳转到管理员登录界面
                 request.getRequestDispatcher("adlogin.jsp").forward(request, response);
             }
    }

}
