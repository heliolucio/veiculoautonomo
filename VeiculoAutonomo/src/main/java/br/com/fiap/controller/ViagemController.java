package br.com.fiap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.ViagemDto;
import br.com.fiap.entity.Viagem;
import br.com.fiap.repository.ViagemRepository;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

	@Autowired
	private ViagemRepository viagemRepository;

	@GetMapping
	public List<ViagemDto> listaViagem() {

		List<Viagem> viagens = viagemRepository.findAll();

		return ViagemDto.convert(viagens);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ViagemDto> listarViagemId(@PathVariable Long id) {
		Optional<Viagem> viagem = viagemRepository.findById(id);
		if (viagem.isPresent()) {
			return ResponseEntity.ok(new ViagemDto(viagem.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
