package root.beans.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import root.beans.person;

@Repository
public class personDaoImp implements personDao {

	@Autowired
	JdbcTemplate template;
	
	public void AddPerson(person p) {
	
  this.template.update("insert into person (id,firstname,lastname,age) values(?,?,?,?)"
		,p.getId(),p.getFirstname(),p.getLastname(),p.getAge());
  
        System.out.println("new Person Added!!!");
		
	}

	public void DeletePerson(int id) {
		this.template.update("delete from person where id = ?",id);
		System.out.println("Person Deleted!!");
		
	}

}
