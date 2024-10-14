package br.com.fiap.trafego.controller;

import br.com.fiap.trafego.dto.UsuarioCadastroDTO;
import br.com.fiap.trafego.dto.UsuarioExibicaoDTO;
import br.com.fiap.trafego.service.UsuarioService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDTO> listarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioExibicaoDTO> buscarPorId(@PathVariable Long usuarioId){
            return ResponseEntity.ok(usuarioService.buscarPorId(usuarioId));
    }

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO salvar(@RequestBody @Valid UsuarioCadastroDTO usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @RequestMapping(value = "/usuarios/nome", params = "nome", method = RequestMethod.GET)
    public ResponseEntity<UsuarioExibicaoDTO> buscarPorNome(@RequestParam String nome){
        try {
            return ResponseEntity.ok(usuarioService.buscarPorNome(nome));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/usuarios/email", params = "email", method = RequestMethod.GET)
    public ResponseEntity<UsuarioExibicaoDTO> buscarPorEmail(@RequestParam String email){
        try {
            return ResponseEntity.ok(usuarioService.buscarPorEmail(email));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/usuarios/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long usuarioId){
        usuarioService.excluir(usuarioId);
    }

    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDTO atualizar(@RequestBody @Valid UsuarioCadastroDTO usuario){
        return usuarioService.atualizar(usuario);
    }

}