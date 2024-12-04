package com.servidorPublico.servidorPublicoDb;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.servidorPublico.servidorPublico.service.ServidorPublicoService;
import com.servidorPublico.servidorPublicoDb.entity.ServidorPublico;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Configuration
public class ServidorPublicoRunner implements CommandLineRunner {
    private ServidorPublicoService servidorService;

    @Autowired
    public void setServidorPublicoService(ServidorPublicoService servidorService) {
        this.servidorService = servidorService;
    }


    public void listAll(){
        List<com.servidorPublico.servidorPublicoDb.entity.ServidorPublico> servidoresPublicos = servidorService.listAll();

        if(!servidoresPublicos.isEmpty()){
            servidoresPublicos.forEach(
                    servidor -> {
                        System.out.println(servidor.getMatricula());
                        System.out.println(servidor.getFoto());
                        System.out.println(servidor.getNome());
                        System.out.println(servidor.getOrgao());
                    });
        }else{
            System.out.println("Lista de servidores publicos vazio");
        }
    }

    public void listByMatricula(){
        long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matricula procurada"));
        Optional<com.servidorPublico.servidorPublicoDb.entity.ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
        if(servidorEncontrado.isPresent()){

            System.out.println(servidorEncontrado.get().getMatricula());
            System.out.println(servidorEncontrado.get().getFoto());
            System.out.println(servidorEncontrado.get().getNome());
            System.out.println(servidorEncontrado.get().getOrgao());

        }else{
            System.out.println("Servidor não encontrado");
        }

    }

    @PostConstruct
    public void save(){
        long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matricula do novo servidor"));
        Optional<com.servidorPublico.servidorPublicoDb.entity.ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
        if(!servidorEncontrado.isPresent()){
            ServidorPublico novoservidor = new ServidorPublico();
            novoservidor.setMatricula(matricula);

            String foto = JOptionPane.showInputDialog("Digite foto do novo servidor");
            String nome = JOptionPane.showInputDialog("Digite nome do novo servidor");
            String orgao = JOptionPane.showInputDialog("Digite orgao do novo servidor");
            String vinculo = JOptionPane.showInputDialog("Digite vinculo do novo servidor");
            String cargo = JOptionPane.showInputDialog("Digite cargo do novo servidor");
            String lotacao = JOptionPane.showInputDialog("Digite lotacao do novo servidor");
            String exercicio = JOptionPane.showInputDialog("Digite exercicio do novo servidor");
            String email = JOptionPane.showInputDialog("Digite email do novo servidor");
            String telefone = JOptionPane.showInputDialog("Digite telefone do novo servidor");
            String celular = JOptionPane.showInputDialog("Digite celular do novo servidor");
            String cpf = JOptionPane.showInputDialog("Digite cpf do novo servidor");
            String naturalidade = JOptionPane.showInputDialog("Digite naturalidade do novo servidor");
            
            novoservidor.setFoto(foto);
            novoservidor.setNome(nome);
            novoservidor.setOrgao(orgao);
            novoservidor.setVinculo(vinculo);
            novoservidor.setCargo(cargo);
            novoservidor.setLotacao(lotacao);
            novoservidor.setExercicio(exercicio);
            novoservidor.setEmail(email);
            novoservidor.setTelefone(telefone);
            novoservidor.setCelular(celular);
            novoservidor.setCpf(cpf);
            novoservidor.setNaturalidade(naturalidade);

            servidorService.save(novoservidor);

        }else{
            System.out.println("Servidor já existente");
        }
    }
    public void update(){
        long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matricula do servidor para ser encontrado"));
        Optional<com.servidorPublico.servidorPublicoDb.entity.ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
        if(servidorEncontrado.isPresent()){
            String nome = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            servidorEncontrado.get().setNome(nome);

            servidorService.update(servidorEncontrado.get());
        }else{
            System.out.println("Servidor não encontrado");
        }
    }
    public void delete(){
        long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matricula do servidor para ser excluido"));
        Optional<com.servidorPublico.servidorPublicoDb.entity.ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
        if(servidorEncontrado.isPresent()){

            servidorService.delete(matricula);
        }else{
            System.out.println("Servidor não encontrado");
        }
    }
    @Override
    public void run(String... args) throws Exception {

    }
}
