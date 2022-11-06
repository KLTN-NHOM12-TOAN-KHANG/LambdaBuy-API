
package com.example.kltn.SpringAPILambdaBuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.example.kltn.SpringAPILambdaBuy")
public class SpringApiLambdaBuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiLambdaBuyApplication.class, args);
	}
}
