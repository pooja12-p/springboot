package com.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDatabaseApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 // TODO Auto-generated method stub
	    //logger.info("All users ->{}",repository.findAll());
	   //logger.info("User id 101 ->{}",repository.findById(101));
	  //logger.info("deleting 107 -> No of rows Deleted - {}",repository.deleteById(107));
	 //logger.info("Inserting 106 ->{}",repository.insert(new PoojaPerson(106,"Runal","Hadapsar", new Date())));
	//logger.info("Updating 103 ->{}",repository.update(new PoojaPerson(103,"Sneha","katraj", new Date())));
   //logger.info("deleting 107	 -> No of rows Deleted - {}",repository.deleteById(107));

		System.out.println("User id 101 ->{}" + repository.findById(101));
		logger.info("All users ->{}");
				//repository.deleteById(102);
		logger.info("Inserting id 102 ->{}",repository.insert(new PoojaPerson(102 ,"pranali","pimpri", new Date())));
		logger.info("Updating id 201 ->{}",repository.update(new PoojaPerson(201,"Priya","Raigad", new Date())));
	}
}
