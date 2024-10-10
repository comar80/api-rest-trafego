// package br.com.fiap.trafego;

// import static org.mockito.ArgumentMatchers.*;
// import static org.mockito.BDDMockito.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.ResultActions;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// import br.com.fiap.trafego.dto.UsuarioCadastroDTO;
// import br.com.fiap.trafego.service.UsuarioService;

// @WebMvcTest
// public class TrafegoApplicationTests {

// 	@Autowired
//     private MockMvc mockMvc;

// 	@MockBean
// 	private UsuarioService service;

// 	// private UsuarioCadastroDTO usuarioCadastroDTO;

// 	// @DisplayName("test create usuario")
//     // @Test
//     // void testGivenNewUsuario_CreateUsuario() throws Exception{
        
//     //     given(service.salvarUsuario(any(UsuarioCadastroDTO.class)))
//     //         .willAnswer((invocation) -> invocation.getArguments()[0]);

//     //     String body = "{\"nome\":\"User1\",\"email\":\"email@email.com\",\"senha\":\"senha123\",\"role\":\"admin\"}";
        
//     //     ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/usuarios")
//     //         .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
//     //         .content(body));

//     //     response.andExpect(status().isCreated());
//     // }

//     @DisplayName("test fail")
//     @Test
//     void testGivenNewUser_whenCreate_thenFail() throws Exception{
//         // fail("Um erro acontecerá");
//     }

// }


package br.com.fiap.trafego;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrafegoApplicationTests {

	@Test
	void contextLoads() {
	}

}
