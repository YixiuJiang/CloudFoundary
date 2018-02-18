package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private ApplicationMetaRepository applicationMetaRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationMeta applicationMeta = new ApplicationMeta();
		applicationMeta.setName("Hello World");
		applicationMetaRepository.save(applicationMeta);
	}
}
@RestController
class MessageRestController {
	@Autowired
	private ApplicationMetaRepository applicationMetaRepository;

	@RequestMapping("/hello")
	String getMessage(@RequestParam(value = "name") String name) {
		return applicationMetaRepository.findByName(name).toString();
	}
}
