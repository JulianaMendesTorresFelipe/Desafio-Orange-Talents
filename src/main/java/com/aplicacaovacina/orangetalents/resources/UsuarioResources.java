package com.aplicacaovacina.orangetalents.resources;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aplicacaovacina.orangetalents.models.Usuario;
import com.aplicacaovacina.orangetalents.models.UsuarioDTO;
import com.aplicacaovacina.orangetalents.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/use")
@Api(value="API REST Aplicacao de vacinas - usuarios")
@CrossOrigin(origins="*")
public class UsuarioResources {
@Autowired
UsuarioRepository usuarioRepository;

@PostMapping("/usuarios")
@ApiOperation(value="Salva usuário")
public ResponseEntity<UsuarioDTO> salvaUsuario(@RequestBody UsuarioDTO usuarioDTO) {
	try {
		Usuario novoUsuario  = usuarioRepository.save(usuarioDTO.toEntity());
		usuarioDTO.setId(novoUsuario.getId());
		return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
	}
    catch (Exception e) {
        System.out.println(e.getMessage());
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
}