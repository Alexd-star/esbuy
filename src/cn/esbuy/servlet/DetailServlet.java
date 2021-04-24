package cn.esbuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.Good;
import cn.esbuy.entity.GoodType;
import cn.esbuy.service.GoodService;
import cn.esbuy.service.GoodTypeService;
import cn.esbuy.service.impl.GoodServiceImpl;
import cn.esbuy.service.impl.GoodTypeServiceImpl;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GoodTypeService goodtypeService = new GoodTypeServiceImpl();
	private GoodService goodService = new GoodServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailServlet() {
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
		int gdid = Integer.parseInt(request.getParameter("id"));
		// 查询所有商品信息
		List<GoodType> list = goodtypeService.getList();
		request.setAttribute("goodtype_list", list);
		Good good = goodService.getGood(gdid);
		request.setAttribute("good", good);
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
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
