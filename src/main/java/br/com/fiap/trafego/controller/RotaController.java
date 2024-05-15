package br.com.fiap.trafego.controller;

import br.com.fiap.trafego.dto.RotaCadastroDTO;
import br.com.fiap.trafego.dto.RotaExibicaoDTO;
import br.com.fiap.trafego.service.RotaService;
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
public class RotaController {

    @Autowired
    private RotaService rotaService;

    @PostMapping("/rotas")
    @ResponseStatus(HttpStatus.CREATED)
    public RotaExibicaoDTO salvar(
            @RequestBody @Valid RotaCadastroDTO rota){
        return rotaService.salvar(rota);
    }

    @GetMapping("/rotas")
    @ResponseStatus(HttpStatus.OK)
    public Page<RotaExibicaoDTO> listarTodos(
            @PageableDefault(size = 5, page = 0)
            Pageable paginacao
    ){
        return rotaService.listarTodos(paginacao);
    }

    @GetMapping("/rotas/{rotaId}")
    public ResponseEntity<RotaExibicaoDTO> buscarPorId(
            @PathVariable Long rotaId){
        try {
            return ResponseEntity.ok(rotaService.buscarPorId(rotaId));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/rotas")
    public ResponseEntity<RotaExibicaoDTO> atualizar(
            @RequestBody RotaCadastroDTO rotaDTO){
        try {
            RotaExibicaoDTO rotaExibicaoDTO = rotaService.atualizar(rotaDTO);
            return ResponseEntity.ok(rotaExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/rotas/{rotaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long rotaId){
        rotaService.excluir(rotaId);
    }

}
