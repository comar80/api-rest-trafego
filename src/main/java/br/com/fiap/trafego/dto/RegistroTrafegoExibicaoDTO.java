package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.RegistroTrafego;

import java.sql.Timestamp;

public record RegistroTrafegoExibicaoDTO(
        Long idRegistroTrafego,
        Long idVeiculo,
        Long idMotorista,
        Long idRota,
        Timestamp dataHora,
        Integer velocidadeVeiculo,
        String condicoesMetereologicas,
        String outrosDados

) {

    public RegistroTrafegoExibicaoDTO(RegistroTrafego registroTrafego) {
        this(
                registroTrafego.getIdRegistroTrafego(),
                registroTrafego.getIdVeiculo(),
                registroTrafego.getIdMotorista(),
                registroTrafego.getIdRota(),
                registroTrafego.getDataHora(),
                registroTrafego.getVelocidadeVeiculo(),
                registroTrafego.getCondicoesMetereologicas(),
                registroTrafego.getOutrosDados()
        );
    }

}