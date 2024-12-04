package com.mensagem.mensagem;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class MensagemApplication {

	public static void main(String[] args) {
		//System.setProperty("java.awt.headless", "false");
		//SpringApplication.run(MensagemApplication.class, args);
		//JOptionPane.showMessageDialog(null, "Mensagem Application Started");

		//CRUD
		//create();
		//read();
		//update();
		//delete();

	}

	@PostConstruct
	public static void create(){
		System.out.println("criação do registro");
	}
	@PostConstruct
	public static void read(){
		System.out.println("Ler o registro");
	}
	@PostConstruct
	public static void update(){
		System.out.println("Atualizar o registro");
	}
	@PostConstruct
	public static void delete(){
		System.out.println("Deletar do registro");
	}


}
