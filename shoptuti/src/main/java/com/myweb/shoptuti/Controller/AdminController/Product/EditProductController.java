package com.myweb.shoptuti.Controller.AdminController.Product;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.myweb.shoptuti.HibernateDAO.CategoryDAO;
import com.myweb.shoptuti.HibernateDAO.ProductDAO;
import com.myweb.shoptuti.HibernateEntity.Category;
import com.myweb.shoptuti.HibernateEntity.Product;

@WebServlet(urlPatterns = { "/admin-Edit-Product" })
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "D:/Java4/shop/shoptuti/src/main/webapp/img";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");

			ProductDAO dao = new ProductDAO();
			Product entity = dao.findProductById(Integer.parseInt(id));
			request.setAttribute("product", entity);
			

			CategoryDAO catedao = new CategoryDAO();
			List<Category> list = catedao.findAllCategories();
			request.setAttribute("categories", list);

			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/edit.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
//			ServletContext servletContext = this.getServletConfig().getServletContext();
//			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
//			factory.setRepository(repository);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Parse the request
			List<FileItem> items = upload.parseRequest(request);

			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();

			HashMap<String, String> fields = new HashMap<>();
			String imageName = null;
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.isFormField()) {
					fields.put(item.getFieldName(), item.getString());
				} else {
					String filename = item.getName();

					File uploadedFile = new File(UPLOAD_DIRECTORY + File.separator + filename);
					boolean isExist = uploadedFile.exists();
					if (isExist) {
						if(uploadedFile.delete()) {
							item.write(uploadedFile);
						}
					} else {
						item.write(uploadedFile);
					}
					imageName = filename.toString();
				}
			}
			Date today = Calendar.getInstance().getTime();
			Product entity = new Product();
			Category cate = new Category();
			cate.setCategoryId(Integer.parseInt(fields.get("categoryId")));
			entity.setCategory(cate);
			entity.setProductId(Integer.parseInt(fields.get("productId")));
			entity.setName(fields.get("name"));
			entity.setImage(imageName);
			entity.setQuantity(Integer.parseInt(fields.get("quantity")));
			entity.setPrice(Double.parseDouble(fields.get("price")));
			entity.setManufacturedDate(today);
			entity.setStatus(fields.get("status"));
			entity.setDescription(fields.get("description"));

			ProductDAO dao = new ProductDAO();
			dao.update(entity);
			RequestDispatcher rd = request.getRequestDispatcher("/admin-List-Product");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
