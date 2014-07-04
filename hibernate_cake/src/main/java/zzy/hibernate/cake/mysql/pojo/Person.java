package zzy.hibernate.cake.mysql.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")  
public class Person {
	@Id
	@GeneratedValue
	private int id;
	
	
		
	@Column(name="name")
	private String name;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumns( {
        @JoinColumn(name = "personid", referencedColumnName = "id"),
	})
	private User user;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
