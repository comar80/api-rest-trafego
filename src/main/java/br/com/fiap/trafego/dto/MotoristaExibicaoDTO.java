package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.Motorista;

import java.time.LocalDate;

public record MotoristaExibicaoDTO(
        Long idMotorista,
        String nome,
        String cpf,
        String endereco,
        String telefone,
        String cnhNumero,
        String cnhCategoria,
        LocalDate cnhValidade
) {

    public MotoristaExibicaoDTO(Motorista motorista) {
        this(
                motorista.getIdMotorista(),
                motorista.getNome(),
                motorista.getCpf(),
                motorista.getEndereco(),
                motorista.getTelefone(),
                motorista.getCnhNumero(),
                motorista.getCnhCategoria(),
                motorista.getCnhValidade()
        );
    }

}