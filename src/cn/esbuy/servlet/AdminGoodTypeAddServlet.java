package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.service.GoodTypeService;
import cn.esbuy.service.impl.GoodTypeServiceImpl;

/**
 * Servlet implementation class AdminGoodTypeAddServlet
 */
public class AdminGoodTypeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GoodTypeService goodtypeService = new GoodTypeServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/admin/goodtype-add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String tname = request.getParameter("tname");
		boolean flag = goodtypeService.addGoodType(tname);
		request.getSession().setAttribute("flag", flag);
		response.sendRedirect("list");
	}

}
