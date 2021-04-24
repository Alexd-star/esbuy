package cn.esbuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.GoodType;
import cn.esbuy.entity.GoodVo;
import cn.esbuy.service.GoodTypeService;
import cn.esbuy.service.GoodService;
import cn.esbuy.service.impl.GoodTypeServiceImpl;
import cn.esbuy.service.impl.GoodServiceImpl;

/**
 * Servlet implementation class AdminGoodServlet
 */
public class AdminGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private GoodService goodService = new GoodServiceImpl();
    private GoodTypeService goodtypeService = new GoodTypeServiceImpl();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        // 查询所有商品信息
        try {
        		List<GoodType> list = goodtypeService.getList();
			request.setAttribute("goodtype_list", list);
            // 查询所有商品保存到List<Good>中
            List<GoodVo> good_list = goodService.getList();
            request.setAttribute("good_list", good_list);
            request.getRequestDispatcher("/admin/good.jsp").forward(request, response);
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
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
