package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.PessoaDto;
import br.com.fiap.repository.PessoaRepository;

@RestController
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@RequestMapping("/pessoas")
	public List<PessoaDto> listaPessoa() {

		return PessoaDto.convert(this.pessoaRepository.findAll());
	}

}

// List<PessoaDto> pessoasDto = new ArrayList<>();
// PessoaDto pessoaDto = new PessoaDto();
//
// List<Pessoa> pessoa = this.pessoaRepository.findAll();
// for (Pessoa pessoas : pessoa) {
//
// pessoaDto.setIdPessoa(pessoas.getIdPessoa());
// pessoaDto.setNomePessoa(pessoas.getNomePessoa());
// pessoaDto.setTelefonePessoa(pessoas.getTelefonePessoa());
// pessoaDto.setEmailPessoa(pessoas.getEmailPessoa());
//
// pessoasDto.add(pessoaDto);
// }