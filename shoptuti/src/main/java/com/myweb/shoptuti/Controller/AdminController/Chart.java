package com.myweb.shoptuti.Controller.AdminController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.myweb.shoptuti.HibernateUtils.Utils;

/**
 * Servlet implementation class Chart
 */
@WebServlet("/admin-Chart")
public class Chart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = null;
		String id = request.getParameter("id");
		try {
			if (id.equals("topbuy")) {
				session = Utils.getSessionFactory().openSession();
				String hql = "SELECT cus.Name,SUM(car.Total) FROM Customers cus LEFT JOIN cus.cartList car GROUP BY cus ORDER BY SUM(car.Total) DESC";
				Query<Object[]> query = session.createQuery(hql, Object[].class).setMaxResults(5);
				List<Object[]> list = query.list();
				Map<String, Double> map = new HashMap<String, Double>();
				for (Object[] objects : list) {
					String name = (String) objects[0];
					Double total = (Double) objects[1];

					map.put(name, total);
					request.setAttribute("chart", map);
				}
				request.setAttribute("chart", map);
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/Chart/chart.jsp");
				rd.forward(request, response);
			}
			else if(id.equals("datebuy")) {
				session = Utils.getSessionFactory().openSession();
				String hql = "SELECT car.CreateDate,SUM(car.Total) FROM Cart car  GROUP BY car.CreateDate";
				Query<Object[]> query = session.createQuery(hql, Object[].class);
				List<Object[]> list = query.list();
				SimpleDateFormat format = new SimpleDateFormat("yyyy,MM,dd");
				Map<String, Double> map = new HashMap<String, Double>();
				for (Object[] objects : list) {
					String name = (String) format.format(objects[0]);
					Double total = (Double) objects[1];

					map.put(name, total);
					request.setAttribute("datechart", map);
				}
				request.setAttribute("datechart", map);
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/Chart/datechart.jsp");
				rd.forward(request, response);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
