package cn.esbuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.GoodType;
import cn.esbuy.entity.GoodVo;
import cn.esbuy.service.GoodService;
import cn.esbuy.service.GoodTypeService;
import cn.esbuy.service.impl.GoodServiceImpl;
import cn.esbuy.service.impl.GoodTypeServiceImpl;

/**
 * Servlet implementation class AdminGoodSearchServlet
 */
public class AdminGoodSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GoodService goodService = new GoodServiceImpl();
	private GoodTypeService goodtypeService = new GoodTypeServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminGoodSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		int tid = Integer.parseInt(request.getParameter("tid"));
		String gdname = request.getParameter("gdname");
		try {
			// 查询所有商品保存到List<Good>中
			List<GoodVo> good_list = goodService.getList(tid, gdname);
			// 查询商品类型保存到List<String>中
			List<GoodType> goodtype_list = goodtypeService.getList();
			request.setAttribute("good_list", good_list);
			request.setAttribute("goodtype_list", goodtype_list);
			request.getRequestDispatcher("/admin/good.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
