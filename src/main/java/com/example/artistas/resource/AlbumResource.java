package com.example.artistas.resource;

import java.net.URI;
import java.time.Instant;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.artistas.model.dto.AlbumDTO;
import com.example.artistas.resource.exceptions.StandardError;
import com.example.artistas.services.AlbumService;

@RestController
@RequestMapping(value = "/albuns")
public class AlbumResource {

	@Autowired
	private AlbumService service;

	@GetMapping
	public ResponseEntity<List<AlbumDTO>> buscar() {
		List<AlbumDTO> albuns = service.buscarTodos();
		return ResponseEntity.ok().body(albuns);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AlbumDTO> buscarPorId(@PathVariable Integer id) {
		AlbumDTO dto = service.buscarPorId(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<AlbumDTO> salvar(@Valid @RequestBody AlbumDTO dto) {
		dto = service.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AlbumDTO> atualizar(@PathVariable Integer id, @Valid @RequestBody AlbumDTO dto) {
		dto = service.atualizar(dto, id);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id) {
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> handleValidationException(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		err.setError("UNPROCESSABLE_ENTITY");
		err.setMessage("Erro de validação de dados");
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}

}
