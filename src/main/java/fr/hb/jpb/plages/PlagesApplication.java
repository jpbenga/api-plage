package fr.hb.jpb.plages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlagesApplication.class, args);
	}

}
