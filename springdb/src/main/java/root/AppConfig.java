package root;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("root")
@PropertySource(value = "classpath:application.properties")
public class AppConfig {
	@Autowired
	Environment env;
	
	private JdbcTemplate Template;
	
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		datasource.setUrl(env.getRequiredProperty("jdbc.url"));
		datasource.setUsername(env.getRequiredProperty("jdbc.username"));
		datasource.setPassword(env.getRequiredProperty("jdbc.password"));
		
		return datasource;
	}
	
	@Bean
	public JdbcTemplate template(DataSource dataSource) {
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		this.Template = template;
		return template;
		
	}
}
