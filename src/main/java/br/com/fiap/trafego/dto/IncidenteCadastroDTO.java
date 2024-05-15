package br.com.fiap.trafego.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Timestamp;

public record IncidenteCadastroDTO(
        Long idIncidente,

        @NotBlank(message = "Tipo é obrigatório!")
        String tipoIncidente,

        @NotBlank(message = "Localização é obrigatória!")
        String localizacao,

        @NotBlank(message = "Descrição é obrigatória!")
        String descricao,

        @NotNull(message = "Data e Hora é obrigatório")
        Timestamp dataHora,

        @NotBlank(message = "Status é obrigatório!")
        String status
) {
}