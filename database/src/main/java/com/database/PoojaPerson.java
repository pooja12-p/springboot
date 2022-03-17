package com.database;
	import java.util.Date;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;

	import org.hibernate.annotations.NamedQuery;

	@Entity
	@NamedQuery(name="find_all_persons",query="select p from PoojaPerson p")
	public class PoojaPerson {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	private Date birth_date ;

	public PoojaPerson() {
		
	}

	public PoojaPerson(int id, String name, String location, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birth_date = birthdate;
	}

	public PoojaPerson(String name, String location, Date birthdate) {
		super();
		this.name = name;
		this.location = location;
		this.birth_date = birthdate;
	}

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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirthdate() {
		return birth_date;
	}
	public void setBirthdate(Date birthdate) {
		this.birth_date = birthdate;
	}

	@Override
	public String toString() {
		return "\n PoojaPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthdate=" + birth_date + "]";
	}
	}
