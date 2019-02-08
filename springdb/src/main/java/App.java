import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import root.AppConfig;
import root.beans.person;
import root.beans.repository.personDaoImp;
import root.services.personService;

public class App {

	public static void main(String[] args) {
		 
		AnnotationConfigApplicationContext ctx = new
				AnnotationConfigApplicationContext(AppConfig.class);
		
		personService service  = (personService)ctx.getBean("personService");
		person p = new person(70,"first3","last3",88);
		service.AddPerson(p);
		service.DeletePerson(60);
  
	}

}
