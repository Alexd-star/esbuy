package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.GoodType;
import cn.esbuy.service.GoodTypeService;
import cn.esbuy.service.impl.GoodTypeServiceImpl;

/**
 * Servlet implementation class AdminGoodTypeEditServlet
 */
public class AdminGoodTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GoodTypeService goodtypeService = new GoodTypeServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tid = Integer.parseInt(request.getParameter("id"));
		GoodType goodtype = goodtypeService.getGoodType(tid);
		request.setAttribute("goodtype", goodtype);
		request.getRequestDispatcher("/admin/goodtype-edit.jsp").forward(request, response);
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
		int tid = Integer.parseInt(request.getParameter("tid"));
		GoodType goodtype = new GoodType(tid, tname);
		boolean flag = goodtypeService.updateGoodType(goodtype);
		request.getSession().setAttribute("flag", flag);
		response.sendRedirect("list");
	}

}
