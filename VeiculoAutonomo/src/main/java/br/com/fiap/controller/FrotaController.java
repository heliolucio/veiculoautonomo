package br.com.fiap.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.dto.FrotaDto;
import br.com.fiap.entity.Frota;
import br.com.fiap.form.AtualizarFrotaForm;
import br.com.fiap.form.FrotaForm;
import br.com.fiap.repository.FrotaRepository;

@RestController
@RequestMapping("/frota")
public class FrotaController {

	@Autowired
	private FrotaRepository frotaRepository;
	
	@GetMapping
	public List<FrotaDto> listaFrota() {
		
		List<Frota> frota = frotaRepository.findAll();
		
		return FrotaDto.convert(frota);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<FrotaDto> cadastrarFrota(@RequestBody @Valid FrotaForm frotaForm, UriComponentsBuilder uriBuilder){
		Frota frota = frotaForm.convert();
		frotaRepository.save(frota);
		
		URI uri = uriBuilder.path("/frota/{id}").buildAndExpand(frota.getIdFrota()).toUri();
		return ResponseEntity.created(uri).body(new FrotaDto(frota));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FrotaDto> listarFrotaId(@PathVariable Long id){
		Optional<Frota> frota = frotaRepository.findById(id);
		if(frota.isPresent()){
			return ResponseEntity.ok(new FrotaDto(frota.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FrotaDto> atualizarFrota(@PathVariable Long id, @RequestBody @Valid AtualizarFrotaForm atualizarFrotaForm){
		Optional<Frota> frotaId = frotaRepository.findById(id);
		if(frotaId.isPresent()){
			Frota frota = atualizarFrotaForm.atualizar(id, frotaRepository);
			return ResponseEntity.ok(new FrotaDto(frota));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerFrota(@PathVariable Long id){
		Optional<Frota> frotaId = frotaRepository.findById(id);
		if(frotaId.isPresent()){
			frotaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
		
}
