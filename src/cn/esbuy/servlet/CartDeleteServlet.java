package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.service.CartService;
import cn.esbuy.service.impl.CartServiceImpl;

/**
 * Servlet implementation class CartDeleteServlet
 */
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private CartService cartService = new CartServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int scid = Integer.parseInt(request.getParameter("id"));
        try {
            boolean flag = cartService.deleteCart(scid);
            request.getSession().setAttribute("flag", flag);
    		} catch (Exception e) {
    			request.getSession().setAttribute("flag", false);
    		} finally {
    			response.sendRedirect("list");
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
