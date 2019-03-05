package start.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import start.contact.Contacts;

@Entity
@Table(name = "persons")
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.NONE)
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_person")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "surname")
	private String surname;
	@XmlElement(name = "age")
	private Integer age;
	@XmlElement(name = "city")
	private String city;
	@OneToMany(mappedBy="person")
	private Contacts contacts;

	public Person() {
	}

	public Person(String name, String surname, Integer age, String city) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", city=" + city
				+ "]";
	}

}