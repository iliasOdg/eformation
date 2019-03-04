package org.startup.eformation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.startup.eformation.dao.ApprenantDAO;
import org.startup.eformation.entities.Apprenant;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	ApprenantDAO apprenantDAO;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		Apprenant apprenant = new Apprenant("APPRE02", "AVATAR", new Date(), new Date(), "EMAIL@GMAIL.COM", "EXIBIT", "BOUREIMA",
				"§§EXIBIT££", "ZOZOR", "+336895623");
		apprenantDAO.save(apprenant);
		*/
	}

}
