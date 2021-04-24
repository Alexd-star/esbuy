package cn.esbuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.entity.ScarVo;
import cn.esbuy.entity.User;
import cn.esbuy.service.CartService;
import cn.esbuy.service.impl.CartServiceImpl;


/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService cartService = new CartServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int uid = ((User)request.getSession().getAttribute("user")).getUid();
        // 查询当前用户购物车
        try {
        		List<ScarVo> list = cartService.getList(uid);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/account/cart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
