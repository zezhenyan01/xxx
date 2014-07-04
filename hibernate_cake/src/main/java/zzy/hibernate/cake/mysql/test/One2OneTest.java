package zzy.hibernate.cake.mysql.test;

import org.hibernate.Session;

import zzy.hibernate.cake.mysql.HibernateUtil;
import zzy.hibernate.cake.mysql.pojo.Person;
import zzy.hibernate.cake.mysql.pojo.User;

public class One2OneTest extends HibernateUtil{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		one2oneTestadd();
		one2oneTestget();
	}

	private static void one2oneTestget() {
		Session session=getSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, 4);
		System.out.println("get..");
		System.out.println(user.getPerson().getName());
		
		session.close();
		
	
		
	}

	private static void one2oneTestadd() {
		Session session=getSession();
		session.beginTransaction();
		User user = new User();
		user.setName("test1");
		Person person = new Person();
		person.setName("person1");
		person.setUser(user);
		user.setPerson(person);
		System.out.println("do update");
		session.save(user);
		session.getTransaction().commit();
		System.out.println("do commit");
		session.close();
		
	
		
	}

}
