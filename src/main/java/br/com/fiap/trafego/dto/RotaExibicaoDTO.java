package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.Rota;

public record RotaExibicaoDTO(
        Long idRota,
        String origem,
        String destino,
        Double distancia,
        Double tempoMedio,
        String condicoesEspeciais,
        Integer velocidadeMaximaPermitida
) {

    public RotaExibicaoDTO(Rota rota) {
        this(
                rota.getIdRota(),
                rota.getOrigem(),
                rota.getDestino(),
                rota.getDistancia(),
                rota.getTempoMedio(),
                rota.getCondicoesEspeciais(),
                rota.getVelocidadeMaximaPermitida()
        );
    }

}