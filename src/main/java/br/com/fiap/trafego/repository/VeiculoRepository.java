package br.com.fiap.trafego.repository;

import br.com.fiap.trafego.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Optional<Veiculo> findByPlaca(String placa);

    List<Veiculo> findByAnoFabricacao(Integer anoFabricacao);

    @Query("SELECT v FROM Veiculo v WHERE v.anoFabricacao BETWEEN :minimo AND :maximo ORDER BY v.anoFabricacao DESC")
    List<Veiculo> listarVeiculosPorAno(
            @Param("minimo") Integer minino,
            @Param("maximo") Integer maximo
    );
}
