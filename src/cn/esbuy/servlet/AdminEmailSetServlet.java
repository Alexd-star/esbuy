package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.EmailSet;
import cn.esbuy.service.EmailSetService;
import cn.esbuy.service.impl.EmailSetServiceImpl;

/**
 * Servlet implementation class AdminEmailSetServlet
 */
public class AdminEmailSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private EmailSetService emailsetService = new EmailSetServiceImpl();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		EmailSet emailset = emailsetService.getEmailSet();
        request.setAttribute("emailset", emailset);
        request.getRequestDispatcher("/admin/emailset.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmailSet emailset = new EmailSet();
        emailset.setEmaddress(request.getParameter("emaddress"));
        emailset.setEmserver(request.getParameter("emserver"));
        emailset.setEmpasscode(request.getParameter("empasscode"));
        boolean flag = emailsetService.editEmailSet(emailset);
        request.getSession().setAttribute("flag", flag);
        response.sendRedirect("set");

    }

}
