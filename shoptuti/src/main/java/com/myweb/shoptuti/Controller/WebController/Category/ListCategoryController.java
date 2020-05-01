package com.myweb.shoptuti.Controller.WebController.Category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.shoptuti.HibernateDAO.CategoryDAO;
import com.myweb.shoptuti.HibernateDAO.ProductDAO;
import com.myweb.shoptuti.HibernateEntity.Category;
import com.myweb.shoptuti.HibernateEntity.Product;

/**
 * Servlet implementation class ListCategoryController
 */
@WebServlet(urlPatterns = {"/Danh-sach-san-pham"})
public class ListCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResourceBundle bundle = ResourceBundle.getBundle("message");
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("cateid");
			List<Product> list = new ArrayList<>();
			CategoryDAO catedao = new CategoryDAO();
			Category entity = new Category();
			entity = catedao.findCategoryById(Integer.parseInt(id));
			request.setAttribute("catename", entity);
			list = entity.getProductList();
			request.setAttribute("listProduct", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/procate/list.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			String action = request.getParameter("action");
			if(action!=null && action.equals("login")) {
				String message = request.getParameter("message");
				String alert = request.getParameter("alert");
				if(message!=null && alert!=null) {
					request.setAttribute("message", bundle.getString(message));
					request.setAttribute("alert", alert);
				}
				RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);
			}
			else if(action !=null && action.equals("logout")) {
				request.getSession().removeValue("USERMODEL");
				response.sendRedirect(request.getContextPath()+"/trang-chu");
			}
			else if(action!=null && action.equals("register")) {
				String message = request.getParameter("message");
				String alert = request.getParameter("alert");
				if(message!=null && alert!=null) {
					request.setAttribute("message", bundle.getString(message));
					request.setAttribute("alert", alert);
				}
				RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
				rd.forward(request, response);
			}
			else {
				try {
					ProductDAO dao = new ProductDAO();
					List<Product> list = dao.findProductsOrderByDesc();
					request.setAttribute("listProductDESC", list);
				} catch (Exception e) {
					e.printStackTrace();
				}
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
				rd.forward(request, response);
			}	
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
