package br.com.fiap.trafego.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_incidentes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Incidente {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_INCIDENTES"
    )
    @SequenceGenerator(
            name = "SEQ_INCIDENTES",
            sequenceName = "SEQ_INCIDENTES",
            allocationSize = 1
    )
    @Column(name = "id_incidente")
    private Long idIncidente;

    @Column(name = "tipo_incidente")
    private String tipoIncidente;

    private String localizacao;
    private String descricao;

    @Column(name = "data_hora")
    private Timestamp dataHora;

    private String status;

}