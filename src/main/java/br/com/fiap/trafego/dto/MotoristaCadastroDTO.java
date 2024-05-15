package br.com.fiap.trafego.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record MotoristaCadastroDTO(
        Long idMotorista,

        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotBlank(message = "O cpf é obrigatório!")
        String cpf,

        String endereco,

        String telefone,

        @NotBlank(message = "O número da CNH é obrigatório!")
        String cnhNumero,

        @NotBlank(message = "A categria da CNH é obrigatória!")
        String cnhCategoria,

        LocalDate cnhValidade
) {
}