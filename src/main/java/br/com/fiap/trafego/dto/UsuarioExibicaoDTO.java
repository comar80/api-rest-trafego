package br.com.fiap.trafego.dto;

import br.com.fiap.trafego.model.Usuario;
import br.com.fiap.trafego.model.UsuarioRole;

public record UsuarioExibicaoDTO(
        Long usuarioId,
        String nome,
        String email,
        UsuarioRole role
) {

    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()
        );
    }
}