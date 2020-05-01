package com.myweb.shoptuti.Controller.WebController.Cart;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.shoptuti.HibernateDAO.CartDAO;
import com.myweb.shoptuti.HibernateDAO.CartDetailDAO;
import com.myweb.shoptuti.HibernateEntity.Cart;
import com.myweb.shoptuti.HibernateEntity.CartDetail;
import com.myweb.shoptuti.HibernateEntity.Customers;

/**
 * Servlet implementation class ShoppingCartController
 */
@WebServlet(urlPatterns = { "/CheckOut" })
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			//lay chi tiet gio hang
			List<CartDetail> listcartdetail = cart.getCartdetailList();
			Date today = Calendar.getInstance().getTime();
			Customers customer = (Customers) session.getAttribute("USERMODEL");
			Double total =(Double) session.getAttribute("total");
			if(customer !=null) {
				cart.setCustomer(customer);
				cart.setCreateDate(today);
				cart.setTotal(total);
				CartDAO cartdao = new CartDAO();
				cartdao.insert(cart);
				for (int i = 0; i < listcartdetail.size(); i++) {
					CartDetail cartDetail = new CartDetail();
					cartDetail.setCart(cart);
					cartDetail.setPrice(listcartdetail.get(i).getPrice());
					cartDetail.setQuantity(listcartdetail.get(i).getQuantity());
					cartDetail.setProduct(listcartdetail.get(i).getProduct());
					CartDetailDAO detaildao = new CartDetailDAO();
					detaildao.insert(cartDetail);
				}
				session.removeAttribute("cart");
				session.removeAttribute("total");
				session.removeAttribute("sl");
				response.sendRedirect(request.getContextPath() + "/shopping-cart?message=checkout_success&alert=success");
			}
			else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
			}
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
