package com.leoni.stage;

import com.leoni.stage.services.FileStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@SpringBootApplication
@Controller
public class StageApplication  {

	public static void main(String[] args) {
		SpringApplication.run(StageApplication.class, args);
	}

	@RequestMapping("/")
	public String redirect(){
		return "redirect:/home";
	}

}
