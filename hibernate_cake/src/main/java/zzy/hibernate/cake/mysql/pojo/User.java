package zzy.hibernate.cake.mysql.pojo;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")  
public class User {
	@Id
	@GeneratedValue
	private int id;
		
	@Column(name="name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumns( {
        @JoinColumn(name = "personid", referencedColumnName = "id"),
	})
	private Person person;
	
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}