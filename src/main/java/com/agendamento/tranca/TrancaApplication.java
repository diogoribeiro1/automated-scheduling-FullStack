package com.agendamento.tranca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages="com.agendamento.tranca.models")
@EnableJpaRepositories(basePackages="com.agendamento.tranca.repositories")
@ComponentScan({"com.agendamento.tranca.controllers", "com.agendamento.tranca.services"})
public class TrancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrancaApplication.class, args);
	}

}
