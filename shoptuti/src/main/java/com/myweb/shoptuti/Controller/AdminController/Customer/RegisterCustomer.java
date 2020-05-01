package com.myweb.shoptuti.Controller.AdminController.Customer;

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

import com.myweb.shoptuti.Helper.BCrypt;
import com.myweb.shoptuti.HibernateDAO.CustomerDAO;
import com.myweb.shoptuti.HibernateEntity.Customers;
import com.myweb.shoptuti.HibernateEntity.Role;

@WebServlet(urlPatterns = {"/Register-Customer"})
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String customerid;
	private String fullname;
	private String birthday;
	private String email;
	private String phone;
	private String password;
	private String confirm;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("click").equals("reset")) {	
			session.removeAttribute("username");
			session.removeAttribute("fullname");
			session.removeAttribute("birthday");
			session.removeAttribute("email");
			session.removeAttribute("phone");
			session.removeAttribute("password");
			response.sendRedirect(request.getContextPath()+"/dang-ki?action=register");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDAO cusdao = new CustomerDAO();
		BCrypt bCrypt = new BCrypt();
		Date today = Calendar.getInstance().getTime();
		customerid = request.getParameter("username");
		fullname = request.getParameter("fullname");
		boolean gender=true;
		if(request.getParameter("gender").equals("Male")) {
			gender =true;
		}
		if(request.getParameter("gender").equals("Female")) {
			gender =false;
		}
		birthday = request.getParameter("birthday");
		email = request.getParameter("email");
		phone = request.getParameter("phone");
		password = request.getParameter("password");
		confirm = request.getParameter("confirm");
		Customers entity =null;
		
		int roleid = 2;
		try {	
			boolean check=true;
			List<Customers> list = cusdao.findAllCustomers();
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getCustomerId().equals(customerid)) {
					check=false;
					response.sendRedirect(request.getContextPath() + "/dang-ki?action=register&message=check_equal_username&alert=danger");
				}
			}
			if(check==true) {
			entity=new Customers();
			if(customerid==null || customerid.length()<6 ) {
					entity=null;
					response.sendRedirect(request.getContextPath() + "/dang-ki?action=register&message=customerid_match&alert=danger");
			}
			else {
				entity.setCustomerId(customerid);
				session.setAttribute("username", customerid);
			}
			if(fullname==null || fullname.length()==0) {
					entity=null;
					response.sendRedirect(request.getContextPath() + "/dang-ki?action=register&message=fullname_match&alert=danger");
			}
			else {
				entity.setName(fullname);
				session.setAttribute("fullname", fullname);
			}
			if(birthday==null || !birthday.matches("\\d{4}-\\d{1,2}-\\d{1,2}") ) {
					entity=null;
					response.sendRedirect(request.getContextPath() + "/dang-ki?action=register&message=birthday_match&alert=danger");
			}
			else {
				entity.setDOB(birthday);
				session.setAttribute("birthday", birthday);
			}
			entity.setGender(gender);
			if(email==null || !email.matches("\\w+@\\w+(\\.\\w+){1,2}") ) {
					entity=null;
					response.sendRedirect(request.getContextPath() + "/dang-ki?action=register&message=email_match&alert=danger");
			}
			else {
				entity.setEmail(email);
				session.setAttribute("email", email);
			}
			if(phone==null || !phone.matches("0[0-9]{9}")) {
					entity=null;
					response.sendRedirect(request.getContextPath() + "/dang-ki?action=register&message=phone_match&alert=danger");
			}
			else {
				entity.setPhone(phone);
				session.setAttribute("phone", phone);
			}
			if(password ==null || password.length()<6) {
				entity=null;
				response.sendRedirect(request.getContextPath() + "/dang-ki?action=register&message=password_empty&alert=danger");
			}
			else {
				session.setAttribute("password", password);
			}
			if(confirm==null || confirm.length()<6) {
				entity=null;
				response.sendRedirect(request.getContextPath() + "/dang-ki?action=register&message=confirm_empty&alert=danger");
			}
			if(password.equals(confirm)) {
				entity.setPassword(bCrypt.hashpw(password, bCrypt.gensalt()));
			}
			else {
				entity=null;
				response.sendRedirect(request.getContextPath() + "/dang-ki?action=register&message=password_equal_confirm&alert=danger");
			}
			Role role = new Role();
			role.setRoleId(roleid);
			entity.setRole(role);
			entity.setRegistereroledDate(today);
				if(entity!=null) {
					CustomerDAO dao  = new CustomerDAO();
					dao.insert(entity);
					session.removeAttribute("username");
					session.removeAttribute("fullname");
					session.removeAttribute("birthday");
					session.removeAttribute("email");
					session.removeAttribute("phone");
					session.removeAttribute("password");
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
