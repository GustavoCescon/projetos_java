package com.servidorPublico.servidorPublico;

import com.servidorPublico.servidorPublico.service.ServidorPublicoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Configuration
public class ServidorPublico implements CommandLineRunner {
    private ServidorPublicoService servidorService;

    @Autowired
    public void setServidorPublicoService(ServidorPublicoService servidorService) {
        this.servidorService = servidorService;
    }
    @PostConstruct
    public void listAll(){
        List<com.servidorPublico.servidorPublico.model.ServidorPublico> servidoresPublicos = servidorService.listAll();

        if(!servidoresPublicos.isEmpty()){
            servidoresPublicos.forEach(
                    servidor -> {
                        System.out.println(servidor.matricula());
                        System.out.println(servidor.foto());
                        System.out.println(servidor.nome());
                        System.out.println(servidor.orgao());
                    });
        }else{
            System.out.println("Lista de servidores publicos vazio");
        }
    }

    @PostConstruct
    public void listByMatricula(){
        long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matricula procurada"));
        Optional<com.servidorPublico.servidorPublico.model.ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
        if(servidorEncontrado.isPresent()){

            System.out.println(servidorEncontrado.get().matricula());
            System.out.println(servidorEncontrado.get().foto());
            System.out.println(servidorEncontrado.get().nome());
            System.out.println(servidorEncontrado.get().orgao());

        }else{
            System.out.println("Servidor não encontrado");
        }


    }

    @Override
    public void run(String... args) throws Exception {

    }
}