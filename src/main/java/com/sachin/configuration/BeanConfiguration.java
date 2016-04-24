package com.sachin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sachin.dao.StockDao;
import com.sachin.dao.StockDaoImpl;
import com.sachin.dao.UserDaoImpl;
import com.sachin.delegate.LoginDelegate;
import com.sachin.service.UserService;
import com.sachin.service.UserServiceImpl;
import java.util.Properties;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class BeanConfiguration {
	@Bean
	public StockDaoImpl stockDao(){
	  return new StockDaoImpl();
	}
	@Bean
	public LoginDelegate loginDelegate(){
	  return new LoginDelegate();
	}
	@Bean
	public UserServiceImpl userService(){
	  return new UserServiceImpl();
	}
	@Bean
	public UserDaoImpl userDao(){
	  return new UserDaoImpl();
	}
	@Bean
	public DriverManagerDataSource dataSource(){		
		
		DriverManagerDataSource ret = new DriverManagerDataSource();
	    ret.setDriverClassName("org.postgresql.Driver");
	    ret.setUsername("postgres");
	    ret.setPassword("sachin");
	    ret.setUrl("jdbc:postgresql://localhost:5432/webapp");
	    return ret;
	}	
}
