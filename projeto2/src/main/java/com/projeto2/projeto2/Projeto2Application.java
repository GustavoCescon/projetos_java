package com.projeto2.projeto2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Projeto2Application {

	public static void main(String[] args) {
		SpringApplication.run(Projeto2Application.class, args);
	}
	@GetMapping("/")
	public String init(){
		return (
				"<a href=\"create\" >Create</a> <br />" +
						"<a href=\"read\" >Read</a> <br />" +
						"<a href=\"update\" >Update</a> <br />" +
						"<a href=\"delete\" >Delete</a> <br />"
		);
	}
	@GetMapping("/create")
	public String create(){
		return ("criação do registro");
	}
	@GetMapping("/read")
	public String read(){
		return ("Ler o registro");
	}
	@GetMapping("/update")
	public String update(){
		return ("Atualizar o registro");
	}
	@GetMapping("/delete")
	public String delete(){
		return ("Deletar do registro");
	}

}
