package start.contact;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import start.model.Person;

@Entity
@Table(name = "contacts")
@XmlRootElement(name = "contacts")
@XmlAccessorType(XmlAccessType.NONE) // NONE nie musz� wszytkie pobiera� dane
public class Contacts implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_contact")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "contacts")
	@Column(name = "phone")
	@XmlElement(name = "phone")
	private List<String> phone;

	@ElementCollection
	@CollectionTable(name = "contacts")
	@Column(name = "email")
	@XmlElement(name = "email")
	private List<String> email;

	@ElementCollection
	@CollectionTable(name = "contacts")
	@Column(name = "icq")
	@XmlElement(name = "icq")
	private List<String> icq;

	@ElementCollection
	@CollectionTable(name = "contacts")
	@Column(name = "jabber")
	@XmlElement(name = "jabber")
	private List<String> jabber;
	
	@ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void setPhone(List<String> phone) {
		this.phone = phone;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public List<String> getIcq() {
		return icq;
	}

	public void setIcq(List<String> icq) {
		this.icq = icq;
	}

	public List<String> getJabber() {
		return jabber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJabber(List<String> jabber) {
		this.jabber = jabber;
	}

	@Override
	public String toString() {
		return "Contacts [id=" + id + ", phone=" + phone + ", email=" + email + ", icq=" + icq + ", jabber=" + jabber
				+ ", person=" + person + "]";
	}

}
