package com.myweb.shoptuti.Controller.LoginController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.shoptuti.Helper.BCrypt;
import com.myweb.shoptuti.HibernateDAO.CustomerDAO;
import com.myweb.shoptuti.HibernateEntity.Customers;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/Login-page" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BCrypt bCrypt = new BCrypt();
		CustomerDAO dao = new CustomerDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		Customers entity = new Customers();
		HttpSession session = request.getSession();
		try {
			entity = dao.checkLogin(username);
			if (entity != null) {
				if (bCrypt.checkpw(password, entity.getPassword())) {
					session.setAttribute("USERMODEL", entity);
					if (entity.getRole().getRoleId() == 1) {
						response.sendRedirect(request.getContextPath() + "/admin-home");
					} else {
						response.sendRedirect(request.getContextPath() + "/trang-chu");
					}
				} else {
					response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=password_match&alert=danger");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
