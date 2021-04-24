package cn.esbuy.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.Order;
import cn.esbuy.entity.OrderDetail;
import cn.esbuy.entity.User;
import cn.esbuy.service.OrderService;
import cn.esbuy.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderAddServlet
 */
public class OrderAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = ((User) request.getSession().getAttribute("user")).getUid();
		Order order = new Order();
		order.setUid(uid);
		order.setOtotal(new BigDecimal(request.getParameter("ototal")));

		String[] gdid = request.getParameterValues("gdid");
		String[] scnum = request.getParameterValues("scnum");
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		for (int i = 0; i < gdid.length; i++) {
			OrderDetail od = new OrderDetail();
			od.setGdid(Integer.parseInt(gdid[i]));
			od.setOdnum(Integer.parseInt(scnum[i]));
			list.add(od);
		}
		if (orderService.addOrder(order, list)) {
			request.getSession().setAttribute("flag", true);
		} else {
			request.getSession().setAttribute("flag", false);
		}
		String context = request.getContextPath();
		response.sendRedirect(context + "/account/myorder");
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
