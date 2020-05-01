package com.myweb.shoptuti.Controller.AdminController.Product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.shoptuti.HibernateDAO.ProductDAO;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/admin-Delete-Product")
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			
			ProductDAO dao = new ProductDAO();
			dao.delete(Integer.parseInt(id));
			RequestDispatcher rd = request.getRequestDispatcher("/admin-List-Product");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
