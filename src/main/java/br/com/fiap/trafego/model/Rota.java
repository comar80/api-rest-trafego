package br.com.fiap.trafego.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_rotas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Rota {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ROTAS"
    )
    @SequenceGenerator(
            name = "SEQ_ROTAS",
            sequenceName = "SEQ_ROTAS",
            allocationSize = 1
    )
    @Column(name = "id_rota")
    private Long idRota;

    private String origem;
    private String destino;
    private Double distancia;

    @Column(name = "tempo_medio")
    private Double tempoMedio;

    @Column(name = "condicoes_especiais")
    private String condicoesEspeciais;

    @Column(name = "velocidade_maxima_permitida")
    private Integer velocidadeMaximaPermitida;

}