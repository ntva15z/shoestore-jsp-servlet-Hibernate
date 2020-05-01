package com.myweb.shoptuti.Controller.WebController.Cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.shoptuti.HibernateDAO.ProductDAO;
import com.myweb.shoptuti.HibernateEntity.Cart;
import com.myweb.shoptuti.HibernateEntity.CartDetail;
import com.myweb.shoptuti.HibernateEntity.Product;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet(urlPatterns = { "/AddToCart" })
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProductDAO prodao = new ProductDAO();
			String id = request.getParameter("productId");
			Integer quantity = 1;
			Integer sl = 0;
			Double tong = 0.0;
			List<CartDetail> listcartdetail=null;
			Cart cart = null;
			if (id != null) {
				Product prod = prodao.findProductById(Integer.parseInt(id));
				HttpSession session = request.getSession(true);
				if (session.getAttribute("cart") == null) {
					 cart = new Cart();
					 listcartdetail = new ArrayList<>();
					CartDetail cartdetail = new CartDetail();
					cartdetail.setProduct(prod);
					cartdetail.setQuantity(quantity);
					cartdetail.setPrice(prod.getPrice());
					listcartdetail.add(cartdetail);

					cart.setCartdetailList(listcartdetail);
					session.setAttribute("cart", cart);
				} else {
					 cart = (Cart) session.getAttribute("cart");
					 listcartdetail = cart.getCartdetailList();
					boolean check = false;
					for (CartDetail cartdetail : listcartdetail) {
						if (cartdetail.getProduct().getProductId() == prod.getProductId()) {
							cartdetail.setQuantity(cartdetail.getQuantity() + quantity);
							check = true;
						}
					}
					if(check ==false) {
						CartDetail cartdetail = new CartDetail();
						cartdetail.setProduct(prod);
						cartdetail.setQuantity(quantity);
						cartdetail.setPrice(prod.getPrice());
						listcartdetail.add(cartdetail);
					}
					session.setAttribute("cart", cart);
				}
				
				for (int i = 0; i < listcartdetail.size(); i++) {
					sl += listcartdetail.get(i).getQuantity();
					tong += listcartdetail.get(i).getQuantity()*listcartdetail.get(i).getPrice();
				}
				
				session.setAttribute("sl", sl);
				cart.setTotal(tong);
				session.setAttribute("total", cart.getTotal());
				response.sendRedirect(request.getContextPath() + "/trang-chu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

}
