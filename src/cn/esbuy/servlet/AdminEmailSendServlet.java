package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.service.EmailSetService;
import cn.esbuy.service.impl.EmailSetServiceImpl;

/**
 * Servlet implementation class AdminEmailSendServlet
 */
public class AdminEmailSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private EmailSetService emailsetService = new EmailSetServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEmailSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		response.setContentType("text/html; charset=UTF-8");
    		int uid = Integer.parseInt(request.getParameter("id"));
    		boolean flag = emailsetService.sendEmail(uid);
    		//保存提示并跳转
    		request.getSession().setAttribute("flag", flag);
    		String context = request.getContextPath();
    		response.sendRedirect(context + "/admin/order/list");
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
