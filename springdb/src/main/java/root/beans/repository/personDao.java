package root.beans.repository;

import root.beans.person;

public interface personDao {
	
	public void AddPerson(person p);
	public void DeletePerson(int id);
}
