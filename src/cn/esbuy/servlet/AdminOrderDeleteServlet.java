package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.service.OrderService;
import cn.esbuy.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class AdminOrderDeleteServlet
 */
public class AdminOrderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private OrderService orderService = new OrderServiceImpl();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		int oid = Integer.parseInt(request.getParameter("id"));
        boolean flag = orderService.removeOrder(oid);
        request.getSession().setAttribute("flag", flag);
    		response.sendRedirect("list");
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
