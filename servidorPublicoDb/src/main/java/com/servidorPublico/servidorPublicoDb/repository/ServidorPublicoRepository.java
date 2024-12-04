package com.servidorPublico.servidorPublicoDb.repository;

import com.servidorPublico.servidorPublicoDb.entity.ServidorPublico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorPublicoRepository extends CrudRepository <ServidorPublico, Long>{
}
