package br.com.fiap.trafego.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record VeiculoCadastroDTO(
        Long idVeiculo,

        @NotBlank(message = "O tipo do veículo é obrigatório!")
        String tipoVeiculo,

        @NotBlank(message = "O modelo é obrigatório!")
        String modelo,

        @NotNull(message = "O ano é obrigatório")
        @Positive
        Integer anoFabricacao,

        @NotBlank(message = "A placa é obrigatória!")
        String placa,

        String outrosDetalhes
) {
}