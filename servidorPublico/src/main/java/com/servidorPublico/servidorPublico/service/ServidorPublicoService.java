package com.servidorPublico.servidorPublico.service;

import com.servidorPublico.servidorPublico.model.ServidorPublico;

import java.util.List;
import java.util.Optional;

public interface ServidorPublicoService {

    List<ServidorPublico> listAll();

    Optional<ServidorPublico> listByMatricula(long matricula);
}
