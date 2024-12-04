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

    @PostConstruct
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

            String foto = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setFoto(foto);

            String nome = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setNome(nome);

            String orgao = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setOrgao(orgao);

            String vinculo = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setVinculo(vinculo);

            String cargo = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setCargo(cargo);

            String lotacao = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setLotacao(lotacao);

            String exercicio = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setExercicio(exercicio);

            String email = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setEmail(email);

            String telefone = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setTelefone(telefone);

            String celular = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setCelular(celular);

            String cpf = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setCpf(cpf);

            String naturalidade = JOptionPane.showInputDialog(JOptionPane.showInputDialog("Digite foto do novo servidor"));
            novoservidor.setNaturalidade(naturalidade);

        }else{
            System.out.println("Servidor não encontrado");
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
