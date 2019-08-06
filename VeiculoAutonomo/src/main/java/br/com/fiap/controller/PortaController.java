package br.com.fiap.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.PortaDto;
import br.com.fiap.entity.Porta;
import br.com.fiap.form.AtualizarPortaForm;
import br.com.fiap.repository.PortaRepository;

@RestController
@RequestMapping("/abrirfechar")
public class PortaController {

	@Autowired
	private PortaRepository portaRepository;
	
	@GetMapping
	public List<PortaDto> listarStatus(){
		
		List<Porta> porta = portaRepository.findAll();
		
		return PortaDto.convert(porta);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PortaDto> atualizarStatus(@PathVariable Long id, @RequestBody @Valid AtualizarPortaForm atualizarPortaForm) {
		Optional<Porta> portaId = portaRepository.findById(id);
		if (portaId.isPresent()) {
			Porta porta = atualizarPortaForm.atualizar(id, portaRepository);
			return ResponseEntity.ok(new PortaDto(porta));
		}
		return ResponseEntity.notFound().build();
	}

}
