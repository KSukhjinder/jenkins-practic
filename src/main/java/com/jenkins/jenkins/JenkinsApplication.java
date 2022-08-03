package com.jenkins.jenkins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsApplication {

	@Autowired
	TableServiceImpl tableService;

	@GetMapping("/message")
	public String message(){
		return "Welcome..............";
	}

	@PostMapping("/save")
	public TableEntity save(@RequestBody TableEntity entity ){
		TableEntity save = tableService.save(entity);
		return save;

	}

	public static void main(String[] args) {
		SpringApplication.run(JenkinsApplication.class, args);
		System.out.println("hi from JenkinsApplication");

	}

}
