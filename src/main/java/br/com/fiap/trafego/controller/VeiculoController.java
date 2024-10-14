package br.com.fiap.trafego.controller;

import br.com.fiap.trafego.dto.VeiculoCadastroDTO;
import br.com.fiap.trafego.dto.VeiculoExibicaoDTO;
import br.com.fiap.trafego.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/veiculos")
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoExibicaoDTO salvar(
            @RequestBody @Valid VeiculoCadastroDTO veiculo){
        return veiculoService.salvarVeiculo(veiculo);
    }

    @GetMapping("/veiculos/all")
    @ResponseStatus(HttpStatus.OK)
    public Page<VeiculoExibicaoDTO> listarTodos(
            @PageableDefault(size = 5, page = 0)
            Pageable paginacao
    ){
        return veiculoService.listarTodos(paginacao);
    }

    @GetMapping("/veiculos/{veiculoId}")
    public ResponseEntity<VeiculoExibicaoDTO> buscarPorId(
            @PathVariable Long veiculoId){
        try {
            return ResponseEntity.ok(veiculoService.buscarPorId(veiculoId));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/veiculos/placa", params = "placa", method = RequestMethod.GET)
    public ResponseEntity<VeiculoExibicaoDTO> buscarPorPlaca(
            @RequestParam String placa){
        try {
            return ResponseEntity.ok(veiculoService.buscarPorPlaca(placa));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/veiculos/ano", params = "ano", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<VeiculoExibicaoDTO> buscarPorAno(
            @RequestParam Integer ano){
        return veiculoService.buscarPorAno(ano);
    }

    @RequestMapping(value = "/veiculos/anoIntervalo", params = {"anoMinimo", "anoMaximo"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<VeiculoExibicaoDTO> listarVeiculosPorAno(
            @RequestParam Integer anoMinimo,
            @RequestParam Integer anoMaximo
    ){
        return veiculoService.listarVeiculosPorAno(anoMinimo, anoMaximo);
    }

    @PutMapping("/veiculos")
    public ResponseEntity<VeiculoExibicaoDTO> atualizar(
            @RequestBody VeiculoCadastroDTO veiculoDTO){
        try {
            VeiculoExibicaoDTO veiculoExibicaoDTO = veiculoService.atualizar(veiculoDTO);
            return ResponseEntity.ok(veiculoExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/veiculos/{veiculoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long veiculoId){
        veiculoService.excluir(veiculoId);
    }

}
