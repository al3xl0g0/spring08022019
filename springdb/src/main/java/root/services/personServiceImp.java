package root.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.beans.person;
import root.beans.repository.personDao;
import root.beans.repository.personDaoImp;

@Service("personService")
public class personServiceImp implements personService {

	@Autowired
	personDao dao;
	
	public void AddPerson(person p) {
	  	dao.AddPerson(p);
	}

	public void DeletePerson(int id) {
		dao.DeletePerson(id);
		
	}

}
