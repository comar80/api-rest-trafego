package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.Incidente;

import java.sql.Timestamp;

public record IncidenteExibicaoDTO(
        Long idIncidente,
        String tipoIncidente,
        String localizacao,
        String descricao,
        Timestamp dataHora,
        String status
) {

    public IncidenteExibicaoDTO(Incidente incidente) {
        this(
                incidente.getIdIncidente(),
                incidente.getTipoIncidente(),
                incidente.getLocalizacao(),
                incidente.getDescricao(),
                incidente.getDataHora(),
                incidente.getStatus()
        );
    }

}