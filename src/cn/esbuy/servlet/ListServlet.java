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
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GoodService goodService = new GoodServiceImpl();
    private GoodTypeService goodtypeService = new GoodTypeServiceImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String gdname = request.getParameter("keywords");
		int tid = 0;
		if ( request.getParameter("id") != null ) {
			tid = Integer.parseInt(request.getParameter("id"));
		}
		//根据商品名称模糊查询
		List<GoodType> list = goodtypeService.getList();
		request.setAttribute("goodtype_list", list);
		List<GoodVo> good_list = goodService.getList(tid, gdname);
        request.setAttribute("good_list", good_list);
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
