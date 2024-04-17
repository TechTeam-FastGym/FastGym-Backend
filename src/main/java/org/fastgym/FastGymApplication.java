package org.fastgym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FastGymApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastGymApplication.class, args);
	}

}
