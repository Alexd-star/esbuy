package cn.esbuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.esbuy.service.UserService;
import cn.esbuy.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserCheckServlet
 */
public class UserCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private UserService userService = new UserServiceImpl();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("uname");
            boolean flag = userService.checkName(uname);
            String jsonResult = "";
            if (flag) {
            		jsonResult = "{\"valid\":false}";
            } else {
            		jsonResult = "{\"valid\":true}";
            }
            response.getWriter().write(jsonResult);
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
