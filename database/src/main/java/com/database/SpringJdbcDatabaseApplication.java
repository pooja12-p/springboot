package com.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcDatabaseApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("All users ->{}",dao.findAll());
		//logger.info("User id 101 ->{}",dao.findById(101));
		System.out.printf("User id 101 ->{}",dao.findById(101));
		logger.info("deleting 106	 -> No of rows Deleted - {}",dao.deleteById(106));
		logger.info("Inserting 106 ->{}",dao.insert(new PoojaPerson(106,"Runal","Hadapsar", new Date())));
		logger.info("Updating 103 ->{}",dao.update(new PoojaPerson(103,"Sneha","katraj", new Date())));
	}
}
