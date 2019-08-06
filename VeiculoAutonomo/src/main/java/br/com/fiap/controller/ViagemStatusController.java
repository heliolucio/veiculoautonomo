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

import br.com.fiap.dto.ViagemStatusDto;
import br.com.fiap.entity.ViagemStatus;
import br.com.fiap.form.AtualizarViagemStatusForm;
import br.com.fiap.repository.ViagemStatusRepository;

@RestController
@RequestMapping("/viagemstatus")
public class ViagemStatusController {
	
	@Autowired
	private ViagemStatusRepository viagemStatusRepository;
	
	@GetMapping
	public List<ViagemStatusDto> listarStatus(){
		
		List<ViagemStatus> viagemStatus = viagemStatusRepository.findAll();
		
		return ViagemStatusDto.convert(viagemStatus);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ViagemStatusDto> atualizarStatusViagem(@PathVariable Long id, @RequestBody @Valid AtualizarViagemStatusForm atualizarViagemStatusForm) {
		Optional<ViagemStatus> viagemStatusId = viagemStatusRepository.findById(id);
		if (viagemStatusId.isPresent()) {
			ViagemStatus viagemStatus = atualizarViagemStatusForm.atualizar(id, viagemStatusRepository);
			return ResponseEntity.ok(new ViagemStatusDto(viagemStatus));
		}
		return ResponseEntity.notFound().build();
	}

}
