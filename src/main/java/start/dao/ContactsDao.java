package start.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import start.contact.Contacts;

@Repository
@Transactional
public class ContactsDao extends GenericDao<Contacts, Long>{

}
