package cn.esbuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.OrderVo;
import cn.esbuy.service.OrderService;
import cn.esbuy.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class AdminOrderServlet
 */
public class AdminOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private OrderService orderService = new OrderServiceImpl();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                List<OrderVo> list = orderService.getList();
                request.setAttribute("list", list);
                request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
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
