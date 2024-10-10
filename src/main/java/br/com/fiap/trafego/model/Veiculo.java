package br.com.fiap.trafego.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_veiculos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Veiculo {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VEICULOS")
        @SequenceGenerator(name = "SEQ_VEICULOS", sequenceName = "SEQ_VEICULOS", allocationSize = 1)
        @Column(name = "id_veiculo")
        private Long idVeiculo;

        @Column(name = "tipo_veiculo")
        private String tipoVeiculo;

        private String modelo;

        @Column(name = "ano_fabricacao")
        private Integer anoFabricacao;

        private String placa;

        @Column(name = "outros_detalhes")
        private String outrosDetalhes;
}