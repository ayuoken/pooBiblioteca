package com.example.demo.entidade;

import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import com.poo.biblioteca.facade.User;
import com.poo.biblioteca.mapper.UsuarioMapper;
import com.poo.biblioteca.controller.UsuarioController;
import com.poo.biblioteca.dto.UsuarioDto;
import com.poo.biblioteca.facade.Admin;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private User mockFachadaUser;
    @Mock
    private Admin mockFachadaAdmin;

    private UsuarioController usuarioController;

    @BeforeEach
    public void setUp() {
        usuarioController = new UsuarioController(mockFachadaUser, mockFachadaAdmin);
    }

    @Test
    public void testBuscarUsuarios() {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNome("Fulano");
        usuarioDto.setEndereco("Rua ABC, 123");
        usuarioDto.setNumeroContato("123456789");
        usuarioDto.setEmail("fulano@example.com");
        usuarioDto.setLogin("fulano123");
        usuarioDto.setSenha("senha123");

        Page<UsuarioDto> expectedPage = new PageImpl<>(Collections.singletonList(usuarioDto));
        Mockito.when(mockFachadaAdmin.findAll(ArgumentMatchers.any(), ArgumentMatchers.any(Pageable.class)))
                .thenReturn(expectedPage.map(UsuarioMapper.INSTANCE::dtoParaEntidade));

        Page<UsuarioDto> actualPage = usuarioController.buscarUsuarios(usuarioDto, Pageable.unpaged());

        Assertions.assertEquals(expectedPage, actualPage);
    }
    @Test
    public void testIntegracaoBuscarUsuarios() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/usuario/paginado"))
                .andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());
    }
}
