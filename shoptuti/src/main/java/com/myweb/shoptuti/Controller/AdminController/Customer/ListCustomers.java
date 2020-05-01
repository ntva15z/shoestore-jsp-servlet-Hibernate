package com.myweb.shoptuti.Controller.AdminController.Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.shoptuti.HibernateDAO.RoleDAO;
import com.myweb.shoptuti.HibernateEntity.Customers;
import com.myweb.shoptuti.HibernateEntity.Role;

@WebServlet(urlPatterns = { "/admin-List-Customers" })
public class ListCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RoleDAO roledao  = new RoleDAO();
			Role role  = new Role();
			role = roledao.findRoleById(2);
			List<Customers> list = role.getCustomerList();
			request.setAttribute("customer", list);

			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/customer/list.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
