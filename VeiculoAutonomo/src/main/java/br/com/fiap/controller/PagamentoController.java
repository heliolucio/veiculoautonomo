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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.dto.PagamentoDto;
import br.com.fiap.entity.Pagamento;
import br.com.fiap.form.PagamentoForm;
import br.com.fiap.repository.PagamentoRepository;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@GetMapping
	public List<PagamentoDto> listaPagamento() {

		List<Pagamento> pagamentos = pagamentoRepository.findAll();

		return PagamentoDto.convert(pagamentos);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PagamentoDto> cadastrarFormaPagamento(@RequestBody @Valid PagamentoForm pagamentoForm, UriComponentsBuilder uriBuilder) {
		Pagamento pagamento = pagamentoForm.convert();
		pagamentoRepository.save(pagamento);

		URI uri = uriBuilder.path("/pagamento/{id}").buildAndExpand(pagamento.getIdPagamento()).toUri();
		return ResponseEntity.created(uri).body(new PagamentoDto(pagamento));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PagamentoDto> listarPagamentoId(@PathVariable Long id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		if (pagamento.isPresent()) {
			return ResponseEntity.ok(new PagamentoDto(pagamento.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerFormaPagamento(@PathVariable Long id) {
		Optional<Pagamento> pagamentoId = pagamentoRepository.findById(id);
		if (pagamentoId.isPresent()) {
			pagamentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
