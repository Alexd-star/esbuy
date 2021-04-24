package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.service.GoodTypeService;
import cn.esbuy.service.impl.GoodTypeServiceImpl;

/**
 * Servlet implementation class AdminGoodTypeDeleteServlet
 */
public class AdminGoodTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GoodTypeService goodtypeService = new GoodTypeServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tid = Integer.parseInt(request.getParameter("id"));
		boolean flag = goodtypeService.deleteGoodType(tid);
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
