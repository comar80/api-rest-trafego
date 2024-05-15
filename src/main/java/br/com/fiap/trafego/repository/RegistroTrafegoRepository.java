package br.com.fiap.trafego.repository;

import br.com.fiap.trafego.model.RegistroTrafego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroTrafegoRepository extends JpaRepository<RegistroTrafego, Long> {

}
