package com.bozo.problemtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class ProblemTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProblemTrackerApplication.class, args);
//		String db_user = System.getenv("DB_USER");
//		System.out.println("db_user = " + db_user);
//		Map<String, String> getenv = System.getenv();
//		getenv.forEach((k, v) -> System.out.println("key = " + k + " | value = " + v));
	}

}
