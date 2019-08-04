package br.com.fiap.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.entity.Pessoa;

public class PessoaDto {

	private Long idPessoa;
	private String nomePessoa;
	private String telefonePessoa;
	private String emailPessoa;

	public PessoaDto(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomePessoa = pessoa.getNomePessoa();
		this.telefonePessoa = pessoa.getTelefonePessoa();
		this.emailPessoa = pessoa.getEmailPessoa();
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getTelefonePessoa() {
		return telefonePessoa;
	}

	public void setTelefonePessoa(String telefonePessoa) {
		this.telefonePessoa = telefonePessoa;
	}

	public String getEmailPessoa() {
		return emailPessoa;
	}

	public void setEmailPessoa(String emailPessoa) {
		this.emailPessoa = emailPessoa;
	}

	public static List<PessoaDto> convert(List<Pessoa> pessoas) {
		return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

}
