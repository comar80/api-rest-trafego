package br.com.fiap.trafego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.fiap.trafego.config.security"})
@EnableJpaRepositories(basePackages = "br.com.fiap.trafego.repository")
public class TrafegoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafegoApplication.class, args);
	}

}
