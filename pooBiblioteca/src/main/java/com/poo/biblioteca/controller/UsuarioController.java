package com.poo.biblioteca.controller;

import com.poo.biblioteca.dto.UsuarioDto;
import com.poo.biblioteca.mapper.UsuarioMapper;
import com.poo.biblioteca.model.Usuario;
import com.poo.biblioteca.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(path = "/paginado", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<UsuarioDto> buscarUsuarios(
            UsuarioDto filter,
            @PageableDefault
            @SortDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Usuario> pageUsuario = this.usuarioService.findAll(UsuarioMapper.INSTANCE.dtoParaEntidade(filter), pageable);
        //use map para converter cada entidade para DTO
        Page<UsuarioDto> pageUsuarioDto = pageUsuario.map(UsuarioMapper.INSTANCE::entidadeParaDto);

        return pageUsuarioDto;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDto buscarUsuarioPorId(@PathVariable Long id) {
        var usuario = usuarioService.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario : " + id));
        return UsuarioMapper.INSTANCE.entidadeParaDto(usuario);
    }

    @PostMapping(path = "/salvarUsuario")
    public UsuarioDto salvarUsuario(@RequestBody UsuarioDto usuarioDto) {
        // Mapear o UsuarioDto para a entidade Usuario
        Usuario usuario = UsuarioMapper.INSTANCE.dtoParaEntidade(usuarioDto);

        // Chamar o serviço para criar o usuário com a entidade
        Usuario usuarioCriado = usuarioService.criarUsuario(usuario);

        // Pode retornar o mesmo objeto ou qualquer outra resposta desejada
        // Aqui, estou retornando o UsuarioDto mapeado da entidade criada
        return UsuarioMapper.INSTANCE.entidadeParaDto(usuarioCriado);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDto alterarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.INSTANCE.dtoParaEntidade(usuarioDto);
        Usuario usuarioCriado = usuarioService.saveUpdate(usuario);
        return UsuarioMapper.INSTANCE.entidadeParaDto(usuarioCriado);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }

}