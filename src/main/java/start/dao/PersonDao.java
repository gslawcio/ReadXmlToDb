package start.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import start.model.Person;

@Repository
@Transactional
public class PersonDao extends GenericDao<Person, Long> {

}
