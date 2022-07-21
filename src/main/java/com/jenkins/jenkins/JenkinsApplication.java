package com.jenkins.jenkins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@Controller
public class JenkinsApplication {

	@Autowired
	TableServiceImpl tableService;

	@PostMapping("/save")
	public TableEntity save(@RequestBody TableEntity entity ){
		TableEntity save = tableService.save(entity);
		return save;

	}

	public static void main(String[] args) {
		SpringApplication.run(JenkinsApplication.class, args);
		System.out.println("hi g");

	}

}
