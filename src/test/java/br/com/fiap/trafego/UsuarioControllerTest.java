package br.com.fiap.trafego;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.fiap.trafego.config.security.TokenService;
import br.com.fiap.trafego.config.security.VerificarToken;
import br.com.fiap.trafego.dto.UsuarioCadastroDTO;
import br.com.fiap.trafego.dto.UsuarioExibicaoDTO;
import br.com.fiap.trafego.model.UsuarioRole;
import br.com.fiap.trafego.service.UsuarioService;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private VerificarToken verificarToken; 

    @MockBean
    private TokenService tokenService;

    @TestConfiguration
    static class TestSecurityConfig {

        @Bean
        public SecurityFilterChain testSecurityFilterChain(HttpSecurity http) throws Exception {
            http.csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                    .anyRequest().permitAll());
            return http.build();
        }
    }

    private UsuarioCadastroDTO usuarioCadastroDTO;
    private UsuarioExibicaoDTO usuarioExibicaoDTO;

    @BeforeEach
    public void setup() {
        usuarioCadastroDTO = new UsuarioCadastroDTO(
                null,
                "John Doe",
                "john.doe@example.com",
                "password123",
                UsuarioRole.USER
        );

        usuarioExibicaoDTO = new UsuarioExibicaoDTO(
                1L,
                "John Doe",
                "john.doe@example.com",
                UsuarioRole.USER
        );
    }

    @WithMockUser(username = "admin", roles = {"ADMIN"})
    @DisplayName("Test create user")
    @Test
    void testGivenNewUser_whenCreate_thenSavedUser() throws Exception {

        given(usuarioService.salvarUsuario(any(UsuarioCadastroDTO.class)))
            .willReturn(usuarioExibicaoDTO);

        String body = """
            {
                "nome": "John Doe",
                "email": "john.doe@example.com",
                "senha": "password123",
                "role": "USER"
            }
        """;

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/usuarios")
            .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
            .content(body));

        response.andExpect(status().isOk());
    }
}


