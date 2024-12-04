package com.servidorPublico.servidorPublico.service;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servidorPublico.servidorPublico.model.ServidorPublico;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class ServidorPublicoServiceimpl implements  ServidorPublicoService{
    private final String SERVIDOR = "/data/servidorpublico.json";
    @Override
    public List<ServidorPublico> listAll() {
        try{
            TypeReference<List<ServidorPublico>> typeref = new TypeReference<List<ServidorPublico>>() {

            };
            InputStream inputStream = TypeReference.class.getResourceAsStream(SERVIDOR);

            return new ObjectMapper().readValue(inputStream, typeref);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public Optional<ServidorPublico> listByMatricula(long matricula) {
        try{
            TypeReference<List<ServidorPublico>> typeref = new TypeReference<List<ServidorPublico>>() {

            };
            InputStream inputStream = TypeReference.class.getResourceAsStream(SERVIDOR);

            List<ServidorPublico>  servidorPublico = new ObjectMapper().readValue(inputStream, typeref);

            Optional<ServidorPublico> servidorEncontrado = servidorPublico.stream().filter(servidor -> servidor.matricula().equals(matricula)
            ).findFirst();

            return servidorEncontrado;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
