package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Product;
import com.util.HibernateUtil;

@WebServlet("/addproduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		double price = Double.valueOf(request.getParameter("price"));
		String category = request.getParameter("category");
		Product p = new Product(name, price, category);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		PrintWriter out = response.getWriter();
		try {
			Serializable key = session.save(p);
			System.out.println(key);
			Product p2 = (Product) session.createQuery("from Product where id = " + key).uniqueResult();
			System.out.println(p2);

			tx.commit();
			out.println("<html><body>");
			out.println("<table border='1' width='60%'>");
			out.println("<tr>");
			out.println("<th>Model Id</th> <th>Product Name</th> <th>Price</th><th>Category</th> </tr>");
			out.println("<tr style='text-align:center'>");
			out.println("<td>" + p.getId() + "</td> <td>" + p.getName() + "</td> <td>" + p.getPrice() + "</td> <td>"
					+ p.getCategory() + "</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<button><a  href='add_product.jsp'>Go Back to add another product</a></button>");
			out.println("<button><a  href='index.jsp'>Go Back to Home Page</a></button>");
			out.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
