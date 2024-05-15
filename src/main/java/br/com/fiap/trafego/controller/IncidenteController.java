package br.com.fiap.trafego.controller;

import br.com.fiap.trafego.dto.IncidenteCadastroDTO;
import br.com.fiap.trafego.dto.IncidenteExibicaoDTO;
import br.com.fiap.trafego.dto.RotaCadastroDTO;
import br.com.fiap.trafego.dto.RotaExibicaoDTO;
import br.com.fiap.trafego.service.IncidenteService;
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
public class IncidenteController {

    @Autowired
    private IncidenteService incidenteService;

    @PostMapping("/incidentes")
    @ResponseStatus(HttpStatus.CREATED)
    public IncidenteExibicaoDTO salvar(
            @RequestBody @Valid IncidenteCadastroDTO incidente){
        return incidenteService.salvar(incidente);
    }

    @GetMapping("/incidentes")
    @ResponseStatus(HttpStatus.OK)
    public Page<IncidenteExibicaoDTO> listarTodos(
            @PageableDefault(size = 5, page = 0)
            Pageable paginacao
    ){
        return incidenteService.listarTodos(paginacao);
    }

    @GetMapping("/incidentes/{incidenteId}")
    public ResponseEntity<IncidenteExibicaoDTO> buscarPorId(
            @PathVariable Long incidenteId){
        try {
            return ResponseEntity.ok(incidenteService.buscarPorId(incidenteId));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/incidentes")
    public ResponseEntity<IncidenteExibicaoDTO> atualizar(
            @RequestBody IncidenteCadastroDTO incidenteDTO){
        try {
            IncidenteExibicaoDTO incidenteExibicaoDTO = incidenteService.atualizar(incidenteDTO);
            return ResponseEntity.ok(incidenteExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/incidentes/{incidenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long incidenteId){
        incidenteService.excluir(incidenteId);
    }

}
