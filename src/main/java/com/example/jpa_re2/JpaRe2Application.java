package com.example.jpa_re2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaRe2Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaRe2Application.class, args);
	}

}
