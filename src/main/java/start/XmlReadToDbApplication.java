package start;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import start.contact.Contacts;
import start.dao.ContactsDao;
import start.dao.PersonDao;
import start.model.Person;
import start.model.Persons;

@SpringBootApplication
public class XmlReadToDbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(XmlReadToDbApplication.class, args);

		File xmlFile = new File("dane-osoby.xml");
		PersonDao daoPerson = ctx.getBean(PersonDao.class);
		ContactsDao contactsDao = ctx.getBean(ContactsDao.class);
		JAXBContext jaxbContext;

		try {
			jaxbContext = JAXBContext.newInstance(Persons.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Persons persons = (Persons) jaxbUnmarshaller.unmarshal(xmlFile);
			Contacts contacts =(Contacts) jaxbUnmarshaller.unmarshal(xmlFile);
			System.out.println();
			System.out.println(persons);
			System.out.println();
			System.out.println("-----------------------------------------------");
			
			for (Person person : persons.getPersons()) {
				daoPerson.save(person);
				
			}
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		System.out.println(daoPerson.get(1L));
		ctx.close();

	}

}
