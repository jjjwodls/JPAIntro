package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//auditing 이 사용되도록 설정.
@EnableJpaAuditing
@SpringBootApplication
public class JpaIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaIntroApplication.class, args);
	}

}
