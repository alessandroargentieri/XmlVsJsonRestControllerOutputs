package com.quicktutorialz.learnmicroservices.XmlVsJsonData;

import com.quicktutorialz.learnmicroservices.XmlVsJsonData.daos.TaskDao;
import com.quicktutorialz.learnmicroservices.XmlVsJsonData.daos.UserDao;
import com.quicktutorialz.learnmicroservices.XmlVsJsonData.entities.Task;
import com.quicktutorialz.learnmicroservices.XmlVsJsonData.entities.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@Log
@SpringBootApplication
public class XmlVsJsonDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlVsJsonDataApplication.class, args);
	}


	@Autowired TaskDao taskDao;
	@Autowired UserDao userDao;

	@PostConstruct
	private void initDatabase() {

		log.info("***** Database insertion using @PostConstruct");

		userDao.save(new User(null, "Is", 30));
		userDao.save(new User(null, "Es", 35));

		taskDao.save(new Task(null, "do stuff by Is", null, 3));
		taskDao.save(new Task(null, "do things by Is", null, 3));
		taskDao.save(new Task(null, "do something by Is", null, 3));

		taskDao.save(new Task(null, "do stuff by Es", null, 4));
		taskDao.save(new Task(null, "do things by Es", null, 4));
		taskDao.save(new Task(null, "do something by Es", null, 4));

		log.info("----- END: Database insertion using @PostConstruct");

	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {

				log.info("***** Database insertion using CommandLineRunner");

				userDao.save(new User(null, "Al", 30));
				userDao.save(new User(null, "El", 35));

				taskDao.save(new Task(null, "do stuff by Al", null, 1));
				taskDao.save(new Task(null, "do things by Al", null, 1));
				taskDao.save(new Task(null, "do something by Al", null, 1));

				taskDao.save(new Task(null, "do stuff by El", null, 2));
				taskDao.save(new Task(null, "do things by El", null, 2));
				taskDao.save(new Task(null, "do something by El", null, 2));

				log.info("----- END: Database insertion using CommandLineRunner");
			}
		};


	}

}
