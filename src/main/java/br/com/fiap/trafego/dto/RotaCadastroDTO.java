package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.Rota;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RotaCadastroDTO(
        Long idRota,

        @NotBlank(message = "Origem é obrigatória!")
        String origem,

        @NotBlank(message = "Destino é obrigatório!")
        String destino,

        @NotNull(message = "Distância é obrigatória")
        @Positive
        Double distancia,

        @NotNull(message = "Tempo Médio é obrigatório")
        @Positive
        Double tempoMedio,

        String condicoesEspeciais,

        @NotNull(message = "Velocidade Máxima é obrigatória")
        @Positive
        Integer velocidadeMaximaPermitida
) {
}