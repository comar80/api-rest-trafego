package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.RegistroTrafego;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record RegistroTrafegoCadastroDTO(
        Long idRegistroTrafego,

        @NotNull(message = "id do veículo não pode ser nulo")
        Long idVeiculo,

        @NotNull(message = "id do motorista não pode ser nulo")
        Long idMotorista,

        @NotNull(message = "id da rota não pode ser nulo")
        Long idRota,

        @NotNull(message = "Data e Hora é obrigatório")
        Timestamp dataHora,

        Integer velocidadeVeiculo,

        String condicoesMetereologicas,

        String outrosDados

) {
}