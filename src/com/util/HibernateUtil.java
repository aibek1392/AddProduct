package com.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.model.Product;
import com.servlets.AddProduct;
public class HibernateUtil {
	private static SessionFactory sf;
	static {
		sf = new Configuration().addAnnotatedClass(Product.class).configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}