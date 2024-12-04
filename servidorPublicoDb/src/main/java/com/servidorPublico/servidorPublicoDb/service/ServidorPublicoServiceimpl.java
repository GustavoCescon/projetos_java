package com.servidorPublico.servidorPublicoDb.service;

import com.servidorPublico.servidorPublicoDb.entity.ServidorPublico;
import com.servidorPublico.servidorPublicoDb.repository.ServidorPublicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.servidorPublico.servidorPublico.service.ServidorPublicoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServidorPublicoServiceimpl implements ServidorPublicoService {
    @Autowired
    private ServidorPublicoRepository servidorRepository;

    @Override
    public List<ServidorPublico> listAll() {
        List<ServidorPublico> servidoresPublicos = new ArrayList<>();
        servidorRepository.findAll().forEach(servidoresPublicos::add);
        return servidoresPublicos;
    }

    @Override
    public Optional<ServidorPublico> listByMatricula(long matricula) {
        return servidorRepository.findById(matricula);
    }

    @Override
    public void save(ServidorPublico servidor) {
        servidorRepository.save(servidor);
    }

    @Override
    public void update(ServidorPublico servidor) {
        Optional<ServidorPublico>servidorEncontrado = servidorRepository.findById(servidor.getMatricula());
        servidorEncontrado.ifPresent(p -> {servidorRepository.save(servidor); });
    }

    @Override
    public void delete(long matricula) {
        Optional<ServidorPublico>servidorEncontrado = servidorRepository.findById(matricula);
        servidorEncontrado.ifPresent(p -> {servidorRepository.delete(servidorEncontrado.get()); });
    }
}
