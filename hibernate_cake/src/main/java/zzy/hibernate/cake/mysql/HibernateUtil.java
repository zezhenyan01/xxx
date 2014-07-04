package zzy.hibernate.cake.mysql;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import zzy.hibernate.cake.mysql.pojo.User;

public class HibernateUtil {
	private static final SessionFactory concreteSessionFactory;
	static {
		try {
			Properties prop= new Properties();
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate_cake");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "");
			prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			
			concreteSessionFactory = new AnnotationConfiguration()
		   .addPackage("zzy.hibernate.cake.mysql.pojo")
				   .addProperties(prop)
				   .addAnnotatedClass(User.class)
				   .buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static Session getSession()
			throws HibernateException {
		return concreteSessionFactory.openSession();
	}
	
	public static void main(String... args){
		Session session=getSession();
		session.beginTransaction();
		User user=(User)session.get(User.class, new Integer(1));
		System.out.println(user.getName());
		session.close();
	}
	}