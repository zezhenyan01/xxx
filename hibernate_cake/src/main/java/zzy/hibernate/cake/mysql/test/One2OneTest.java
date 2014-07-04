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
		one2oneTestadd();
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
