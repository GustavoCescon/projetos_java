package com.servidorPublico.servidorPublico.model;

public record ServidorPublico(
        Long matricula,
        String foto,
        String nome,
        String orgao,
        String vinculo,
        String cargo,
        String lotacao,
        String exercicio,
        String email,
        String telefone,
        String celular,
        String cpf,
        String naturalidade
) {
}
