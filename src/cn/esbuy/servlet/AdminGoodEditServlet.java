package cn.esbuy.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
import cn.esbuy.utils.FileUpload;

/**
 * Servlet implementation class AdminGoodEditServlet
 */
public class AdminGoodEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GoodTypeService goodtypeService = new GoodTypeServiceImpl();
	private GoodService goodService = new GoodServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int gdid = Integer.parseInt(request.getParameter("id"));
		try {
			List<GoodType> list = goodtypeService.getList();
			request.setAttribute("list", list);
			Good good = goodService.getGood(gdid);
			request.setAttribute("good", good);
			request.getRequestDispatcher("/admin/good-edit.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			Good good = new Good();
			Map<String, String> map = new FileUpload().saveImage(request);
			good.setGdid(Integer.parseInt(map.get("gdid")));
			good.setTid(Integer.parseInt(map.get("tid")));
			good.setGdcode(map.get("gdcode"));
			good.setGdname(map.get("gdname"));
			good.setGdprice(new BigDecimal(map.get("gdprice")));
			good.setGdquantity(Integer.parseInt(map.get("gdquantity")));
			if (map.containsKey("gdimage")) {
				good.setGdimage(map.get("gdimage"));
			}
			good.setGdinfo(map.get("gdinfo"));
			good.setGdcity(map.get("gdcity"));
			boolean flag = goodService.editGood(good);
			request.getSession().setAttribute("flag", flag);
            response.sendRedirect("list");
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();

		}
	}

}
