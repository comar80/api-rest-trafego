package br.com.fiap.trafego.repository;

import br.com.fiap.trafego.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Optional<Motorista> findByNome(String nome);

    Optional<Motorista> findByCpf(String cpf);

}
