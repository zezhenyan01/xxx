package zzy.hibernate.cake.mysql;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Environment;

import zzy.hibernate.cake.mysql.pojo.Person;
import zzy.hibernate.cake.mysql.pojo.User;

public class HibernateUtil {
	private static final SessionFactory concreteSessionFactory;
	static {
		try {
			Properties prop= new Properties();
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate_cake");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "");
			prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			prop.setProperty(Environment.SHOW_SQL, "true");
			
			concreteSessionFactory = new AnnotationConfiguration()
		   .addPackage("zzy.hibernate.cake.mysql.pojo")
				   .addProperties(prop)
				   .addAnnotatedClass(User.class)
				   .addAnnotatedClass(Person.class)
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
//		add();
//		get();
//		update();
		persistent();
	}

	private static void persistent() {
		Session session=getSession();
//		session.beginTransaction();
		User user= new User();
		user.setName("test3");
		session.persist(user);
//		session.save(user);
		
		System.out.println("do save");
//		session.flush();
//		session.getTransaction().commit();
		session.close();
		
	}

	private static void update() {
		Session session=getSession();
		session.beginTransaction();
		User user=(User)session.get(User.class, new Integer(4));
		System.out.println("do get");
		user.setName("newname111");
		System.out.println("do setname");
//		session.flush();
//		System.out.println("do flush");
		
		session.getTransaction().commit();
		System.out.println("do commit");
		session.close();
		
	}

	private static void get() {
		Session session=getSession();
		session.beginTransaction();
		User user=(User)session.get(User.class, new Integer(2));
		System.out.println(user.getName());
		session.close();
		
	}

	private static void add() {
		Session session=getSession();
		session.beginTransaction();
		User user= new User();
		user.setName("test2");
		session.save(user);
		System.out.println("do save");
		session.getTransaction().commit();
		session.close();
		
	}
	}