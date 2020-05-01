package com.myweb.shoptuti.Controller.WebController.Cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.shoptuti.HibernateEntity.Cart;
import com.myweb.shoptuti.HibernateEntity.CartDetail;

/**
 * Servlet implementation class UpdateCartController
 */
@WebServlet(urlPatterns = {"/Update-Cart"})
public class UpdateCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer sl = 0;
		Double tong = 0.0;
		Cart cart = null;
		List<CartDetail> listcartdetail = null;
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("update")) {
			cart = (Cart) session.getAttribute("cart");
			listcartdetail = cart.getCartdetailList();
			String []quantity = request.getParameterValues("quantity");
			for (int i = 0; i < listcartdetail.size(); i++) {
				listcartdetail.get(i).setQuantity(Integer.parseInt(quantity[i]));
			}
			session.setAttribute("cart", cart);
		}
		for (int i = 0; i < listcartdetail.size(); i++) {
			sl += listcartdetail.get(i).getQuantity();
			tong += listcartdetail.get(i).getQuantity() * listcartdetail.get(i).getPrice();
		}
		session.setAttribute("sl", sl);
		cart.setTotal(tong);
		session.setAttribute("total", cart.getTotal());
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/cartdetail/detail.jsp");
		rd.forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/trang-chu");
	}

}
