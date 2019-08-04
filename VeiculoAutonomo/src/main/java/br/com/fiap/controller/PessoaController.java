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

import br.com.fiap.dto.PessoaDto;
import br.com.fiap.entity.Pessoa;
import br.com.fiap.form.AtualizarPessoaForm;
import br.com.fiap.form.PessoaForm;
import br.com.fiap.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public List<PessoaDto> listarPessoas() {

		List<Pessoa> pessoas = pessoaRepository.findAll();

		return PessoaDto.convert(pessoas);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PessoaDto> cadastrarPessoa(@RequestBody @Valid PessoaForm pessoaForm, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = pessoaForm.convert();
		pessoaRepository.save(pessoa);
		
		URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getIdPessoa()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDto> listarPessoaId(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isPresent()){
			return ResponseEntity.ok(new PessoaDto(pessoa.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaDto> atualizarPessoa(@PathVariable Long id, @RequestBody @Valid AtualizarPessoaForm atualizarPessoaForm){
		Optional<Pessoa> pessoaId = pessoaRepository.findById(id);
		if(pessoaId.isPresent()){
			Pessoa pessoa = atualizarPessoaForm.atualizar(id, pessoaRepository);
			return ResponseEntity.ok(new PessoaDto(pessoa));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerPessoa(@PathVariable Long id){
		Optional<Pessoa> pessoaId = pessoaRepository.findById(id);
		if(pessoaId.isPresent()){
			pessoaRepository.deleteById(id);
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build();
	}
}
