package com.aplicacaovacina.orangetalents.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aplicacaovacina.orangetalents.models.AplicacaoDeVacina;
import com.aplicacaovacina.orangetalents.models.AplicacaoDeVacinaDTO;
import com.aplicacaovacina.orangetalents.models.Usuario;
import com.aplicacaovacina.orangetalents.repository.AplicacaoDeVacinaRepository;
import com.aplicacaovacina.orangetalents.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/use")// prefixo
@Api(value = "API REST Aplicacao de vacinas")
@CrossOrigin(origins = "*")// qualquer fonte pode acessar a api
public class AplicacaoDeVacinaResouces {
	@Autowired
	AplicacaoDeVacinaRepository aplicacaoDeVacinaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping("/vacinacao")
	@ApiOperation(value = "Salva vacinacao")
	public ResponseEntity<AplicacaoDeVacinaDTO> salvaVacinacao(@RequestBody AplicacaoDeVacinaDTO aplicacaoDeVacinaDTO) {
		try {
			Usuario usuario = usuarioRepository.findByEmail(aplicacaoDeVacinaDTO.getEmailUsuario());
			AplicacaoDeVacina aplicacaoDeVacina = aplicacaoDeVacinaDTO.toEntity(usuario);
			AplicacaoDeVacina novaAplicacao = aplicacaoDeVacinaRepository.save(aplicacaoDeVacina);
			
			aplicacaoDeVacinaDTO.setId(novaAplicacao.getId());
			return new ResponseEntity<>(aplicacaoDeVacinaDTO, HttpStatus.CREATED);
		}
		// ResponseEntity convensão de resposta da req.
        catch (Exception e) {
            System.out.println(e.getMessage());
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

}
