package cn.esbuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.GoodType;
import cn.esbuy.service.GoodTypeService;
import cn.esbuy.service.impl.GoodTypeServiceImpl;

/**
 * Servlet implementation class AdminGoodTypeServlet
 */
public class AdminGoodTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GoodTypeService goodtypeService = new GoodTypeServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			// 查询所有类别
			List<GoodType> list = goodtypeService.getList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/admin/goodtype.jsp").forward(request, response);

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
