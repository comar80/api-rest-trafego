package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.Veiculo;

public record VeiculoExibicaoDTO(
        Long idVeiculo,
        String tipoVeiculo,
        String modelo,
        Integer anoFabricacao,
        String placa,
        String outrosDetalhes
) {

    public VeiculoExibicaoDTO(Veiculo veiculo) {
        this(
                veiculo.getIdVeiculo(),
                veiculo.getTipoVeiculo(),
                veiculo.getModelo(),
                veiculo.getAnoFabricacao(),
                veiculo.getPlaca(),
                veiculo.getOutrosDetalhes()
        );
    }

}