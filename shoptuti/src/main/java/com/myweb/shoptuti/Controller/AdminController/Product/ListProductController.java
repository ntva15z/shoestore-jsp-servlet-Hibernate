package com.myweb.shoptuti.Controller.AdminController.Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.shoptuti.HibernateDAO.ProductDAO;
import com.myweb.shoptuti.HibernateEntity.Product;

@WebServlet(urlPatterns = {"/admin-List-Product"})
public class ListProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer page ;
	Integer maxpageitem;
	Integer totalpage;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			ProductDAO dao  = new ProductDAO();
			String pagestr = request.getParameter("page");
			String maxpageitemstr = request.getParameter("maxPageItem");
			if(pagestr!=null) {
				page = Integer.parseInt(pagestr);
			}
			else {
				page=1;
			}
			if(maxpageitemstr!=null) {
				maxpageitem = Integer.parseInt(maxpageitemstr);
			}
			List<Product> list = dao.findAllProducts();
			double x =(double) list.size()/maxpageitem;
			Integer total = (int) Math.ceil(x);
			session.setAttribute("totalpage", total);
			Integer offset = (page -1)*maxpageitem;
			List<Product> listpage = dao.listResultProducts(offset, maxpageitem);
			
			session.setAttribute("page", page);
			
			request.setAttribute("products", listpage);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/list.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
