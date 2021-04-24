package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.service.GoodService;
import cn.esbuy.service.impl.GoodServiceImpl;

/**
 * Servlet implementation class AdminGoodDeleteServlet
 */
public class AdminGoodDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodService goodService = new GoodServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int gdid = Integer.parseInt(request.getParameter("id"));
		try {
			boolean flag = goodService.removeGood(gdid);
			request.getSession().setAttribute("flag", flag);
		} catch (Exception e) {
			request.getSession().setAttribute("flag", false);
		} finally {
			response.sendRedirect("list");
		}
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
