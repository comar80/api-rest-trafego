package br.com.fiap.trafego.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_motoristas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Motorista {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_MOTORISTAS"
    )
    @SequenceGenerator(
            name = "SEQ_MOTORISTAS",
            sequenceName = "SEQ_MOTORISTAS",
            allocationSize = 1
    )
    @Column(name = "id_motorista")
    private Long idMotorista;

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    @Column(name = "cnh_numero")
    private String cnhNumero;

    @Column(name = "cnh_categoria")
    private String cnhCategoria;

    @Column(name = "cnh_validade")
    private LocalDate cnhValidade;
}