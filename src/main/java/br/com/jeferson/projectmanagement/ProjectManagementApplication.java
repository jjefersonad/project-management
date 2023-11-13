package br.com.jeferson.projectmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "br.com.jeferson.projectmanagement.domain.entity")
@EnableJpaRepositories(basePackages = "br.com.jeferson.projectmanagement.domain.repository")
@ComponentScan(basePackages = {
		"br.com.jeferson.projectmanagement.infraestructure.controller",
		"br.com.jeferson.projectmanagement.infraestructure.service",
		"br.com.jeferson.projectmanagement.infraestructure.converter",
		"br.com.jeferson.projectmanagement.infraestructure.custom",
})
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

}
