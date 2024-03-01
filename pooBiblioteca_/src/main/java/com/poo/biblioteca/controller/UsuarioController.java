package com.poo.biblioteca.controller;

import com.poo.biblioteca.dto.UsuarioDto;
import com.poo.biblioteca.facade.Admin;
import com.poo.biblioteca.facade.User;
import com.poo.biblioteca.mapper.UsuarioMapper;
import com.poo.biblioteca.model.Usuario;
import com.poo.biblioteca.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5173/")
@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {
    @Autowired
    private User fachadaUser;
    @Autowired
    private Admin fachadaAdmin;

    @Autowired
    public UsuarioController(User fachadaUser, Admin fachadaAdmin) {
        this.fachadaUser = fachadaUser;
        this.fachadaAdmin = fachadaAdmin;
    }

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World";
    }


    @GetMapping(path = "/paginado", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<UsuarioDto> buscarUsuarios(
            UsuarioDto filter,
            @PageableDefault
            @SortDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Usuario> pageUsuario = this.fachadaAdmin.findAll(UsuarioMapper.INSTANCE.dtoParaEntidade(filter), pageable);
        //use map para converter cada entidade para DTO
        Page<UsuarioDto> pageUsuarioDto = pageUsuario.map(UsuarioMapper.INSTANCE::entidadeParaDto);

        return pageUsuarioDto;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDto buscarUsuarioPorId(@PathVariable Long id) {
        var usuario = this.fachadaAdmin.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario : " + id));
        return UsuarioMapper.INSTANCE.entidadeParaDto(usuario);
    }

    @PostMapping(path = "/salvarUsuario")
    public UsuarioDto salvarUsuario(@RequestBody UsuarioDto usuarioDto) {
        // Mapear o UsuarioDto para a entidade Usuario
        Usuario usuario = UsuarioMapper.INSTANCE.dtoParaEntidade(usuarioDto);

        // Chamar o serviço para criar o usuário com a entidade
        Usuario usuarioCriado = this.fachadaUser.criarUsuario(usuario);

        // Pode retornar o mesmo objeto ou qualquer outra resposta desejada
        // Aqui, estou retornando o UsuarioDto mapeado da entidade criada
        return UsuarioMapper.INSTANCE.entidadeParaDto(usuarioCriado);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDto alterarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.INSTANCE.dtoParaEntidade(usuarioDto);
        Usuario usuarioCriado = this.fachadaUser.saveUpdate(usuario);
        return UsuarioMapper.INSTANCE.entidadeParaDto(usuarioCriado);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletarUsuario(@PathVariable Long id) {
        this.fachadaAdmin.deleteById(id);
    }

}