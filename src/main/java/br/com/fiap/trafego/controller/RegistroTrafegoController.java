package br.com.fiap.trafego.controller;

import br.com.fiap.trafego.dto.RegistroTrafegoCadastroDTO;
import br.com.fiap.trafego.dto.RegistroTrafegoExibicaoDTO;
import br.com.fiap.trafego.service.RegistroTrafegoService;
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
public class RegistroTrafegoController {

    @Autowired
    private RegistroTrafegoService registroService;

    @PostMapping("/registros")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroTrafegoExibicaoDTO salvar(
            @RequestBody @Valid RegistroTrafegoCadastroDTO registro){
        return registroService.salvar(registro);
    }

    @GetMapping("/registros")
    @ResponseStatus(HttpStatus.OK)
    public Page<RegistroTrafegoExibicaoDTO> listarTodos(
            @PageableDefault(size = 5, page = 0)
            Pageable paginacao
    ){
        return registroService.listarTodos(paginacao);
    }

    @GetMapping("/registros/{registroId}")
    public ResponseEntity<RegistroTrafegoExibicaoDTO> buscarPorId(
            @PathVariable Long registroId){
        try {
            return ResponseEntity.ok(registroService.buscarPorId(registroId));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/registros")
    public ResponseEntity<RegistroTrafegoExibicaoDTO> atualizar(
            @RequestBody RegistroTrafegoCadastroDTO registroDTO){
        try {
            RegistroTrafegoExibicaoDTO registroExibicaoDTO = registroService.atualizar(registroDTO);
            return ResponseEntity.ok(registroExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/registros/{registroId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long registroId){
        registroService.excluir(registroId);
    }

}
