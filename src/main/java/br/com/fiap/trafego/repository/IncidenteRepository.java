package br.com.fiap.trafego.repository;

import br.com.fiap.trafego.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenteRepository extends JpaRepository<Incidente, Long> {

}
