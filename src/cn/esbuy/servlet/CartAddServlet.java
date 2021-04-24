package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.Scar;
import cn.esbuy.entity.User;
import cn.esbuy.service.CartService;
import cn.esbuy.service.impl.CartServiceImpl;

/**
 * Servlet implementation class CartAddServlet
 */
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CartService cartService = new CartServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = ((User) request.getSession().getAttribute("user")).getUid();
		int gdid = Integer.parseInt(request.getParameter("id"));
		Scar scar = new Scar(uid, gdid, 1);
		boolean flag = cartService.addCart(scar);
		request.getSession().setAttribute("flag", flag);
		String fromURL = request.getHeader("Referer"); // 获取请求servlet的url
		response.sendRedirect(fromURL);
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
