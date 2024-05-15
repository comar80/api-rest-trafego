package br.com.fiap.trafego.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_registro_trafego")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RegistroTrafego {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_REGISTRO_TRAFEGO"
    )
    @SequenceGenerator(
            name = "SEQ_REGISTRO_TRAFEGO",
            sequenceName = "SEQ_REGISTRO_TRAFEGO",
            allocationSize = 1
    )
    @Column(name = "registro_id")
    private Long idRegistroTrafego;

    @Column(name = "id_veiculo")
    private Long idVeiculo;

    @Column(name = "id_motorista")
    private Long idMotorista;

    @Column(name = "id_rota")
    private Long idRota;

    @Column(name = "data_hora")
    private Timestamp dataHora;

    @Column(name = "velocidade_veiculo")
    private Integer velocidadeVeiculo;

    @Column(name = "condicoes_metereologicas")
    private String condicoesMetereologicas;

    @Column(name = "outros_dados")
    private String outrosDados;
}