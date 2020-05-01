package com.myweb.shoptuti.Controller.WebController.Cart;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cartforword
 */
@WebServlet(urlPatterns = {"/shopping-cart"})
public class cartforword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResourceBundle bundle = ResourceBundle.getBundle("message");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		String alert = request.getParameter("alert");
		if(message!=null && alert!=null) {
			request.setAttribute("message", bundle.getString(message));
			request.setAttribute("alert", alert);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/cartdetail/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
