package br.com.fiap.trafego.controller;

import br.com.fiap.trafego.dto.MotoristaCadastroDTO;
import br.com.fiap.trafego.dto.MotoristaExibicaoDTO;
import br.com.fiap.trafego.service.MotoristaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping("/motoristas")
    @ResponseStatus(HttpStatus.CREATED)
    public MotoristaExibicaoDTO salvar(
            @RequestBody @Valid MotoristaCadastroDTO motorista){
        return motoristaService.salvarMotorista(motorista);
    }

    @GetMapping("/motoristas")
    @ResponseStatus(HttpStatus.OK)
    public Page<MotoristaExibicaoDTO> listarTodos(
            @PageableDefault(size = 5, page = 0)
            Pageable paginacao
    ){
        return motoristaService.listarTodos(paginacao);
    }

    @GetMapping("/motoristas/{motoristaId}")
    public ResponseEntity<MotoristaExibicaoDTO> buscarPorId(
            @PathVariable Long motoristaId){
        try {
            return ResponseEntity.ok(motoristaService.buscarPorId(motoristaId));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/motoristas", params = "nome")
    public ResponseEntity<MotoristaExibicaoDTO> buscarPorNome(
            @RequestParam String nome){
        try {
            return ResponseEntity.ok(motoristaService.buscarPorNome(nome));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/motoristas", params = "cpf")
    public ResponseEntity<MotoristaExibicaoDTO> buscarPorCpf(
            @RequestParam String cpf){
        try {
            return ResponseEntity.ok(motoristaService.buscarPorCpf(cpf));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/motoristas")
    public ResponseEntity<MotoristaExibicaoDTO> atualizar(
            @RequestBody MotoristaCadastroDTO motoristaDTO){
        try {
            MotoristaExibicaoDTO motoristaExibicaoDTO = motoristaService.atualizar(motoristaDTO);
            return ResponseEntity.ok(motoristaExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/motoristas/{motoristaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long motoristaId){
        motoristaService.excluir(motoristaId);
    }

}
