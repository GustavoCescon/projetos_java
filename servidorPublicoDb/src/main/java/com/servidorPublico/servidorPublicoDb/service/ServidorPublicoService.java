package com.servidorPublico.servidorPublico.service;


import com.servidorPublico.servidorPublicoDb.entity.ServidorPublico;

import java.util.List;
import java.util.Optional;

public interface ServidorPublicoService {

    List<ServidorPublico> listAll();
    Optional<ServidorPublico> listByMatricula(long matricula);
    void save(ServidorPublico servidor);
    void update(ServidorPublico servidor);
    void delete(long matricula);
}
