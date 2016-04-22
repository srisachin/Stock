package com.sachin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sachin.dao.StockDao;
import com.sachin.dao.StockDaoImpl;

@Configuration
public class BeanConfiguration {
	@Bean
	public StockDaoImpl stockDao(){
	  return new StockDaoImpl();
	}

}
